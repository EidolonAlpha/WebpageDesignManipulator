package jonathanHughes.htmlReader.tag.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.extraction.TagExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;

public class TagExtractorTest {
	
	TagExtractor tagListExtractor = new TagExtractor();
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void test_tag_extraction_no_tags() {
		String htmlString = "div /div";
		List<Tag> extractedTags = tagListExtractor.extract(htmlString);
		assertEquals(0, extractedTags.size());
	}
	
	@Test
	public void test_tag_extraction_no_attributes() {
		String htmlString = "<div> </div>";
		List<Tag> extractedTags = tagListExtractor.extract(htmlString);
		assertEquals("div", extractedTags.get(0).getTagValue());
		assertEquals("/div", extractedTags.get(1).getTagValue());
	}
	
	@Test
	public void test_tag_extraction_with_attribute() {
		String htmlString = "<div class=\"container\"> </div>";
		List<Tag> extractedTags = tagListExtractor.extract(htmlString);
		assertEquals("div", extractedTags.get(0).getTagValue());
		assertEquals("/div", extractedTags.get(1).getTagValue());
	}
	
	@Test
	public void test_tag_extraction_with_mutliple_attributes() {
		String htmlString = "<h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">Hello World</h1>";
		List<Tag> extractedTags = tagListExtractor.extract(htmlString);
		assertEquals("h1", extractedTags.get(0).getTagValue());
		assertEquals("/h1", extractedTags.get(1).getTagValue());
	}
	
	@Test
	public void test_tag_extraction_with_tag_in_attributes() {
		String htmlString = "<h1 style=\"<h1>border: 2px solid Tomato;\">Hello World</h1>";
		List<Tag> extractedTags = tagListExtractor.extract(htmlString);
		assertEquals("h1", extractedTags.get(0).getTagValue());
		assertEquals("/h1", extractedTags.get(1).getTagValue());
	}
	
	@Test
	public void test_tag_extraction_nested_div() {
		String htmlString = "<div class=\"container\"> <div> </div> </div>";
		List<Tag> extractedTags = tagListExtractor.extract(htmlString);
		assertEquals("div", extractedTags.get(0).getTagValue());
		assertEquals("div", extractedTags.get(1).getTagValue());
		assertEquals("/div", extractedTags.get(2).getTagValue());
		assertEquals("/div", extractedTags.get(3).getTagValue());
	}
	
	@Test
	public void test_tag_extraction_no_attributes_to_string() {
		String htmlString = "<div> </div>";
		List<Tag> extractedTags = tagListExtractor.extract(htmlString);
		assertEquals("<div>", extractedTags.get(0).toString());
		assertEquals("</div>", extractedTags.get(1).toString());
	}
	
	@Test
	public void test_tag_extraction_with_attribute_to_string() {
		String htmlString = "<div class=\"container\"> </div>";
		List<Tag> extractedTags = tagListExtractor.extract(htmlString);
		assertEquals("<div class=\"container\">", extractedTags.get(0).toString());
		assertEquals("</div>", extractedTags.get(1).toString());
	}
	
