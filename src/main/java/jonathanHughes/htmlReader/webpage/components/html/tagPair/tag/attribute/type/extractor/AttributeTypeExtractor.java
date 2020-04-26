package jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.type.extractor;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class AttributeTypeExtractor implements IExtractor<String, String>{
	
	private final static Logger LOGGER = Logger.getLogger(AttributeTypeExtractor.class.getName());
	private final String attributeTypeRegex = "^\\w+";

	@Override
	public String extract(String attributeString) {
		LOGGER.info("Extracting Type from Attribute");
		Matcher attributeTypeMatcher = Pattern.compile(attributeTypeRegex).matcher(attributeString);
		if (attributeTypeMatcher.find()) {
			String type = attributeTypeMatcher.group();
			LOGGER.info("Found Type : " + type);
			return type;
		}
		return "";
	}

}
