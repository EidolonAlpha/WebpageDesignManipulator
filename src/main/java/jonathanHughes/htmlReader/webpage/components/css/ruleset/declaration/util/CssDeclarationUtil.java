package jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.util;

import java.util.regex.Pattern;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model.CssDeclaration;

public class CssDeclarationUtil {
	
	private final String percentPatternString = "[\\d.]+\\%";
	private final Pattern percentPattern = Pattern.compile(percentPatternString);
	private final String pixelPatternString = "[\\d.]+\\%";
	private final Pattern pixelPattern = Pattern.compile(pixelPatternString);
	
	public PositionValues getPositionPropertyValueOf(CssDeclaration positionDeclaration) {
		if (positionDeclaration != null) {
			String position = positionDeclaration.getValues().get(0);
			for (PositionValues value : PositionValues.values()) {
				if (value.toString().equalsIgnoreCase(position)) {
					return value;
				}
			}
		}
		return PositionValues.None;
	}
	
	public String getParentClassFrom(String childSelector) {
		String parentCssClass = "";
		if (childSelector != null) {
			if (childSelector.contains(".")) {
				parentCssClass = childSelector.substring(0, childSelector.lastIndexOf("."));
			}
		}
		return parentCssClass;
	}
	
	public double getWidthValueOfDeclaraitonAsDouble(CssDeclaration cssDeclaration) {
		double width = 0;
		if (cssDeclaration != null) {
			String widthString = cssDeclaration.getValues().get(0);
			String widthMetric = getWidthMetricOf(widthString).getMetricNotation();
			
			widthString = widthString.replace(widthMetric, "");
			
			
			widthString = widthString.replace("!important", "").strip();
			width = Double.parseDouble(widthString);
		}
		return width;
	}
	
	public double getWidthValueAsDouble(String widthString) {
		double width = 0;
		String widthMetric = getWidthMetricOf(widthString).getMetricNotation();
		
		widthString = widthString.replace(widthMetric, "");	
		widthString = widthString.replace("!important", "").strip();
		widthString = widthString.replace(";", "");
		width = Double.parseDouble(widthString);
		return width;
	}
	
	public WidthMetric getWidthMetricOf(String widthProperty) {
		if (percentPattern.matcher(widthProperty).find()) {
			return WidthMetric.Percentage;
		}
		else if (pixelPattern.matcher(widthProperty).find()) {
			return WidthMetric.Pixels;
		}
		return WidthMetric.Unkown;
	}

}
