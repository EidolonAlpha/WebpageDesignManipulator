package jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model;

import java.util.List;

public class CssDeclaration {
	
	private String property;
	private List<String> values;

	public CssDeclaration(String property, List<String> values) {
		this.property = property;
		this.values = values;
	}
		
	public void setValues(List<String> values) {
		this.values = values;
	}

	public String getProperty() {
		return property;
	}

	public List<String> getValues() {
		return values;
	}
	
	public String getValuesAsString() {
		String value = "";
		for (int i = 0; i < values.size(); i++) {
			value += values.get(i);
			if (i < values.size()-1) {
				value += ", ";
			}else if (i == values.size() -1) {
				value += ";";
			}
		}
		return value;
	}

	@Override
	public String toString() {
		String attribute = property + ": ";
		for (int i = 0; i < values.size(); i++) {
			attribute += values.get(i);
			if (i < values.size()-1) {
				attribute += ", ";
			}else if (i == values.size() -1) {
				attribute += ";";
			}
		}
		return attribute;
	}
}
