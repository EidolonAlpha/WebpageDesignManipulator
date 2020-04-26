package jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.tagValue;

import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class TagValueExtractor implements IExtractor<String, String> {
	
	private final static Logger LOGGER = Logger.getLogger(TagValueExtractor.class.getName());
	
	@Override
	public String extract(String tagString) {
		LOGGER.info("Extracting Tag Value");
		int startPoint = 0;
		String tagValue = null;
		if (tagString != null) {
			int tagStart = getTagStartPos(tagString, startPoint) + 1;
			int tagEnd = getTagEndPos(tagString, startPoint + 1);
			if (tagEnd > -1) {
				tagValue = tagString.substring(tagStart, tagEnd).trim();
			}
			LOGGER.info("Found Tag Value : " + tagValue);
		}
		return tagValue;
	}
	
	private int getTagStartPos(String html, int searchStartPos) {
		return html.indexOf("<", searchStartPos);
	}
	
	private int getTagEndPos(String html, int _searchStartPos) {
		int posOfEndTag = html.indexOf(">");
		int posOfEmptySpace = html.indexOf(" ");
		if (html.contains("=")) {
			if (posOfEmptySpace == -1 || posOfEndTag < posOfEmptySpace) {
				return posOfEndTag;
			}
			else {
				return posOfEmptySpace;
			}
		}
		return posOfEndTag;
	}
	
}
