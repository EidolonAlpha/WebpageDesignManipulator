package jonathanHughes.htmlReader.webpage.components.css.mediaQuery.model;

public class MediaFeatures {
	
	String Feature;
	String Value;
	
	public MediaFeatures(String feature, String value) {
		Feature = feature;
		Value = value;
	}

	public String getFeature() {
		return Feature;
	}

	public void setFeature(String feature) {
		Feature = feature;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}
	
	@Override
	public String toString() {
		return "(" + Feature + ": " + Value + ")"; 
	}
	
}
