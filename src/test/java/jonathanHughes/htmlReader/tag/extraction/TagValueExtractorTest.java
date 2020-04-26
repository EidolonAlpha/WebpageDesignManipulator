package jonathanHughes.htmlReader.tag.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.tagValue.TagValueExtractor;

public class TagValueExtractorTest {
	
	private TagValueExtractor tagValueExtractor = new TagValueExtractor();
	
	@Test
	public void test_tag_extraction_invalid_tag() {
		String html = "dsgagdfgsdfg";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals(null, extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_no_attributes_no_space() {
		String html = "<p>";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("p", extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_no_attributes_invalid_spacing() {
		String html = "< p >";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("p", extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_no_attributes_valid_spacing() {
		String html = "<p >";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("p", extractedTagValue);
	}
		
	@Test
	public void test_tag_extraction_single_attribute_no_spacing() {
		String html = "<h1style=\"color:blue;\">";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("h1style=\"color:blue;\"", extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_single_attribute_invalid_spacing() {
		String html = "< h1style=\"color:blue;\">";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("", extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_single_attribute_valid_spacing() {
		String html = "<h1 style = \"color:blue;\">";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("h1", extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_multiple_attribute_no_spacing() {
		String html = "<h1style=\"border:2pxsolidTomato;background-color:DodgerBlue;\">Hello World</h1>";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("h1style=\"border:2pxsolidTomato;background-color:DodgerBlue;\"", extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_multiple_attribute_invalid_spacing() {
		String html = "< h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">Hello World</h1>";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("", extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_multiple_attribute_valid_spacing() {
		String html = "<h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">Hello World</h1>";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("h1", extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_no_attributes_doctype_html() {
		String html = "<!DOCTYPE html>";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("!DOCTYPE html", extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_of_tag_with_href() {
		String html = "<a class=\"w3-bar-item w3-button\" href='/html/default.asp' title='HTML Tutorial'>HTML</a>";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("a", extractedTagValue);
	}
	
	@Test
	public void test_tag_extraction_of_url() {
		String html = "<script src=\"//static.h-bid.com/sncmp/latest/sncmp_stub.min.js\" type=\"text/javascript\">";
		String extractedTagValue = tagValueExtractor.extract(html);
		assertEquals("script", extractedTagValue);
	}
}
