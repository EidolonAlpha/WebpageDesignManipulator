package jonathanHughes.htmlReader.webpage.components.html.tagPair.util;

public class TagPairIndexPairPosition {
	
	int startIndex;
	int endIndex;
	
	public TagPairIndexPairPosition(int startIndex, int endIndex) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	public int getEndIndex() {
		return endIndex;
	}
	
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
}
