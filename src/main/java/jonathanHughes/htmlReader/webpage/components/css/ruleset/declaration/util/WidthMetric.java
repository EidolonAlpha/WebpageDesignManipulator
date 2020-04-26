package jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.util;

public enum WidthMetric {
	
	Percentage("%"),
	Pixels("px"),
	Unkown("");
	
	private String metricNotation;
	
	private WidthMetric(String metricNotation) {
		this.metricNotation = metricNotation;
	}

	public String getMetricNotation() {
		return metricNotation;
	}

}
