package jonathanHughes.htmlReader.webpage.manipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.manipuation.CssDeclarationManipulator;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.util.CssDeclarationUtil;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.controller.resetEntities.input.CssRuleChangeEntity;
import jonathanHughes.htmlReader.webpage.controller.resetEntities.input.CssRuleChangeEntityList;
import jonathanHughes.htmlReader.webpage.layout.row.extraction.WebpageRowExtractor;
import jonathanHughes.htmlReader.webpage.layout.row.manipulation.WebpageRowManipulator;
import jonathanHughes.htmlReader.webpage.layout.row.model.WebpageRows;
import jonathanHughes.htmlReader.webpage.model.Webpage;

public class WebpageManipulator {
	
	private Webpage webpage;
	private CssDeclarationManipulator cssDeclarationManipulator;
	private WebpageRowExtractor rowExtractor;
	private WebpageRowManipulator rowManipulator;
	private CssDeclarationUtil cssDeclarationUtil;
	
	public WebpageManipulator(Webpage webpage) {
		this.webpage = webpage;
		this.rowExtractor = new WebpageRowExtractor(webpage.getCssRules());
		this.cssDeclarationManipulator = new CssDeclarationManipulator();
		this.cssDeclarationUtil = new CssDeclarationUtil();
	}
	
	public HashSet<CssRuleSet> editListOfCssRuleSets(List<CssRuleChangeEntityList> ruleChanges) {
		HashSet<CssRuleSet> editedRuleList = new HashSet<CssRuleSet>();
		for (CssRuleChangeEntityList cssRuleChange : ruleChanges) {
			for (CssRuleChangeEntity ruleChange : cssRuleChange.getRuleSet()) {
			    editedRuleList.addAll(editCssRuleSets(cssRuleChange.getSelector(), ruleChange));
			}
		}
		return editedRuleList;
	}
	
	public List<CssRuleSet> editCssRuleSets(String selector, CssRuleChangeEntity cssDeclarationToChange) {		
	    CssRuleSet ruleSet = webpage.getCssRules().getCssRuleSet(selector);
		return editCssRuleSet(ruleSet, cssDeclarationToChange.getProperty(), cssDeclarationToChange.getValue());
	}

	public List<CssRuleSet> editCssRuleSet(CssRuleSet ruleSet, String property, String value) {
		List<CssRuleSet> editedRuleSets = new ArrayList<CssRuleSet>();
		ArrayList<String> values = new ArrayList<String>();
				
		if (ruleSet != null) {
			values.add(value);
			if (property.equalsIgnoreCase("width")) {
				editedRuleSets.addAll(editSiblingRuleSets(ruleSet, property, value));
			}
			editedRuleSets.add(cssDeclarationManipulator.changeProperty(ruleSet, property, values));
		}
		
		return editedRuleSets;
	}
	
	public List<CssRuleSet> editCssRuleSetWidth(String selector, String value) {
		CssRuleSet ruleSet = webpage.getCssRules().getCssRuleSet(selector);
		List<CssRuleSet> editedRuleSets = new ArrayList<CssRuleSet>();
		if (ruleSet != null) {
			ArrayList<String> values = new ArrayList<String>();
			String property = "width";
			if (ruleSet != null) {
				values.add(value);
				if (!ruleSet.getSelector().contains(",")) {
					editedRuleSets.addAll(editSiblingRuleSets(ruleSet, property, value));
				}
				editedRuleSets.add(cssDeclarationManipulator.changeProperty(ruleSet, property, values));
			}
		}
		return editedRuleSets;
	}
	
	@SuppressWarnings("unused")
	private List<CssRuleSet> editParentRuleSet(CssRuleSet ruleSet, String property, String value){
		List<CssRuleSet> edditedRuleSets = new ArrayList<CssRuleSet>();
		CssRuleSet parentRuleSet = webpage.getParentRuleSetOf(ruleSet.getSelector());
		if (parentRuleSet != null) {
			edditedRuleSets.addAll(editCssRuleSet(parentRuleSet, property, value));
		}
		return edditedRuleSets;
	}
	
	private List<CssRuleSet> editSiblingRuleSets(CssRuleSet ruleSet, String property, String value) {
		List<CssRuleSet> editedRuleSets = new ArrayList<CssRuleSet>();
		TagPair parentTag = webpage.getHtmlTags().getParentTagPair(ruleSet.getSelector());
		if (parentTag != null) {
			List<TagPair> siblingTags = parentTag.getInnerTagPairList();
			String siblingSelector = ruleSet.getSelector();
			
			double originalWidth = cssDeclarationUtil.getWidthValueOfDeclaraitonAsDouble(ruleSet.getCssDelaration("width"));
			double newWidth = cssDeclarationUtil.getWidthValueAsDouble(value);
			
			String parentCssClass = cssDeclarationUtil.getParentClassFrom(siblingSelector);
			if (originalWidth != newWidth) {
				List<WebpageRows> rows = rowExtractor.extract(siblingTags, parentCssClass);
				rowManipulator = new WebpageRowManipulator(webpage.getCssRules(), rows);
				editedRuleSets = rowManipulator.rowElementWidthChange(ruleSet, originalWidth, newWidth);
			}
		}
		return editedRuleSets;
	}
		
}
