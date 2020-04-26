package jonathanHughes.htmlReader.webpage.model;

import java.util.ArrayList;
import java.util.List;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;

public class HtmlTagContainer {
	
	private List<TagPair> tagPairList;
	private List<Tag> tagList;
	
	public HtmlTagContainer(List<TagPair> tagPairList) {
		this.tagPairList = tagPairList;
	}
	
	public String getTagSelector(Tag tag) {
		TagAtribute tagAttribute = tag.getTagAttribute("class");
		TagAtribute tagId = tag.getTagAttribute("id");
		if (tagAttribute != null) {
			return tagAttribute.getValue();
		}
		else if (tagId != null) {
			return tagId.getValue();
		}
		return null;
	}

	public List<TagPair> getTagPairWithCssClass(String fullSelector) {
		String[] selectors = fullSelector.split(" .");
		List<TagPair> foundTags = tagPairList.get(0).getTagPairsWithCssClass(selectors[0]);
		for (int i = 1; i < selectors.length; i++) {
			for (TagPair tagPair : foundTags) {
				foundTags = getTagPairWithCssClass_temp(selectors[i], tagPair);
			}
		}
		return foundTags;
	}
	
	public List<TagPair> getTagPairWithCssClass_temp(String selector, TagPair tagPair) {
		return tagPair.getTagPairsWithCssClass(selector);
	}
		
	public List<TagPair> getFullTagList(){
		List<TagPair> tagList = new ArrayList<TagPair>();
		for (TagPair tagPair : this.tagPairList) {
			tagList.addAll(tagPair.getAllTagsAsList());
		}
		return tagList;
	}	
	
	public TagPair getParentTagPair(String selector) {
		List<TagPair> tagPairsWithClassName = getTagPairWithCssClass(selector);
		if (tagPairsWithClassName.size() > 0) {
			return tagPairsWithClassName.get(0).getParentTag();
		}
		return null;
	}
	
	public Tag getParentTag(String selector) {
		List<TagPair> tagPairsWithClassName = getTagPairWithCssClass(selector);
		if (tagPairsWithClassName.size() > 0) {
			Tag parentTag = tagPairsWithClassName.get(0).getParentTag().getStartTag();
			return parentTag;
		}
		return null;
	}

	public List<TagPair> getTagPairList() {
		return tagPairList;
	}

	public List<Tag> getTagList() {
		return tagList;
	}
	
	public List<String> getTagListAsString() {
		List<String> tagListString = new ArrayList<String>();
		for (Tag tag : tagList) {
			tagListString.add(tag.toString());
		}
		return tagListString;
	}
	
	@Override
	public String toString() {
		String html = "";
		for (TagPair tag : tagPairList) {
			html += tag.toString();
		}
		return html;
	}
	
}
