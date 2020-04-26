package jonathanHughes.htmlReader.webpage.components.html.tagPair.content.extraction;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.content.TagContent;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.extraction.TagExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;
import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class TagContentExtractor implements IExtractor<String, List<TagContent>>{
	
	TagExtractor tagExtractor = new TagExtractor();
		
	public List<TagContent> extractTagContent(String html, List<Tag> tagList, int startTagIndex, int endTagIndex) {
		Tag startTag = tagList.get(startTagIndex);
		Tag endTag = tagList.get(endTagIndex);
		List<String> tagContentText;
		if (doesContentContainTags(0, endTagIndex)) {
			tagContentText = getTagContentUsingPattern(html, compileOuterTagsRegexPattern(startTag.toString(), endTag.toString()));
		}
		else {
			tagContentText = getTagContentUsingPattern(html, compileBetweenTagsRegexPattern(startTag.toString(), endTag.toString()));
		}
		List<TagContent> tagContentList = new ArrayList<TagContent>();
		for (String tagContent : tagContentText) {
			tagContentList.add(new TagContent(tagContent, startTag, endTag)); 
		}
		return tagContentList;
	}
	
	private List<String> getTagContentUsingPattern(String contentString, Pattern regexPattern) {
		List<String> tagContentList = new ArrayList<String>();
		if (regexPattern != null) {
			Matcher regexMatcher = regexPattern.matcher(contentString);
			if (regexMatcher != null) {
				while (regexMatcher.find()) {
					tagContentList.add(regexMatcher.group());
				}
			}
		}
		return tagContentList;
	}
	
	private boolean doesContentContainTags(int startTagIndex, int endTagIndex) {
		if (endTagIndex == startTagIndex +1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private Pattern compileOuterTagsRegexPattern(String startText, String endText) {
		try {
			return Pattern.compile("(?<=" + startText + ")(.*)(?=" + endText + ")");
		} catch (Exception e) {
			return null;
		}
		
	}
	
	private Pattern compileBetweenTagsRegexPattern(String startText, String endText) {
		return Pattern.compile("(?<=" + startText + ")(.*?)(?=" + endText + ")");
	}

	@Override
	public List<TagContent> extract(String data) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
