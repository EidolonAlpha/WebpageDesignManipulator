package jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;

public class TagPositionInString {
	
	private final Pattern tagPattern = Pattern.compile("<\\/?.[^>]*>");
	
	public int getPositionOfTag(String htmlString, Tag tag, int tagIndex) {
		Matcher tagMatcher = tagPattern.matcher(htmlString);
		int tagPosition = -1;
		int searchIndex = 0;
		while (tagMatcher.find()) {	
			String foundTag = tagMatcher.group();
			if (foundTag.equalsIgnoreCase(tag.toString()) && tagIndex == searchIndex) {
		        tagPosition = tagMatcher.start();
			}
			searchIndex++;
		}
		return tagPosition;
	}
	
}
