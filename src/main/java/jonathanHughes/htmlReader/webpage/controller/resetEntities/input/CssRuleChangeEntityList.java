package jonathanHughes.htmlReader.webpage.controller.resetEntities.input;

import java.util.List;

public class CssRuleChangeEntityList {

	private String selector;
	private List<CssRuleChangeEntity> ruleSet;

	public CssRuleChangeEntityList(String selector, List<CssRuleChangeEntity> entites) {
		this.selector = selector;
		this.ruleSet = entites;
	}

	public List<CssRuleChangeEntity> getRuleSet() {
		return ruleSet;
	}

	public void setRuleSet(List<CssRuleChangeEntity> ruleChanges) {
		this.ruleSet = ruleChanges;
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}
	
	
	
}
