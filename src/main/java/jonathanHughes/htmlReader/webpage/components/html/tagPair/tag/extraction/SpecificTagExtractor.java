package jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.extraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class SpecificTagExtractor implements IExtractor<String, String> {

	@Override
	public String extract(String html) {
		return getTagContentUsingPattern(html, compileOuterTagsRegexPattern("<style>", "</style>"));
	}
	
	private String getTagContentUsingPattern(String contentString, Pattern regexPattern) {
		String tagContentList = "";
		Matcher regexMatcher = regexPattern.matcher(contentString);
		while (regexMatcher.find()) {
			tagContentList += regexMatcher.group();
		}
		return tagContentList;
	}
	
	private Pattern compileOuterTagsRegexPattern(String startText, String endText) {
		return Pattern.compile("(?<=" + startText + ")(.*)(?=" + endText + ")");
	}
	
}
