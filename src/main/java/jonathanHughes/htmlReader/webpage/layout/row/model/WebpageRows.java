package jonathanHughes.htmlReader.webpage.layout.row.model;

import java.util.ArrayList;
import java.util.List;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;

public class WebpageRows {
	
	private double currentWidth;
	private double maxWidth;
	private List<TagPair> siblingTagsInRow;
	
	public WebpageRows(double maxWidth) {
		this.currentWidth = 0.0;
		this.maxWidth = maxWidth;
		this.siblingTagsInRow = new ArrayList<TagPair>();
	}
	
	public boolean addSiblingToRow(TagPair tagPair, double width) {
		if (currentWidth + width <= maxWidth) {
			siblingTagsInRow.add(tagPair);
			currentWidth += width;
			return true;
		}
		return false;
	}

	public List<TagPair> getSiblingTagsInRow() {
		return siblingTagsInRow;
	}
	
	public boolean contains(String cssClass) {
		for (TagPair tagPair : siblingTagsInRow) {
			TagAtribute classAttribute = tagPair.getStartTag().getTagAttribute("class");
			if (classAttribute != null) {
				String test = cssClass.substring(cssClass.lastIndexOf(".") +1, cssClass.length());
				if (classAttribute.getValue().equalsIgnoreCase(cssClass)) {
					return true;
				}
				else if (classAttribute.getValue().equalsIgnoreCase(test)) {
					return true;
				}
			}
			else if (tagPair.getStartTag().getTagValue().equalsIgnoreCase(cssClass)) {
				return true;
			}
		}
		return false;
	}

	public void setSiblingTagsInRow(List<TagPair> siblingTagsInRow) {
		this.siblingTagsInRow = siblingTagsInRow;
	}
	
}
