package jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model;

public class TagAtribute {
	
	private final String TYPE;
	private String value;
	
	public TagAtribute(String type, String value) {
		this.TYPE = type;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return TYPE;
	}
	
	public String toString() {
		return TYPE + "=" + "\"" + value + "\"";
	}
}