	@Test
	public void test_tag_extraction_with_mutliple_attributes_to_string() {
		String htmlString = "<h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">Hello World</h1>";
		List<Tag> extractedTags = tagListExtractor.extract(htmlString);
		assertEquals("<h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">", extractedTags.get(0).toString());
		assertEquals("</h1>", extractedTags.get(1).toString());
	}
	
	@Test
	public void test_tag_extraction_nested_div_to_string() {
		String htmlString = "<div class=\"container\"> <div> </div> </div>";
		List<Tag> extractedTags = tagListExtractor.extract(htmlString);
		assertEquals("<div class=\"container\">", extractedTags.get(0).toString());
		assertEquals("<div>", extractedTags.get(1).toString());
		assertEquals("</div>", extractedTags.get(2).toString());
		assertEquals("</div>", extractedTags.get(3).toString());
	}
	
	@Test
	public void test_tag_extraction_single_attribute_invalid_spacing() {
		String html = "< h1style=\"color:blue;\">";
		List<Tag> extractedTagList = tagListExtractor.extract(html);
		assertEquals("< h1style=\"color:blue;\">", extractedTagList.get(0).toString());
	}
	
	@Test
	public void test_tag_extraction_single_attribute_valid_spacing() {
		String html = "<h1 style = \"color:blue;\">";
		List<Tag> extractedTagList = tagListExtractor.extract(html);
		assertEquals("<h1 style=\"color:blue;\">", extractedTagList.get(0).toString());
	}
	
	@Test
	public void test_tag_extraction_multiple_attribute_no_spacing() {
		String html = "<h1style=\"border:2pxsolidTomato;background-color:DodgerBlue;\">Hello World</h1>";
		List<Tag> extractedTagList = tagListExtractor.extract(html);
		assertEquals("<h1style=\"border:2pxsolidTomato;background-color:DodgerBlue;\" =\"border:2pxsolidTomato;background-color:DodgerBlue;\">", extractedTagList.get(0).toString());
	}
	
	@Test
	public void test_tag_extraction_multiple_attribute_valid_spacing_toString() {
		String html = "< h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">Hello World</h1>";
		List<Tag> extractedTagList = tagListExtractor.extract(html);
		assertEquals("< style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">", extractedTagList.get(0).toString());
	}
	
	@Test
	public void test_tag_extraction_multiple_attribute_valid_spacing_value() {
		String html = "<h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">Hello World</h1>";
		List<Tag> extractedTagList = tagListExtractor.extract(html);
		assertEquals("<h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">", extractedTagList.get(0).toString());
		assertEquals("h1", extractedTagList.get(0).getTagValue());
	}
	
	@Test
	public void test_tag_extraction_multiple_attribute_valid_spacing_attributes() {
		String html = "<h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">Hello World</h1>";
		List<Tag> extractedTagList = tagListExtractor.extract(html);
		assertEquals("<h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">", extractedTagList.get(0).toString());
		assertEquals("style=\"border: 2px solid Tomato; background-color:DodgerBlue;\"", extractedTagList.get(0).getTagAttributes().get(0).toString());
	}
	
	
	@Test
	public void test_tag_extraction_no_attributes_doctype_html() {
		String html = "<!DOCTYPE html>";
		List<Tag> extractedTagList = tagListExtractor.extract(html);
		assertEquals("<!DOCTYPE html>", extractedTagList.get(0).toString());
	}
	
	@Test
	public void test_tag_extraction_of_tag_with_href_value() {
		String html = "<a class=\"w3-bar-item w3-button\" href='/html/default.asp' title='HTML Tutorial'>HTML</a>";
		List<Tag> extractedTagList = tagListExtractor.extract(html);
		assertEquals("<a class=\"w3-bar-item w3-button\" href=\"/html/default.asp\" title=\"HTML Tutorial\">", extractedTagList.get(0).toString());
	}
	
	@Test
	public void test_tag_extraction_of_tag_with_href_attribute() {
		String html = "<a class=\"w3-bar-item w3-button\" href='/html/default.asp' title='HTML Tutorial'>HTML</a>";
		List<Tag> extractedTagList = tagListExtractor.extract(html);
		assertEquals("class=\"w3-bar-item w3-button\"", extractedTagList.get(0).getTagAttributes().get(0).toString());
	}
	
	@Test
	public void test_tag_extraction_of_url() {
		String html = "<script src=\"//static.h-bid.com/sncmp/latest/sncmp_stub.min.js\" type=\"text/javascript\">";
		List<Tag> extractedTagList = tagListExtractor.extract(html);
		assertEquals("<script src=\"//static.h-bid.com/sncmp/latest/sncmp_stub.min.js\" type=\"text/javascript\">", extractedTagList.get(0).toString());
	}
	
//	@Test
//	public void test_tag_extraction_with_tag_in_attributes_to_string() {
//		String htmlString = "<h1 style=\"<h1>border: 2px solid Tomato;\">Hello World</h1>";
//		List<Tag> extractedTags = tagExtractor.extractTags(htmlString);
//		assertEquals("<h1 style=\"<h1>border: 2px solid Tomato;\">", extractedTags.get(0).toString());
//		assertEquals("</h1>", extractedTags.get(1).toString());
//	}
	
}
