package jonathanHughes.htmlReader.webpage.components.css.ruleset.selector;

import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class CssSelectorExtractor implements IExtractor<String, String>{
	
	private final static Logger LOGGER = Logger.getLogger(CssSelectorExtractor.class.getName());

	@Override
	public String extract(String cssRuleSet) {
		String extractedSelector = "";
		int endIndex = cssRuleSet.indexOf('{');
		if (endIndex == -1) {
			LOGGER.warning("No end index for Ruleset " + cssRuleSet + " has been detected");
			return null;
		}
		extractedSelector = cssRuleSet.substring(0, endIndex).trim();
		LOGGER.info("Extracted selector : " + extractedSelector);
		return extractedSelector;
	}

}
