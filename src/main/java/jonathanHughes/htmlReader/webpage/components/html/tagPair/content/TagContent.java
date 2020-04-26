package jonathanHughes.htmlReader.webpage.components.html.tagPair.content;

import java.util.List;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;

public class TagContent {
	
	String contentText;
	Tag previousTag;
	Tag nextTag;
	List<TagPair> innerTagPairs;
	
	public TagContent(String contentText, Tag previousTag, Tag nextTag) {
		this.contentText = contentText;
		this.previousTag = previousTag;
		this.nextTag = nextTag;
	}

	public String getContentText() {
		return contentText;
	}

	public Tag getPreviousTag() {
		return previousTag;
	}

	public Tag getNextTag() {
		return nextTag;
	}
	
	@Override
	public String toString() {
		return contentText;
	}

}
