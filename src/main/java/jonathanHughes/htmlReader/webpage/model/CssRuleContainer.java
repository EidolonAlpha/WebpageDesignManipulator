package jonathanHughes.htmlReader.webpage.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.service.WebpageService;

public class CssRuleContainer {
	
	private final static Logger LOGGER = Logger.getLogger(CssRuleContainer.class.getName());
	
	private List<CssRuleSet> cssRuleSetList;
	
	public CssRuleContainer(List<CssRuleSet> cssRuleSetList) {
		this.cssRuleSetList = cssRuleSetList;
	}

	public CssRuleSet getCssRuleSet(String selector) {
		LOGGER.info("Searching for Ruleset with Selector : " + selector);
		for (CssRuleSet cssRuleSet : cssRuleSetList) {
			if (cssRuleSet.getSelector().length() > 0) {
				String existingSelector = cssRuleSet.getSelector();
				if (selector!= null) {
					selector.replace(".", "");
					selector.replace("#", "");
					if (existingSelector.equalsIgnoreCase(selector)) {
						return cssRuleSet;
					}
					if (existingSelector.lastIndexOf(",") > 0) {
						if (existingSelector.substring(existingSelector.lastIndexOf(",")).equalsIgnoreCase(selector)) {
							return cssRuleSet;
						}
					}
					if (existingSelector.contains(selector)) {
						return cssRuleSet;
					}
				}

			}
		}
		return null;
	}
	
	public List<String> getCssRuleSetListAsStringList() {
		List<String> cssRuleStringSet = new ArrayList<String>();
		for (CssRuleSet cssRuleSet : cssRuleSetList) {
			cssRuleStringSet.add(cssRuleSet.toString());
		}
		return cssRuleStringSet;
	}
	
	public List<String> getCssRuleSetListAsStringListNoMedia() {
		List<String> cssRuleStringSet = new ArrayList<String>();
		for (CssRuleSet cssRuleSet : cssRuleSetList) {
			cssRuleStringSet.add(cssRuleSet.toStringNoMedia());
		}
		return cssRuleStringSet;
	}
	
	public String getCssRuleSetListAsString() {
		String cssText = "";
		for (CssRuleSet cssRuleSet : cssRuleSetList) {
			cssText += cssRuleSet.toString();
		}
		return cssText;
	}
	
	public void editRuleInRulesetList(int index, CssRuleSet editedRuleSet) {
		this.cssRuleSetList.set(index, editedRuleSet);
	}
	
	public int getCssRuleIndex(String selector) {
		for (int i = 0; i < cssRuleSetList.size(); i++) {
			if (cssRuleSetList.get(i).getSelector().equalsIgnoreCase(selector)) {
				return i;
			}
		}
		return -1;
	}
	
	public List<CssRuleSet> getInnerCssRuleset(String parentRulesetSelector){
		List<CssRuleSet> innerCssRuleset = new ArrayList<CssRuleSet>();
		for (CssRuleSet cssRuleSet : cssRuleSetList) {
			if (cssRuleSet.getSelector().startsWith(parentRulesetSelector)) {
				innerCssRuleset.add(cssRuleSet);
			}
		}
		return innerCssRuleset;
		
	}

	public List<CssRuleSet> getCssRuleSetList() {
		return cssRuleSetList;
	}
	
}
