package jonathanHughes.htmlReader.css.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.property.extractor.CssDeclarationPropertyExtractor;

public class DeclarationPropertyExtractionTest {
	
	private CssDeclarationPropertyExtractor propertyExtactor = new CssDeclarationPropertyExtractor();

	@Test
	public void test_extraction_of_css_decleration() {
		String cssString = "font-family: Arial";
		String property = propertyExtactor.extract(cssString);
		assertEquals("font-family", property);
	}
	
	@Test
	public void test_extraction_of_css_declaration_multiple_values() {
		String cssString = "border-bottom:1px solid #ccc";
		String property = propertyExtactor.extract(cssString);
		assertEquals("border-bottom", property);
		
	}
	
	
	@Test
	public void test_extraction_of_css_decleration_URL() {
		String cssString = "background:url(data:image//gif;base64,R0lGODlhpwALAPEAAJ2dnZubm21tbf//yH5BAEAAAMALAAAAACnAAsAAAJPnI+py+0Po5y0smCz3rz7LAjfSJbmGYpGyrbuC8fyTNf2jef3qvf+DwwKdYOh8YhMKgWApfMJjYqk1Kp1d8pqt1yeqgsOiymhsfmMPgASBQA7)no-repeatrightcenter;width:50px;height:10px;margin:016px;";
		String property = propertyExtactor.extract(cssString);
		assertEquals("background", property);
	}
	
}
