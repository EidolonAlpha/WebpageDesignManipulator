package jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.value.extractor;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class AtrributeValueExtractor implements IExtractor<String, String> {
	
	private final static Logger LOGGER = Logger.getLogger(AtrributeValueExtractor.class.getName());
	
	private String attributeValueRegex = "([\"'])(.+)([\"'])(?!=>{0,1})";
	
	@Override
	public String extract(String attributeString) {
		LOGGER.info("Extracting Value from Attribute");
		Matcher attributeValueMatcher = Pattern.compile(attributeValueRegex).matcher(attributeString);
		if (attributeValueMatcher.find()) {
			String foundValue = attributeValueMatcher.group();
			LOGGER.info("Extracted Value : " + foundValue);
			return foundValue.substring(1, foundValue.length()-1);
		}
		return "";
	}

}
