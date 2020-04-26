package jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model;

import java.util.ArrayList;
import java.util.List;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;

public class Tag {
	
	private String tagValue;
	private List<TagAtribute> tagAttributes;
	private boolean isEndTag;
	
	public Tag(String tagValue, List<TagAtribute> tagAttributes) {
		this.tagValue = tagValue;
		this.tagAttributes = tagAttributes;
		this.isEndTag = false;
	}
	
	public Tag(String tagValue, boolean isEndTag) {
		this.tagValue = tagValue;
		this.isEndTag = isEndTag;
		this.tagAttributes = new ArrayList<TagAtribute>();
	}

	public String getTagValue() {
		return tagValue;
	}

	public List<TagAtribute> getTagAttributes() {
		return tagAttributes;
	}
	
	public TagAtribute getTagAttribute(final String Type) {
		for (TagAtribute tagAtribute : tagAttributes) {
			if (tagAtribute.getType().equalsIgnoreCase(Type)) {
				return tagAtribute;
			}
		}
		return null;
	}

	public boolean isEndTag() {
		return isEndTag;
	}

	public String toString() {
		String stringTag = "<";
		if (!isEndTag) {
			stringTag += tagValue;
			if (tagAttributes.size() > 0) {
				for (TagAtribute tagAtribute : tagAttributes) {
					stringTag += " " + tagAtribute.toString();
				}
			}
		}
		else {
			 stringTag += tagValue;
		}
		return stringTag + ">";
	}
	
}
