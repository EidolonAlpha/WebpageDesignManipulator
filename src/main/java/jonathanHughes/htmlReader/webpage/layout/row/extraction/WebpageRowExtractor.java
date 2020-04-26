package jonathanHughes.htmlReader.webpage.layout.row.extraction;

import java.util.ArrayList;
import java.util.List;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.util.CssDeclarationUtil;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;
import jonathanHughes.htmlReader.webpage.layout.row.model.WebpageRows;
import jonathanHughes.htmlReader.webpage.model.CssRuleContainer;

public class WebpageRowExtractor {
	
	private CssRuleContainer cssRules;
	private CssDeclarationUtil cssDeclarationUtil;

	public WebpageRowExtractor(CssRuleContainer cssRules) {
		this.cssRules = cssRules;
		this.cssDeclarationUtil = new CssDeclarationUtil();
	}
	
	public List<WebpageRows> extract(List<TagPair> siblingTagPairs, String parentCssClass) {
		List<WebpageRows> webpageRows = new ArrayList<WebpageRows>();
		WebpageRows currentRow = new WebpageRows(100);
		boolean canFitInRow = true;
		CssRuleSet ruleSet = null;
		for (TagPair tagPair : siblingTagPairs) {
			TagAtribute classAttribute = tagPair.getStartTag().getTagAttribute("class");
			if (classAttribute != null) {
				ruleSet = cssRules.getCssRuleSet(parentCssClass + "." + classAttribute.getValue());
			}
			else if (tagPair.getStartTag().getTagValue() != null) {
				ruleSet = cssRules.getCssRuleSet(tagPair.getStartTag().getTagValue());
			}
			if (ruleSet != null) {
				double width = cssDeclarationUtil.getWidthValueOfDeclaraitonAsDouble(ruleSet.getCssDelaration("width"));
				canFitInRow = currentRow.addSiblingToRow(tagPair, width);
				if (!canFitInRow) {
					webpageRows.add(currentRow);
					currentRow = new WebpageRows(100);
					currentRow.addSiblingToRow(tagPair, width);
				}	
			}
		}
		webpageRows.add(currentRow);
		return webpageRows;
	}

}
