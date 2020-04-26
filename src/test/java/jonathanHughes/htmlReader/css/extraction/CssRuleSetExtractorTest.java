package jonathanHughes.htmlReader.css.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model.CssDeclaration;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.extraction.CssRuleSetExtractor;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;

public class CssRuleSetExtractorTest {
	
	CssRuleSetExtractor cssRuleSetExtractor = new CssRuleSetExtractor();
	
	@Test
	public void testInvalidDeclarationRuleSet() {
		String cssRuleSetText = "qwerty";
		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
		assertEquals("{ }", cssRuleSet.toString());
	}
	
	@Test
	public void testEmptyDeclarationRuleSet() {
		String cssRuleSetText = "";
		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
		assertEquals("{ }", cssRuleSet.toString());
	}
	
	@Test
	public void test_P_RuleSet_2_declarations_All() {
		String cssRuleSetText = "p { color:red; text-align: center; }";
		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
		assertEquals("p { color: red; text-align: center; }", cssRuleSet.toString());
		assertEquals("p", cssRuleSet.getSelector());
		CssDeclaration firstDeclaration = cssRuleSet.getCssDeclaration().get(0);
		assertEquals("color", firstDeclaration.getProperty());
		assertEquals("red", firstDeclaration.getValues().get(0));
		CssDeclaration secondDeclaration = cssRuleSet.getCssDeclaration().get(1);
		assertEquals("text-align", secondDeclaration.getProperty());
		assertEquals("center", secondDeclaration.getValues().get(0));
	}
	
	@Test
	public void test_P_RuleSet_2_declarations_selctor() {
		String cssRuleSetText = "p { color:red; text-align: center; }";
		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
		assertEquals("p", cssRuleSet.getSelector());
	}
	
	@Test
	public void test_P_RuleSet_2_declarations_toString() {
		String cssRuleSetText = "p { color:red; text-align: center; }";
		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
		assertEquals("p { color: red; text-align: center; }", cssRuleSet.toString());
	}
	
	@Test
	public void test_P_RuleSet_2_declarations_declaration_1() {
		String cssRuleSetText = "p { color:red; text-align: center; }";
		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
		CssDeclaration firstDeclaration = cssRuleSet.getCssDeclaration().get(0);
		assertEquals("color", firstDeclaration.getProperty());
		assertEquals("red", firstDeclaration.getValues().get(0));
	}
	
	@Test
	public void test_P_RuleSet_2_declarations_declaration_2() {
		String cssRuleSetText = "p { color:red; text-align: center; }";
		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
		CssDeclaration secondDeclaration = cssRuleSet.getCssDeclaration().get(1);
		assertEquals("text-align", secondDeclaration.getProperty());
		assertEquals("center", secondDeclaration.getValues().get(0));
	}
	
	@Test
	public void test_P_RuleSet_1_declaration_mutliple_values_toString_test() {
		String cssRuleSetText = ".w3-input{border-bottom:1px solid #ccc;width:100%}";
		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
		assertEquals(".w3-input { border-bottom: 1px solid #ccc; width: 100%; }", cssRuleSet.toString());
	}
	
	@Test
	public void test_P_RuleSet_1_declaration_mutliple_values__selector_test() {
		String cssRuleSetText = ".w3-input{border-bottom:1px solid #ccc;width:100%}";
		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
		assertEquals(".w3-input", cssRuleSet.getSelector());
	}
	
	@Test
	public void test_P_RuleSet_1_declaration_mutliple_values_property_test() {
		String cssRuleSetText = ".w3-input{border-bottom:1px solid #ccc;width:100%}";
		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
		CssDeclaration firstDeclaration = cssRuleSet.getCssDeclaration().get(0);
		assertEquals("border-bottom", firstDeclaration.getProperty());
	}
	
//	@Test
//	public void test_P_RuleSet_1_declaration_mutliple_values__declaration_value_test() {
//		String cssRuleSetText = ".w3-input{border-bottom:1px solid #ccc;width:100%}";
//		CssRuleSet cssRuleSet = cssRuleSetExtractor.extract(cssRuleSetText);
//		CssDeclaration firstDeclaration = cssRuleSet.getCssDeclaration().get(0);
//		assertEquals("1px", firstDeclaration.getValues().get(0));
//	}
	
		

}
