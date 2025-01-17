package jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.value.extractor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class CssDeclarationValueExtractor implements IExtractor<String, List<String>>{
	
	private final static Logger LOGGER = Logger.getLogger(CssDeclarationValueExtractor.class.getName());

	@Override
	public List<String> extract(String cssString) {
		List<String> valueList = new ArrayList<String>();
		if (cssString == null) {
			return valueList;
		}
		int startIndex = cssString.indexOf(':') + 1;
		int endIndex = cssString.indexOf(';');
		if (startIndex == -1 || endIndex == -1) {
			return valueList;
		}
		String valueString = cssString.substring(startIndex, endIndex).trim();
		LOGGER.info("Extracted Value String : " + valueString);
		String newValue = "";
		
		boolean multiCommaValue = false;
		for (String value : valueString.split("\\s*,\\s*")) {
			newValue += value;
			if ((value.contains("(") && !value.contains(")"))) {
				multiCommaValue = true;
				
			}
			if ((!value.contains("(") && value.contains(")"))) {
				multiCommaValue = false;
			}
			if (!multiCommaValue) {
				valueList.add(newValue);
				newValue = "";
			}
			else {
				newValue += ",";
			}
		}
		
		return valueList;
	}

}
