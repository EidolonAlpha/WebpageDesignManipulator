package jonathanHughes.htmlReader.webpage.controller.resetEntities.output;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;

public class EditedCssReturnEntity {
	
	String oldSelector;
	String newRuleSet;
	
	public EditedCssReturnEntity(String oldSelector, CssRuleSet ruleSet) {
		this.oldSelector = oldSelector;
		if (ruleSet.getSelector().startsWith("#")) {
			 ruleSet.setSelector("." + ruleSet.getSelector().substring(1));
		}
		this.newRuleSet = ruleSet.toString();
	}

	public String getOldSelector() {
		return oldSelector;
	}

	public void setOldSelector(String oldSelector) {
		this.oldSelector = oldSelector;
	}

	public String getNewRuleSet() {
		return newRuleSet;
	}

	public void setNewRuleSet(String newRuleSet) {
		this.newRuleSet = newRuleSet;
	}
	
}
