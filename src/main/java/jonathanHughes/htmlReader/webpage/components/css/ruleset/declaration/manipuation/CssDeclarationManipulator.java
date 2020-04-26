package jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.manipuation;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model.CssDeclaration;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;

public class CssDeclarationManipulator {
	
	private final static Logger LOGGER = Logger.getLogger(CssDeclarationManipulator.class.getName());
	
	public CssRuleSet changeProperty(final CssRuleSet ruleSet, final String property, final List<String> newValues) {
		LOGGER.info("Change Property " + property + " of ruleset " + ruleSet);
		CssRuleSet editedRuleSet = ruleSet;
		List<CssDeclaration> cssDeclarationList = ruleSet.getCssDeclaration();
		editedRuleSet.setCssDeclarationList(editDeclarationValue(cssDeclarationList, property, newValues));
		LOGGER.info("Successfully Changed Property " + property + " of ruleset " + ruleSet);
		return editedRuleSet;
	}
	
	private List<CssDeclaration> editDeclarationValue(List<CssDeclaration> cssDeclarationList, final String property, final List<String> newValues) {
		for (CssDeclaration cssDeclaration : cssDeclarationList) {
			if (cssDeclaration.getProperty().equalsIgnoreCase(property)) {
				cssDeclaration.setValues(newValues);
				return cssDeclarationList;
			}
		}
		cssDeclarationList.add(new CssDeclaration(property, newValues));
		return cssDeclarationList;
	}
	
	public CssRuleSet changeWidth(final CssRuleSet ruleSet, final String newWidth) {
		return changeProperty(ruleSet, "width", Arrays.asList(newWidth));
	}
	
	public CssRuleSet increaseWidth(final CssRuleSet ruleSet, final String newWidth) {
		if (newWidth.endsWith("%")) {
			double widthDouble = Double.valueOf(newWidth.substring(0, newWidth.length() - 1));
			String originalWidthString = ruleSet.getCssDelaration("width").getValues().get(0).replace("%", "");
			originalWidthString = originalWidthString.replace("!important", "");
			double originalWidth = Double.valueOf(originalWidthString);
			double width = widthDouble + originalWidth;
			return changeProperty(ruleSet, "width", Arrays.asList(String.valueOf(width) + "%"));
		}
		
		return changeProperty(ruleSet, "width", Arrays.asList(ruleSet.getCssDelaration("width").getValues().get(0)));
	}

}
