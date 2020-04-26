package jonathanHughes.htmlReader.webpage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jonathanHughes.htmlReader.webpage.builder.WebpageBuilder;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.manipuation.CssDeclarationManipulator;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.model.Webpage;

public class WebpageModificationTest {
	
	private WebpageBuilder webpageBuilder = new WebpageBuilder(new Webpage());
	
	@Test
	public void findSubRulesSetFromParentSelector() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String cssStringList = "[\".gallery { height: 100px; background-color: rgb(204, 204, 204); }\",\".content { height: 200px; background-color: rgb(238, 238, 238); }\",\".sidebar { height: 200px; background-color: rgb(170, 170, 170); }\",\".middle { display: flex; flex-flow: row wrap; }\",\".middle.layout-1 .gallery { order: 1; width: 100%; }\",\".middle.layout-1 .content { order: 3; width: 75%; }\",\".middle.layout-1 .sidebar { order: 2; width: 25%; }\",\".middle.layout-2 { position: relative; }\",\".middle.layout-2 .gallery { width: 75%; margin-left: 25%; }\",\".middle.layout-2 .content { width: 75%; margin-left: 25%; }\",\".middle.layout-2 .sidebar { position: absolute; top: 0px; left: 0px; width: 25%; height: 100%; }\"]";
		List<String> cssList = mapper.readValue(cssStringList, new TypeReference<List<String>>(){});
		Webpage webpage = new Webpage();
		webpage.setCSSRuleSetList(webpageBuilder.buildWebpageCSSRuleSetListFrom(cssList, new ArrayList<String>()));
		List<CssRuleSet> innerRuleSets = webpage.getCssRules().getInnerCssRuleset(".middle.layout-1");
		CssDeclarationManipulator cssDeclarationManipulator = new CssDeclarationManipulator();
		CssRuleSet newRuleSet = cssDeclarationManipulator.changeWidth(innerRuleSets.get(1), "50%");
		innerRuleSets.set(1, newRuleSet);
		int indexOfEditedRule = webpage.getCssRules().getCssRuleIndex(newRuleSet.getSelector());
		webpage.getCssRules().editRuleInRulesetList(indexOfEditedRule, newRuleSet);
		assertEquals(".middle.layout-1.content { order: 3; width: 50%; }", innerRuleSets.get(1).toString());
	}
	
}
