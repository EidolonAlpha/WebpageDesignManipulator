package jonathanHughes.htmlReader.webpage.components.css.ruleset.manipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.manipuation.CssDeclarationManipulator;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.model.CssRuleContainer;

public class CssRuleSetContainerManipulator {
	
	private final static Logger LOGGER = Logger.getLogger(CssRuleSetContainerManipulator.class.getName());
	
	private CssRuleContainer cssRules;
	private CssDeclarationManipulator cssDeclarationManipulator = new CssDeclarationManipulator();
	
	public CssRuleSetContainerManipulator(CssRuleContainer cssRules) {
		this.cssRules = cssRules;
	}

	public List<CssRuleSet> editCssRuleSets(TagPair parentTag, String property, String value, String selector) {				
	    CssRuleSet ruleSet = cssRules.getCssRuleSet(selector);
		return editCssRuleSet(parentTag, ruleSet, property, value);
	}

	public List<CssRuleSet> editCssRuleSet(TagPair parentTag, CssRuleSet ruleSet, String property, String value) {
		List<CssRuleSet> edditedRuleSets = new ArrayList<CssRuleSet>();
		ArrayList<String> values = new ArrayList<String>();
		CssRuleSet editedRuleSet;		
		if (ruleSet != null) {
			if (property.equalsIgnoreCase("width")) {
				values.add(value + " !important");
				edditedRuleSets.addAll(editSiblingRuleSets(parentTag,ruleSet, property, value));
			}
			editedRuleSet = cssDeclarationManipulator.changeProperty(ruleSet, property, values);
			edditedRuleSets.add(editedRuleSet);
			LOGGER.info("Edited Rule Set" + editedRuleSet.toString());
		}
		
		return edditedRuleSets;
	}
	
	private List<CssRuleSet> editSiblingRuleSets(TagPair parentTag, CssRuleSet ruleSet, String property, String value) {
		LOGGER.info("Editing Sibling RuleSets");
		List<CssRuleSet> editedRuleSets = new ArrayList<CssRuleSet>();
		List<TagPair> siblingTags = parentTag.getInnerTagPairList();
		String parentCssClass = ruleSet.getSelector().substring(0, ruleSet.getSelector().lastIndexOf("."));
		List<TagPair> filteredPairs = findSiblingsWithLessThanMaxWidt(siblingTags, parentCssClass);
		for (TagPair sibling : filteredPairs) {
			CssRuleSet siblingRuleSet = cssRules.getCssRuleSet(parentCssClass + "." + sibling.getStartTag().getTagAttribute("class").getValue());
			String width = siblingRuleSet.getCssDelaration("width").getValues().get(0);
			double originalWidth = Double.parseDouble(width.substring(0, width.length() - 1));
			double widthValue = Double.parseDouble(value.substring(0,value.length() -1));
			double widthChangePerSibling = widthValue/ (filteredPairs.size());
			if (widthValue > originalWidth) {
				LOGGER.info("Increasing Width by" + widthChangePerSibling);
				editedRuleSets.add(cssDeclarationManipulator.increaseWidth(siblingRuleSet, String.valueOf(widthChangePerSibling)+"%"));
			}
			else {
				LOGGER.info("Increasing Width by" + (-widthChangePerSibling));
				editedRuleSets.add(cssDeclarationManipulator.increaseWidth(siblingRuleSet, String.valueOf(-widthChangePerSibling)+"%"));
			}
		}
		return editedRuleSets;
	}
	
	private List<TagPair> findSiblingsWithLessThanMaxWidt(List<TagPair> siblingTags, String cssParentClass){
		LOGGER.info("Filtering out siblings with Max width");
		List<TagPair> filteredTagPairs = new ArrayList<TagPair>();
		for (TagPair sibling : siblingTags) {
			CssRuleSet siblingRuleSet = cssRules.getCssRuleSet(cssParentClass + "." + sibling.getStartTag().getTagAttribute("class").getValue());
			double widthValue = Double.parseDouble(siblingRuleSet.getCssDelaration("width").getValues().get(0).replace("%", ""));
			if (widthValue < 100) {
				filteredTagPairs.add(sibling);
				LOGGER.info("Detected Tag sibling " + sibling.getStartTag());
			}
		}
		return filteredTagPairs;
	}

}
