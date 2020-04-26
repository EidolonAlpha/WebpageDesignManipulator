package jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.property.extractor;

import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class CssDeclarationPropertyExtractor implements IExtractor<String, String>{
	
	private final static Logger LOGGER = Logger.getLogger(CssDeclarationPropertyExtractor.class.getName());

	@Override
	public String extract(String cssString) {
		String property = "";
		int endPoint = cssString.indexOf(':');
		if (endPoint == -1) {
			LOGGER.warning("No Property extracted from " + cssString);
		}
		else {
			property = cssString.substring(0, endPoint).trim();
			LOGGER.info("Extracted Property : " + property);
		}
		return property;
	}
	
}
