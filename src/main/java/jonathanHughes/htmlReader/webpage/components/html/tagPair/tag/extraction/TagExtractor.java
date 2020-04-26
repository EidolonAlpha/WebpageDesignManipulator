package jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.extraction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.extraction.TagAttributeExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.tagValue.TagValueExtractor;
import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class TagExtractor implements IExtractor<String, List<Tag>>{
	
	private final static Logger LOGGER = Logger.getLogger(TagExtractor.class.getName());
	
	private final Pattern tagPattern = Pattern.compile("<\\/?.[^>]*>");
	private final Pattern startTagPattern = Pattern.compile("<[^/][^>]*>");
	private final Pattern endTagPattern = Pattern.compile("<\\/.[^>]*>");
	
	TagValueExtractor tagValueExtractor = new TagValueExtractor();
	TagAttributeExtractor tagAttributeExtractor = new TagAttributeExtractor();

	public List<Tag> extract(String htmlString) {
		LOGGER.info("Starting Tag List Extraction of : " + htmlString);
		List<Tag> tagList = new ArrayList<Tag>();
		for (String tagString : findAllTags(htmlString)) {
			String tagValue = tagValueExtractor.extract(tagString);
			List<TagAtribute> tagAttributes = tagAttributeExtractor.extract(tagString);
			if (tagAttributes.size() > 0) {
				tagList.add(new Tag(tagValue, tagAttributes));
			}
			else {
				tagList.add(new Tag(tagValue, isClosingTag(tagString)));
			}
		}
		return tagList;
	}
	
	public List<Tag> extractStartTags(String htmlString) {
		LOGGER.info("Starting Start tag Extraction of : " + htmlString);
		List<Tag> tagList = new ArrayList<Tag>();
		for (String tagString : findAllStartTags(htmlString)) {
			String tagValue = tagValueExtractor.extract(tagString);
			List<TagAtribute> tagAttributes = tagAttributeExtractor.extract(tagString);
			if (tagAttributes.size() > 0) {
				tagList.add(new Tag(tagValue, tagAttributes));
			}
			else {
				tagList.add(new Tag(tagValue, isClosingTag(tagString)));
			}
		}
		return tagList;
	}
	
	private String[] findAllTags(String htmlString) {
		LOGGER.info("Extracting all HTML Tags");
		Matcher tagMatcher = tagPattern.matcher(htmlString);
		String[] foundTags = tagMatcher.results().map(MatchResult::group).toArray(String[]::new);
		LOGGER.info(foundTags.length + " tags found");
		return foundTags;
	}
	
	private String[] findAllStartTags(String htmlString) {
		LOGGER.info("Extracting all HTML Start Tags");
		Matcher tagMatcher = startTagPattern.matcher(htmlString);
		String[] foundTags = tagMatcher.results().map(MatchResult::group).toArray(String[]::new);
		LOGGER.info(foundTags.length + " start tags found");
		return foundTags;
	}
	
	private boolean isClosingTag(String tagString) {
		return endTagPattern.matcher(tagString).matches();
	}
	
}
