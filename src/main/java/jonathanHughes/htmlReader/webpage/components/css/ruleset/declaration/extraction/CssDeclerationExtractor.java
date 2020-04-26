package jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.extraction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model.CssDeclaration;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.property.extractor.CssDeclarationPropertyExtractor;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.value.extractor.CssDeclarationValueExtractor;
import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class CssDeclerationExtractor implements IExtractor<String, List<CssDeclaration>>{
	
	private final static Logger LOGGER = Logger.getLogger(CssDeclerationExtractor.class.getName());
	private CssDeclarationPropertyExtractor decPropertyExtractor = new CssDeclarationPropertyExtractor();
	private CssDeclarationValueExtractor decValueExtractor = new CssDeclarationValueExtractor();

	@Override
	public List<CssDeclaration> extract(String cssRuleSetString) {
		String cssDeclarationString = extractDeclarationString(cssRuleSetString);
		LOGGER.info("Detected CSS Declaration String : " + cssDeclarationString);
		List<CssDeclaration> cssDeclarationList = new ArrayList<CssDeclaration>();
		if (cssDeclarationString != null) {
			for (String cssDeclarationText : cssDeclarationString.split(";")) {
				String declarationText = cssDeclarationText + ";";
				String property = decPropertyExtractor.extract(declarationText);
				declarationText = declarationText.substring(property.length());
				List<String> values = decValueExtractor.extract(declarationText);
				cssDeclarationList.add(new CssDeclaration(property, values));
			}
		}
		return cssDeclarationList;
	}
	
	private String extractDeclarationString(String cssRuleSet) {
		int startIndex = cssRuleSet.indexOf('{') + 1;
		int endIndex = cssRuleSet.indexOf('}');
		if (startIndex != -1 && endIndex != -1) {
			return cssRuleSet.substring(startIndex, endIndex).trim();
		}
		return null;
	}
	
	

}
