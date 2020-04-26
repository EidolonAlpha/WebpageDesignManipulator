package jonathanHughes.htmlReader.css.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import jonathanHughes.htmlReader.webpage.components.css.extraction.CssExtractor;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;

public class CssExtractorTests {
	
	CssExtractor cssExtractor = new CssExtractor();
	
	@Test
	public void extract_css_list_from_invalid_data() {
		String css = "qwerty";
		List<CssRuleSet> cssRuleSet = cssExtractor.extract(css);
		assertEquals(0, cssRuleSet.size());
	}
	
	@Test
	public void extract_css_list_set_1_value() {
		String css = "footer {\r\n" + 
				"  background-color: #777;\r\n" + 
				"  padding: 10px;\r\n" + 
				"  text-align: center;\r\n" + 
				"  color: white;\r\n" + 
				"}";
		String expectedResult = "footer { background-color: #777; padding: 10px; text-align: center; color: white; }";
		List<CssRuleSet> result = cssExtractor.extract(css);
		assertEquals(1, result.size());
		assertEquals(expectedResult, result.get(0).toString());
	}
	
	@Test
	public void extract_css_list_set_1_with_multi_line_comments() {
		String css = "/*this is a multi line comment*/footer {\r\n" + 
				"  background-color: #777;\r\n" + 
				"  padding: 10px;\r\n" + 
				"  text-align: center;\r\n" + 
				"  color: white;\r\n" + 
				"}";
		String expectedResult = "footer { background-color: #777; padding: 10px; text-align: center; color: white; }";
		List<CssRuleSet> result = cssExtractor.extract(css);
		assertEquals(1, result.size());
		assertEquals(expectedResult, result.get(0).toString());
	}
		
	@Test
	public void extract_css_list_set_2_values() {
		String css = "section:after {\r\n" + 
				"  content: \"\";\r\n" + 
				"  display: table;\r\n" + 
				"  clear: both;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"footer {\r\n" + 
				"  background-color: #777;\r\n" + 
				"  padding: 10px;\r\n" + 
				"  text-align: center;\r\n" + 
				"  color: white;\r\n" + 
				"}";
		String expectedResult1 = "section:after { content: \"\"; display: table; clear: both; }";
		String expectedResult2 = "footer { background-color: #777; padding: 10px; text-align: center; color: white; }";
		List<CssRuleSet> result = cssExtractor.extract(css);
		assertEquals(2, result.size());
		assertEquals(expectedResult1, result.get(0).toString());
		assertEquals(expectedResult2, result.get(1).toString());
	}
	
	@Test
	public void extract_css_list_set_2_values_one_mediaQuery() {
		String css = "@media (max-width: 600px) {\r\n" + 
				"  nav, article {\r\n" + 
				"    width: 100%;\r\n" + 
				"    height: auto;\r\n" + 
				"  }\r\n" + 
				"}" + 
				"\r\n" + 
				"footer {\r\n" + 
				"  background-color: #777;\r\n" + 
				"  padding: 10px;\r\n" + 
				"  text-align: center;\r\n" + 
				"  color: white;\r\n" + 
				"}";
		String expectedResult1 = "@media (max-width: 600px) { nav,article { width: 100%; height: auto; } }";
		String expectedResult2 = "footer { background-color: #777; padding: 10px; text-align: center; color: white; }";
		List<CssRuleSet> result = cssExtractor.extract(css);
		assertEquals(2, result.size());
		assertEquals(expectedResult1, result.get(0).toString());
		assertEquals(expectedResult2, result.get(1).toString());
	}
	
	@Test
	public void _RuleSet_within_media_test() {
		String css = "@media (max-width:600px){.w3-modal-content{margin:0 10px;width:auto!important}.w3-modal{padding-top:30px}}";
		List<CssRuleSet> cssRuleSet = cssExtractor.extract(css);
		assertEquals("@media (max-width: 600px)", cssRuleSet.get(0).getMediaRestrictionRule().get().toString());
		assertEquals("@media (max-width: 600px)", cssRuleSet.get(1).getMediaRestrictionRule().get().toString());
	}

}
