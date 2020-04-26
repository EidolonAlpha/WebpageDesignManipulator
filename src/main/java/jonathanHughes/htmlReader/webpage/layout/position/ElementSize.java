package jonathanHughes.htmlReader.webpage.layout.position;

public class ElementSize {
	
	private String cssPath;
	private double width;
	private double height;
	
	public ElementSize(String cssEntity) {
		int pathIndex = cssEntity.indexOf(":")+ 1;
		int pathEndIndex = cssEntity.indexOf(",");
		int widthIndex = cssEntity.substring(pathEndIndex).indexOf(":") + pathEndIndex + 2;
		int widthEndIndex = cssEntity.substring(widthIndex).indexOf(",") + widthIndex;
		int heightIndex = widthEndIndex + cssEntity.substring(widthEndIndex).indexOf(":");
		this.cssPath = cssEntity.substring(pathIndex, pathEndIndex);
		this.width = Double.valueOf(cssEntity.substring(widthIndex, widthEndIndex-1));
		this.height = Double.valueOf(cssEntity.substring(heightIndex + 1, cssEntity.length()-1));
		
	}

	public String getCssPath() {
		return cssPath;
	}

	public void setCssPath(String cssPath) {
		this.cssPath = cssPath;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
}
