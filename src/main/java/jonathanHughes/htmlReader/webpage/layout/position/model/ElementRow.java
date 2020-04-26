package jonathanHughes.htmlReader.webpage.layout.position.model;

import java.util.ArrayList;
import java.util.List;

import jonathanHughes.htmlReader.webpage.layout.position.WebpageElement;

public class ElementRow {
	
	private List<WebpageElement> elementsInRow;
	private final double MAX_ROW_WIDTH = 100;
	
	public ElementRow() {
		this.elementsInRow = new ArrayList<WebpageElement>();
	}

	public boolean addElementToRow(WebpageElement element) {
		if (canFitElementInRow(element)) {
			elementsInRow.add(element);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean canFitElementInRow(WebpageElement element) {
		if (getRowWidth() + element.getSize().getWidth() <= MAX_ROW_WIDTH) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void resizeRowElements(String elementCssPath, double newWidth) {
		for (WebpageElement webpageElement : elementsInRow) {
			if (webpageElement.getCssPath().equals(elementCssPath)) {
				webpageElement.changeWidth(newWidth);
			}
		}
	}
	
	public double getRowWidth() {
		double rowWidth = 0;
		for (WebpageElement webpageElement : elementsInRow) {
			rowWidth += webpageElement.getSize().getWidth();
		}
		return rowWidth;
	}

	public List<WebpageElement> getElementsInRow() {
		return elementsInRow;
	}

}
