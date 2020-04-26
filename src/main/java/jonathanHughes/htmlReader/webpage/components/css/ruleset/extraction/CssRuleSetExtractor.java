package jonathanHughes.htmlReader.webpage.components.css.ruleset.extraction;

import java.util.ArrayList;
import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.extraction.CssDeclerationExtractor;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model.CssDeclaration;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.selector.CssSelectorExtractor;
import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class CssRuleSetExtractor implements IExtractor<String, CssRuleSet> {
	
	private final static Logger LOGGER = Logger.getLogger(CssRuleSetExtractor.class.getName());

	private CssSelectorExtractor selectorExtractor = new CssSelectorExtractor();
	private CssDeclerationExtractor declarationExtractor = new CssDeclerationExtractor();
	
	@Override
	public CssRuleSet extract(String cssRuleSetText) {
		if (!cssRuleSetText.isEmpty()) {
			String selector = selectorExtractor.extract(cssRuleSetText);
			if (selector != null) {
				String declarationText = cssRuleSetText.substring(selector.length());
				return new CssRuleSet(selector,declarationExtractor.extract(declarationText));
			}
		}
		LOGGER.warning("No CSS Extracted from : " + cssRuleSetText);
		return new CssRuleSet("", new ArrayList<CssDeclaration>());
	}
	
}
