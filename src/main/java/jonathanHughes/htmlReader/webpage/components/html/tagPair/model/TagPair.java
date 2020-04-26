package jonathanHughes.htmlReader.webpage.components.html.tagPair.model;

import java.util.ArrayList;
import java.util.List;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.content.TagContent;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;

public class TagPair {
	
	private Tag startTag;
	private Tag endTag;
	private List<TagContent> content;
	private TagPair parentTag;
	List<TagPair> innerLayout;

	public TagPair(Tag startTag, Tag endTag, List<TagContent> tagContentList, List<TagPair> innerTagList) {
		this.startTag = startTag;
		this.endTag = endTag;
		this.content = tagContentList;
		this.innerLayout = innerTagList;
	}

	public Tag getStartTag() {
		return startTag;
	}

	public Tag getEndTag() {
		return endTag;
	}

	public List<TagContent> getContent() {
		return content;
	}

	public void setContent(List<TagContent> content) {
		this.content = content;
	}

	public List<TagPair> getInnerTagPairList() {
		return this.innerLayout;
	}
	
	public List<Tag> getInnerTagList(){
		List<Tag> innerTags = new ArrayList<Tag>();
		for (TagPair tagPair : this.innerLayout) {
			innerTags.add(tagPair.startTag);
		}
		return innerTags;
	}
	
	public List<TagPair> getAllTagsAsList(){
		List<TagPair> tagList = new ArrayList<TagPair>();
		tagList.add(this);
		for (TagPair tagPair : this.innerLayout) {
			tagList.addAll(tagPair.getAllTagsAsList());
		}
		return tagList;
	}
	
	public List<String> getCssClassList(){
		List<String> classList = new ArrayList<String>();
		if (this.startTag != null) {
			TagAtribute classAttribute = startTag.getTagAttribute("class");
			if (classAttribute != null) {
				classList.add(0, classAttribute.getValue());
			}
		}
		if (this.parentTag != null) {
			classList.addAll(this.parentTag.getCssClassList());
		}
		return classList;
	}
	
	public List<TagPair> getTagPairsWithCssClass(String selector) {
		List<TagPair> affectedTags = new ArrayList<TagPair>();
		for (TagPair tag : this.innerLayout) {
			if (tag.getStartTag().getTagValue().equalsIgnoreCase(selector)) {
				affectedTags.add(tag);
			}
			else {
				for (TagAtribute attribute : tag.getStartTag().getTagAttributes()) {
					if (attribute.getType().equalsIgnoreCase("id")) {
						if (attribute.getValue().equalsIgnoreCase(selector.substring(1))) {
							affectedTags.add(tag);
						}
					}
				}
			}
			String _selector = selector.replace(".", " ").trim();
			for (TagAtribute attribute : tag.getStartTag().getTagAttributes()) {
				if (attribute.getType().equalsIgnoreCase("class")) {
					if (attribute.getValue().contains(_selector) || attribute.getValue().equalsIgnoreCase(_selector) || attribute.getValue().equalsIgnoreCase(selector.substring(1))) {
						affectedTags.add(tag);
					}
				}
			}
			affectedTags.addAll(tag.getTagPairsWithCssClass(_selector));
		}
		return affectedTags;
	}
	
	public TagPair getParentTag() {
		return parentTag;
	}

	public void setParentTag(TagPair parentTag) {
		this.parentTag = parentTag;
	}
	public String toStringAsHTML() {
		String text = "";
		text +=  startTag.toString();	
		text +=  content.toString();
		text +=  endTag.toString();
		return text;
	}


	@Override
	public String toString() {
		String text = "";
		text += "StartTag : " + startTag.toString();	
		text += " Content : " + content.toString();
		text += " EndTag : " + endTag.toString();
		return text;
	}

}
