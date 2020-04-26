package jonathanHughes.htmlReader.webpage.layout.position;

public class WebpageElement {

	private String cssPath;
	private ElementSize size;
	
	public WebpageElement(String cssPath, ElementSize size) {
		this.cssPath = cssPath;
		this.size = size;
	}

	public String getCssPath() {
		return cssPath;
	}

	public void setCssPath(String cssPath) {
		this.cssPath = cssPath;
	}

	public ElementSize getSize() {
		return size;
	}

	public void setSize(ElementSize size) {
		this.size = size;
	}
	
	public void changeWidth(double newWidth) {
		this.size.setWidth(newWidth);
	}
	
}
