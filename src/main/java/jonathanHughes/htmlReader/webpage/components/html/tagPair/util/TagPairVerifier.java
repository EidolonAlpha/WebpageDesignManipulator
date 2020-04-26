package jonathanHughes.htmlReader.webpage.components.html.tagPair.util;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;

public class TagPairVerifier {
	
	public boolean areTagsValidSet(Tag startTag, Tag endTag) {
		return startTag.getTagValue().equalsIgnoreCase(endTag.getTagValue().substring(1));
	}

}
