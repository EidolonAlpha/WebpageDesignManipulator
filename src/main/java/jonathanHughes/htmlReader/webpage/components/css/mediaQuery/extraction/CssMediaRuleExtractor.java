package jonathanHughes.htmlReader.webpage.components.css.mediaQuery.extraction;

import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.components.css.mediaQuery.model.MediaQuery;
import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class CssMediaRuleExtractor implements IExtractor<String, MediaQuery> {
	
	private final static Logger LOGGER = Logger.getLogger(CssMediaRuleExtractor.class.getName());
	
	MediaTypeExtractor typeExtractor = new MediaTypeExtractor();
	MediaFeaturesExtractor featuresExtractor = new MediaFeaturesExtractor();

	@Override
	public MediaQuery extract(String cssRuleSet) {
		String mediaQuery = "";
		LOGGER.info("Extracting Media Query from Ruleset : " + cssRuleSet );
		int endIndex = cssRuleSet.indexOf('{');
		if (endIndex == -1) {
			LOGGER.info("No Media query found");
		}
		else {
			mediaQuery = cssRuleSet.substring(0, endIndex).trim();
		}
		return new MediaQuery(typeExtractor.extract(mediaQuery), featuresExtractor.extract(mediaQuery));
	}
	
	

//	@Override
//	public String extract(String cssRuleSet) {
//		String mediaQuery = "";
//		LOGGER.info("Extracting Media Query from Ruleset : " + cssRuleSet );
//		int endIndex = cssRuleSet.indexOf('{');
//		if (endIndex == -1) {
//			LOGGER.info("No Media query found");
//		}
//		mediaQuery = cssRuleSet.substring(0, endIndex).trim();
//		LOGGER.info("Extracted Media query " + mediaQuery);
//		return mediaQuery;
//	}



}
