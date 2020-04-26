package jonathanHughes.htmlReader.webpage.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jonathanHughes.htmlReader.webpage.builder.WebpageBuilder;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model.CssDeclaration;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.controller.resetEntities.input.CssRuleChangeEntity;
import jonathanHughes.htmlReader.webpage.controller.resetEntities.input.CssRuleChangeEntityList;
import jonathanHughes.htmlReader.webpage.controller.resetEntities.output.CssReturnEntity;
import jonathanHughes.htmlReader.webpage.controller.resetEntities.output.EditedCssReturnEntity;
import jonathanHughes.htmlReader.webpage.manipulation.WebpageManipulator;
import jonathanHughes.htmlReader.webpage.model.CssRuleContainer;
import jonathanHughes.htmlReader.webpage.model.Webpage;

public class WebpageService {
	
	private final static Logger LOGGER = Logger.getLogger(WebpageService.class.getName());
	
	private Webpage webpage = new Webpage();
	private WebpageBuilder webpageBuilder = new WebpageBuilder(webpage);
	private WebpageManipulator webpageManipulator;
	private ObjectMapper mapper = new ObjectMapper();
	private boolean htmlExtracted = false;
	
	public boolean extractHTML(String htmlString) {
		LOGGER.info("Starting HTML extraction");
		long startTime = System.nanoTime();
		long endTime;
		long duration;
		webpage.setTagPairList(webpageBuilder.buildWebpageTagPairListFrom(htmlString.replace("\\", "")));
		endTime = System.nanoTime();
		duration = (endTime - startTime)/ 1000000000;
		LOGGER.info("Finished HTML extraction in :" + duration);
		if (webpage.getHtmlTags().getTagPairList().size() > 0) {
			htmlExtracted = true;
			return htmlExtracted;
		}
		return false;
	}
	
	public boolean extractCSS(String cssString) throws JsonMappingException, JsonProcessingException {
		LOGGER.info("Starting CSS extraction");
		long startTime = System.nanoTime();
		long endTime;
		long duration;
		CssReturnEntity cssList = mapper.readValue(cssString, new TypeReference<CssReturnEntity>(){});
		webpage.setCSSRuleSetList(webpageBuilder.buildWebpageCSSRuleSetListFrom(cssList.getRules(), cssList.getLinks()));
		webpage  = webpageBuilder.getWebpage();
		endTime = System.nanoTime();
		duration = (endTime - startTime)/ 100000000;
		LOGGER.info("Finished CSS extraction in :" + duration);
		if (webpage.getCssRules().getCssRuleSetList() != null) {
			return true;
		}
		return false;
	}
	
	public List<EditedCssReturnEntity> saveCssChanges(String cssString) throws JsonMappingException, JsonProcessingException {
		LOGGER.info("Starting CSS change Detection");
		CssReturnEntity cssList = mapper.readValue(cssString, new TypeReference<CssReturnEntity>(){});
		//Setup new Webpage
		Webpage newWebpage = new Webpage();
		newWebpage.setHtmlTags(webpage.getHtmlTags());
		newWebpage.setCSSRuleSetList(webpageBuilder.buildWebpageCSSRuleSetListFrom(cssList.getRules(), cssList.getLinks()));
		LOGGER.info("New Webpage setup for comparison");
		List<CssRuleSet> changeCssRules = findCssDifferences(newWebpage.getCssRules().getCssRuleSetList());
		LOGGER.info("Finished CSS change Detections " + changeCssRules.size() + " change(s) found");
		return makeCssChanges(changeCssRules);
	}
	
	private List<CssRuleSet> findCssDifferences(List<CssRuleSet> cssRuleSetList) {
		//Find changed Rules
		List<CssRuleSet> changedCssRulesets = new ArrayList<CssRuleSet>();
		CssRuleContainer existingCssRules = webpage.getCssRules();
		for (CssRuleSet ruleSet : cssRuleSetList) {
			if (!ruleSet.getSelector().isEmpty()) {
				CssRuleSet existingRuleSet = existingCssRules.getCssRuleSet(ruleSet.getSelector());
				if (existingRuleSet != null) {
					if (!ruleSet.toString().equals(existingRuleSet.toString())) {
						if (!ruleSet.toString().startsWith("@")) {
							changedCssRulesets.add(ruleSet);
						}
					}
				}
			}
		}
		return changedCssRulesets;
	}
	
	public boolean saveHtmlChanges(String htmlString) {
		LOGGER.info("Starting HTML extraction");
		long startTime = System.nanoTime();
		long endTime;
		long duration;
		webpage.setTagPairList(webpageBuilder.buildWebpageTagPairListFrom(htmlString.replace("\\", "")));
		endTime = System.nanoTime();
		duration = (endTime - startTime)/ 1000000000;
		LOGGER.info("Finished HTML extraction in :" + duration);
		if (webpage.getHtmlTags().getTagPairList().size() > 0) {
			htmlExtracted = true;
			return htmlExtracted;
		}
		return false;
	}

	private List<EditedCssReturnEntity> makeCssChanges(List<CssRuleSet> changeCssRules) {
		List<CssRuleChangeEntityList> changedEntityList = new ArrayList<CssRuleChangeEntityList>();
		for (CssRuleSet cssRuleSet : changeCssRules) {
			List<CssRuleChangeEntity> entites = new ArrayList<CssRuleChangeEntity>();
			String selector = cssRuleSet.getFullSelector();
			CssRuleChangeEntity changeEntity;
			for (CssDeclaration declaration : cssRuleSet.getCssDeclaration()) {
				changeEntity = new CssRuleChangeEntity();
				changeEntity.setProperty(declaration.getProperty());
				changeEntity.setValue(declaration.getValuesAsString());
				entites.add(changeEntity);
			}
			changedEntityList.add(new CssRuleChangeEntityList(selector,entites));
		}
		
		List<EditedCssReturnEntity> returnEntityList = new ArrayList<EditedCssReturnEntity>();
		webpageManipulator = new WebpageManipulator(webpage);
		if (webpage != null) {
			if (htmlExtracted) {
				HashSet<CssRuleSet> ruleSetList = webpageManipulator.editListOfCssRuleSets(changedEntityList);
				for (CssRuleSet cssRuleSet : ruleSetList) {
					EditedCssReturnEntity returnEntity = new EditedCssReturnEntity(cssRuleSet.getFullSelector(), cssRuleSet);
					returnEntityList.add(returnEntity);
				}
			}
		}
		return returnEntityList;
	}

}
