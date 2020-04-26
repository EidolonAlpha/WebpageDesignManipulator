package jonathanHughes.htmlReader.css.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.value.extractor.CssDeclarationValueExtractor;

public class DeclarationValueTest {
	
	private CssDeclarationValueExtractor valueExtractor = new CssDeclarationValueExtractor();
	
	@Test
	public void test_extraction_of_css_decleration() {
		String cssString = ":Arial;";
		List<String> values = valueExtractor.extract(cssString);
		assertEquals("Arial", values.get(0));
	}
	
	@Test
	public void test_extraction_of_css_decleration_imporatant() {
		String cssString = ":absolute !important;";
		List<String> values = valueExtractor.extract(cssString);
		assertEquals("absolute !important", values.get(0));
	}
	
	@Test
	public void test_extraction_of_css_decleration_rgb_color() {
		String cssString = ":rgb(40,44,52);";
		List<String> values = valueExtractor.extract(cssString);
		assertEquals("rgb(40,44,52)", values.get(0));
	}
	
	@Test
	public void test_extraction_of_css_decleration_comment_in_declaration() {
		String cssString = ":#88ccbb/*green2*/!important;";
		List<String> values = valueExtractor.extract(cssString);
		assertEquals("#88ccbb/*green2*/!important", values.get(0));
	}
	
	
	
	
//	@Test
//	public void test_extraction_of_css_declaration_multiple_values() {
//		String cssString = "1px solid #ccc";
//		List<String> values = valueExtractor.extract(cssString);
//		assertEquals(":1px ;", values.get(0));	
//	}

}
