package jonathanHughes.htmlReader.webpage.layout.position.model;

import java.util.ArrayList;
import java.util.List;

import jonathanHughes.htmlReader.webpage.layout.position.WebpageElement;

public class ElementLayout {
	
	private List<ElementRow> elememtRows = new ArrayList<ElementRow>();

	public ElementLayout(List<WebpageElement> siblingList) {
		this.elememtRows = new ArrayList<ElementRow>();
		determineSiblingPositions(siblingList);
	}
	
	private void determineSiblingPositions(List<WebpageElement> siblingList) {
		boolean createNewRow = true;
		
		this.elememtRows.add(new ElementRow());
		this.elememtRows.get(0).addElementToRow(siblingList.get(0));
		
		for (int i = 1; i < siblingList.size(); i++) {
			if (createNewRow) {
				elememtRows.add(new ElementRow());
			}
			createNewRow = !elememtRows.get(elememtRows.size() - 1).canFitElementInRow(siblingList.get(i));
			addElementToLastRow(siblingList.get(i));
		}
	}
	
	private void addElementToLastRow(WebpageElement elementToAdd) {
		ElementRow currentRow = elememtRows.get(elememtRows.size() - 1);
		currentRow.addElementToRow(elementToAdd);
	}

	public List<ElementRow> getElememtRows() {
		return elememtRows;
	}
	
}
