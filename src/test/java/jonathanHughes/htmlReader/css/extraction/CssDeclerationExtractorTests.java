package jonathanHughes.htmlReader.css.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import jonathanHughes.htmlReader.webpage.components.css.extraction.CssExtractor;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.extraction.CssDeclerationExtractor;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model.CssDeclaration;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;

public class CssDeclerationExtractorTests {
	
	CssExtractor internalCSSExtractor = new CssExtractor();
	CssDeclerationExtractor cssDeclerationExtraction = new CssDeclerationExtractor();
	
	@Test
	public void test_extraction_of_invalid_css_decleration() {
		String cssString = "qwert";
		List<CssDeclaration> cssDeclerationList = cssDeclerationExtraction.extract(cssString);
		assertEquals(0, cssDeclerationList.size());
	}
	
	@Test
	public void test_extraction_of_css_decleration() {
		String cssString = "{font-family: Arial, Helvetica, sans-serif;}";
		List<CssDeclaration> cssDeclerationList = cssDeclerationExtraction.extract(cssString);
		CssDeclaration cssDecleration = cssDeclerationList.get(0);
		assertEquals("font-family: Arial, Helvetica, sans-serif;", cssDecleration.toString());
		assertEquals("font-family", cssDecleration.getProperty());
		assertEquals("Arial", cssDecleration.getValues().get(0));
		assertEquals("Helvetica", cssDecleration.getValues().get(1));
		assertEquals("sans-serif", cssDecleration.getValues().get(2));
	}
	
	@Test
	public void test_extraction_of_css_decleration_after_extraction_from_internal_css() {
		String internalCSS = "body {  font-family: Arial, Helvetica, sans-serif;}article { float: left; padding: 20px; width: 70%; background-color: #f1f1f1; height: 300px;}<html></html>";
		List<CssRuleSet> interalCSSList = internalCSSExtractor.extract(internalCSS);
		CssRuleSet firstInternalCss = interalCSSList.get(0);
		CssRuleSet secondInternalCss = interalCSSList.get(1);
		assertEquals("body { font-family: Arial, Helvetica, sans-serif; }", firstInternalCss.toString());
		assertEquals("article { float: left; padding: 20px; width: 70%; background-color: #f1f1f1; height: 300px; }", secondInternalCss.toString());
		assertEquals("body", firstInternalCss.getSelector());
		CssDeclaration firstCssDeclaration = firstInternalCss.getCssDeclaration().get(0);
		assertEquals("font-family: Arial, Helvetica, sans-serif;", firstCssDeclaration.toString());
		assertEquals("font-family", firstCssDeclaration.getProperty());
		assertEquals("Arial", firstCssDeclaration.getValues().get(0));
		assertEquals("Helvetica", firstCssDeclaration.getValues().get(1));
		assertEquals("sans-serif", firstCssDeclaration.getValues().get(2));
		CssDeclaration secondCssDeclaration = secondInternalCss.getCssDeclaration().get(0);
		assertEquals("float: left;", secondCssDeclaration.toString());
		assertEquals("float", secondCssDeclaration.getProperty());
		assertEquals("left", secondCssDeclaration.getValues().get(0));
		CssDeclaration thirdCssDeclaration = secondInternalCss.getCssDeclaration().get(1);
		assertEquals("padding: 20px;", thirdCssDeclaration.toString());
		assertEquals("padding", thirdCssDeclaration.getProperty());
		assertEquals("20px", thirdCssDeclaration.getValues().get(0));
	}
	
//	@Test
//	public void test_extraction_of_css_decleration_URL() {
//		String cssString = "{background:url(data:image//gif;base64,R0lGODlhpwALAPEAAJ2dnZubm21tbf//yH5BAEAAAMALAAAAACnAAsAAAJPnI+py+0Po5y0smCz3rz7LAjfSJbmGYpGyrbuC8fyTNf2jef3qvf+DwwKdYOh8YhMKgWApfMJjYqk1Kp1d8pqt1yeqgsOiymhsfmMPgASBQA7)no-repeatrightcenter;width:50px;height:10px;margin:016px;opacity:.3;-ms-filter:\"alpha(opacity=30)\"}";
//		List<CssDeclaration> cssDeclerationList = cssDeclerationExtraction.extract(cssString);
//		CssDeclaration cssDecleration1 = cssDeclerationList.get(0);
//		assertEquals("background:url(data:image//gif;base64,R0lGODlhpwALAPEAAJ2dnZubm21tbf//yH5BAEAAAMALAAAAACnAAsAAAJPnI+py+0Po5y0smCz3rz7LAjfSJbmGYpGyrbuC8fyTNf2jef3qvf+DwwKdYOh8YhMKgWApfMJjYqk1Kp1d8pqt1yeqgsOiymhsfmMPgASBQA7)no-repeatrightcenter;width:50px;height:10px;margin:016px;opacity:.3;-ms-filter:\"alpha(opacity=30)\";", cssDecleration1.toString());
//	}
	

}
