package jonathanHughes.htmlReader.webpage.layout.row.manipulation;

import java.util.ArrayList;
import java.util.List;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.manipuation.CssDeclarationManipulator;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model.CssDeclaration;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.util.CssDeclarationUtil;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.util.PositionValues;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;
import jonathanHughes.htmlReader.webpage.layout.row.model.WebpageRows;
import jonathanHughes.htmlReader.webpage.model.CssRuleContainer;

public class WebpageRowManipulator {
	
	private CssDeclarationManipulator cssDeclarationManipulator = new CssDeclarationManipulator();
	private CssDeclarationUtil cssDeclarationUtil = new CssDeclarationUtil();
	private List<WebpageRows> rows;
	private CssRuleContainer cssRules;

	public WebpageRowManipulator(CssRuleContainer cssRules, List<WebpageRows> rows) {
		this.cssRules = cssRules;
		this.rows = rows;
	}

	public List<CssRuleSet> rowElementWidthChange(CssRuleSet ruleSet, double originalWidth, double newWidth) {
		List<CssRuleSet> editedRuleSets = new ArrayList<CssRuleSet>();
		String parentCssClass = cssDeclarationUtil.getParentClassFrom(ruleSet.getSelector());
		for (WebpageRows row : rows) {
			double widthChangePerSibling = 0;
			if (newWidth > originalWidth) {
				widthChangePerSibling = (newWidth - originalWidth)/ (row.getSiblingTagsInRow().size() - 1);
			}
			else {
				widthChangePerSibling = (originalWidth - newWidth)/ (row.getSiblingTagsInRow().size() - 1);
			}
			 
			for (TagPair sibling : row.getSiblingTagsInRow()) {	
				CssRuleSet siblingRuleSet = getSiblingRuleSet(sibling, parentCssClass);
				if (isRuleSetAffected(row, ruleSet, siblingRuleSet)) {
					if (newWidth > originalWidth) {
						widthChangePerSibling = -widthChangePerSibling;
					}
					editedRuleSets.add(cssDeclarationManipulator.increaseWidth(siblingRuleSet, String.valueOf(widthChangePerSibling)+"%"));
				}
			}
		}
		return editedRuleSets;
	}
	
	private boolean isRuleSetAffected(WebpageRows row, CssRuleSet ruleSet, CssRuleSet siblingRuleSet) {
		if (siblingRuleSet.getSelector().equals(ruleSet.getSelector())) {
			return false;
		}
		else {
			CssDeclaration positionDeclaration = siblingRuleSet.getCssDelaration("position");
			if (cssDeclarationUtil.getPositionPropertyValueOf(positionDeclaration).equals(PositionValues.Absolute)) {
				return false;
			}
			if (!row.contains(ruleSet.getSelector())) {
				return false;
			}
		}
		return true;
	}
	
	private CssRuleSet getSiblingRuleSet(TagPair sibling, String parentCssClass) {
		TagAtribute cssClass = sibling.getStartTag().getTagAttribute("class");
		if (cssClass != null) {
			return cssRules.getCssRuleSet(parentCssClass + "." + cssClass.getValue());
		}
		else {
			return cssRules.getCssRuleSet(sibling.getStartTag().getTagValue());
		}
	}

}
