package jonathanHughes.htmlReader.webpage.components.html.tagPair.util;

import java.util.List;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;

public class ClosingTagIndexFinder {

	String[] selfClosingTags = {"area" + 
			"base" + 
			"br"+ 
			"col" + 
			"command" + 
			"embed" + 
			"hr" + 
			"img" + 
			"input" + 
			"keygen" + 
			"link" + 
			"meta" + 
			"param" + 
			"source" + 
			"track" + 
	"wbr"};
	
	private TagPairVerifier tagPairVerifier = new TagPairVerifier();

	public int getIndexOfMatchingEndTag(List<Tag> tagList, int startTagIndex) {
		if (tagList.size() > 0) {
			Tag startTag = tagList.get(startTagIndex);
			if (!startTag.isEndTag()) {
				return getEndTagIndexOf(tagList, startTagIndex);
			}
			return -1;
		}
		return -1;
	}
	
	private int getEndTagIndexOf(List<Tag> htmlTags, int tagIndex){
		Tag topLevelStartTag = htmlTags.get(tagIndex);
		Tag tagToCheck;
		int numberOfEndTagsToIgnore = 0;
		for (int i = tagIndex+1; i < htmlTags.size(); i++) {
			tagToCheck = htmlTags.get(i);
			if (tagToCheck.isEndTag()) {
				if (tagPairVerifier.areTagsValidSet(topLevelStartTag, tagToCheck)) {
					if (numberOfEndTagsToIgnore == 0) {
						return i;
					}
					else {
						numberOfEndTagsToIgnore--;
					}
				}
			}
			else if (tagToCheck.getTagValue().equalsIgnoreCase(topLevelStartTag.getTagValue())) {
				//If not an end tag and is the same as the parent tag
				numberOfEndTagsToIgnore++;
			}
		}
		return -1;
	}

}
