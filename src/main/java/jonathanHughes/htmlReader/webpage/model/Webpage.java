package jonathanHughes.htmlReader.webpage.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;

public class Webpage {
	
	private HtmlTagContainer htmlTagContainer;
	private CssRuleContainer cssRuleContainer;
	private Map<String, CssRuleSet> changedCssRuleSets = new HashMap<String, CssRuleSet>();
	
	public void setTagPairList(List<TagPair> tagPairList) {
		this.htmlTagContainer =  new HtmlTagContainer(tagPairList);
	}
		
	public void setHtmlTags(HtmlTagContainer htmlTags) {
		this.htmlTagContainer = htmlTags;
	}

	public HtmlTagContainer getHtmlTags() {
		return htmlTagContainer;
	}

	public CssRuleContainer getCssRules() {
		return cssRuleContainer;
	}

	public void setCSSRuleSetList(List<CssRuleSet> cssRuleSet) {
		this.cssRuleContainer = new CssRuleContainer(cssRuleSet);
	}
	
	public void addEditedRuleSet(String originalSelector, CssRuleSet editedRuleSet) {
		changedCssRuleSets.put(originalSelector, editedRuleSet);
	}

	public Map<String, CssRuleSet> getChangedCssRuleSets() {
		return changedCssRuleSets;
	}
	
	public List<String> getChangedCssRuleSetsAsString() {
		List<String> changedCssRuleSetString = new ArrayList<String>();
		for (Entry<String, CssRuleSet> cssRuleSet : changedCssRuleSets.entrySet()) {
			changedCssRuleSetString.add("OriginalSelector:" + cssRuleSet.getKey() + " newRule:" + cssRuleSet.getValue());
		}
		return changedCssRuleSetString;
	}
			
	public CssRuleSet getParentRuleSetOf(String selector) {
		Tag parentTag = htmlTagContainer.getParentTag(selector);
		if (parentTag != null) {
			String parentSelector = htmlTagContainer.getTagSelector(parentTag);
			return cssRuleContainer.getCssRuleSet(parentSelector);
		}
		return null;
	}
	
	public List<CssRuleSet> getSiblingRuleSetOf(String selector) {
		List<CssRuleSet> siblingRuleSets = new ArrayList<CssRuleSet>();
		List<TagPair> tagPairsWithClassName = htmlTagContainer.getTagPairWithCssClass(selector);
		if (tagPairsWithClassName.size() > 0) {
			List<Tag> siblingTags = tagPairsWithClassName.get(0).getParentTag().getInnerTagList();
			for (Tag siblngTag : siblingTags) {
				String siblingSelector = htmlTagContainer.getTagSelector(siblngTag);
				siblingRuleSets.add(cssRuleContainer.getCssRuleSet(siblingSelector));
			}
			return siblingRuleSets;
		}
		return null;
	}
	
}
