package jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.extraction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.type.extractor.AttributeTypeExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.value.extractor.AtrributeValueExtractor;
import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class TagAttributeExtractor implements IExtractor<String, List<TagAtribute>>{
	
	private final static Logger LOGGER = Logger.getLogger(TagAttributeExtractor.class.getName());
	
	private final Pattern ATTRIBUTE_PATTERN = Pattern.compile("([^\\s=])+\\s?=([^\"']*[\"']){2}");
	
	private AtrributeValueExtractor attributeValueExtractor = new AtrributeValueExtractor(); 
	private AttributeTypeExtractor attributeTypeExtractor = new AttributeTypeExtractor();
	
	@Override
	public List<TagAtribute> extract(String _attributeString) {
		LOGGER.info("Extracting attributes from : " + _attributeString);
		List<TagAtribute> attributes = new ArrayList<TagAtribute>();
		List<String> attributeStrings = getAttributeStrings(_attributeString);
		for (String attributeString : attributeStrings) {
			String attributeType = attributeTypeExtractor.extract(attributeString);
			String attributeValue = attributeValueExtractor.extract(attributeString);
			attributes.add(new TagAtribute(attributeType, attributeValue));
		}
		return attributes;
	}
	
	private List<String> getAttributeStrings(String _attributeString) {
		List<String> foundAttributeStrings = new ArrayList<String>();
		Matcher attributeStringMatcher = ATTRIBUTE_PATTERN.matcher(_attributeString);
		while (attributeStringMatcher.find()) {
			foundAttributeStrings.add(attributeStringMatcher.group());
		}
		return foundAttributeStrings;
	}
		
}
