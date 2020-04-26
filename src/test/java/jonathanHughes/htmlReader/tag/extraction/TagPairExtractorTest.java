package jonathanHughes.htmlReader.tag.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.extraction.TagPairExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;

public class TagPairExtractorTest {
	
	TagPairExtractor tagPairExtractor = new TagPairExtractor();	
	@Test
	public void tag_pair_extraction_test_attribute() {
		String html = "<div class=\"container\"> </div>";
		List<TagPair> tagPairList = tagPairExtractor.extract(html);
		TagPair tagPair = tagPairList.get(0);
		assertEquals("div", tagPair.getStartTag().getTagValue());
		assertEquals("/div", tagPair.getEndTag().getTagValue());
		assertEquals(0, tagPair.getInnerTagPairList().size());
		assertEquals(1, tagPair.getStartTag().getTagAttributes().size());
		assertEquals(" ", tagPair.getContent().get(0).getContentText());
	}
	
	@Test
	public void tag_pair_extraction_test() {
		String html = "<p> </p>";
		List<TagPair> tagPairList = tagPairExtractor.extract(html);
		TagPair tagPair = tagPairList.get(0);
		assertEquals("p", tagPair.getStartTag().getTagValue());
		assertEquals("/p", tagPair.getEndTag().getTagValue());
		assertEquals(0, tagPair.getInnerTagPairList().size());
		assertEquals(0, tagPair.getStartTag().getTagAttributes().size());
		assertEquals(" ", tagPair.getContent().get(0).getContentText());
	}
	
	@Test
	public void tag_pair_extraction_no_end_test() {
		String html = "<p>";
		List<TagPair> tagPairList = tagPairExtractor.extract(html);
		assertEquals(tagPairList.size(), 0);
	}
	
	@Test
	public void tag_pair_extraction_ivalid_test() {
		String html = "gfdggdfg";
		List<TagPair> tagPairList = tagPairExtractor.extract(html);
		assertEquals(tagPairList.size(), 0);
	}
	
	@Test
	public void tag_pair_with_attributes_no_content_extraction_test() {
		String htmlString = "<div class=\"container\"> </div>";
		List<TagPair> tagPairList = tagPairExtractor.extract(htmlString);
		TagPair tagPair = tagPairList.get(0);
		assertEquals("div", tagPair.getStartTag().getTagValue());
		assertEquals("/div", tagPair.getEndTag().getTagValue());
		assertEquals(0, tagPair.getInnerTagPairList().size());
		assertEquals(1, tagPair.getStartTag().getTagAttributes().size());
		assertEquals("class", tagPair.getStartTag().getTagAttributes().get(0).getType());
		assertEquals("container", tagPair.getStartTag().getTagAttributes().get(0).getValue());
		assertEquals(" ", tagPair.getContent().get(0).getContentText());
		assertEquals("container", tagPair.getCssClassList().get(0));
	}
	
	@Test
	public void get_tag_pair_class_list() {
		String htmlString = "<div class=\"container\"><div class=\"inner\"></div></div>";
		List<TagPair> tagPairList = tagPairExtractor.extract(htmlString);
		TagPair tagPair = tagPairList.get(0);
		assertEquals("div", tagPair.getStartTag().getTagValue());
		assertEquals("/div", tagPair.getEndTag().getTagValue());
		assertEquals(1, tagPair.getInnerTagPairList().size());
		assertEquals(1, tagPair.getStartTag().getTagAttributes().size());
		assertEquals("class", tagPair.getStartTag().getTagAttributes().get(0).getType());
		assertEquals("container", tagPair.getStartTag().getTagAttributes().get(0).getValue());
		assertEquals("<div class=\"inner\"></div>", tagPair.getContent().get(0).getContentText());
		assertEquals("inner", tagPair.getInnerTagPairList().get(0).getCssClassList().get(0));
		assertEquals("container", tagPair.getInnerTagPairList().get(0).getCssClassList().get(1));
	}
	
	@Test
	public void tag_pair_with_attributes_content_extraction_test() {
		String htmlString = "<h1 style=\"border: 2px solid Tomato; background-color:DodgerBlue;\">Hello World</h1>";
		List<TagPair> tagPairList = tagPairExtractor.extract(htmlString);
		TagPair tagPair = tagPairList.get(0);
		List<TagAtribute> tagAttributeList = tagPair.getStartTag().getTagAttributes();
		assertEquals("h1", tagPair.getStartTag().getTagValue());
		assertEquals("/h1", tagPair.getEndTag().getTagValue());
		assertEquals(0, tagPair.getInnerTagPairList().size());
		assertEquals(1, tagPair.getStartTag().getTagAttributes().size());
		assertEquals("style", tagAttributeList.get(0).getType());
		assertEquals("border: 2px solid Tomato; background-color:DodgerBlue;", tagAttributeList.get(0).getValue());
		assertEquals("Hello World", tagPair.getContent().get(0).getContentText());
	}
	
	@Test
	public void multiple_tag_pairs_on_same_level_with_content_extraction_test() {
		String htmlString = "<html><tag>tag 1 content</tag> <tag>tag 2 content</tag></html>";
		List<TagPair> tagPairList = tagPairExtractor.extract(htmlString);
		TagPair tagPair = tagPairList.get(0);
		assertEquals("<tag>tag 1 content</tag> <tag>tag 2 content</tag>", tagPair.getContent().get(0).getContentText());
		assertEquals(null, tagPair.getParentTag());
		TagPair innerTagPair = tagPair.getInnerTagPairList().get(0);
		TagPair innerTagPair2 = tagPair.getInnerTagPairList().get(1);
		assertEquals("tag 1 content", innerTagPair.getContent().get(0).getContentText());
		assertEquals(tagPair, innerTagPair.getParentTag());
		assertEquals("tag 2 content", innerTagPair2.getContent().get(0).getContentText());
		assertEquals(tagPair, innerTagPair2.getParentTag());
	}
	
	
	@Test
	public void tag_pair_extraction_with_tags_in_content_test() {
		String html = "<p>This is normal text - <b>and this is bold text</b>.</p>";
		List<TagPair> tagPairList = tagPairExtractor.extract(html);
		TagPair tagPair = tagPairList.get(0);
		assertEquals(1, tagPairList.size());
		assertEquals("This is normal text - <b>and this is bold text</b>.", tagPair.getContent().get(0).getContentText());
		assertEquals("and this is bold text", tagPair.getInnerTagPairList().get(0).getContent().get(0).getContentText());
	}
	
	@Test
	public void test_extraction_of_tag_pair_preceeding_self_closing_tag() {
		String html = "<!DOCTYPE html> <html> <head> <title>Page Title</title> </head> <body> <h1>This is a Heading</h1> <p>This is a paragraph.</p> </body> </html>";
		List<TagPair> tagPairList = tagPairExtractor.extract(html);
		TagPair tagPair = tagPairList.get(0);
		assertEquals(" <head> <title>Page Title</title> </head> <body> <h1>This is a Heading</h1> <p>This is a paragraph.</p> </body> ", tagPair.getContent().get(0).getContentText());
	}
	
	@Test
	public void test_extraction_of_tag_pair_inner_tags() {
		String html = "<!DOCTYPE html> <html> <head> <title>Page Title</title> </head> <body> <h1>This is a Heading</h1> <p>This is a paragraph.</p> </body> </html>";
		List<TagPair> tagPairList = tagPairExtractor.extract(html);
		TagPair tagPair = tagPairList.get(0);
		assertEquals(" <head> <title>Page Title</title> </head> <body> <h1>This is a Heading</h1> <p>This is a paragraph.</p> </body> ", tagPair.getContent().get(0).getContentText());
		List<TagPair> innerTagList = tagPair.getInnerTagPairList();
		assertEquals(2, innerTagList.size());
	}
	
}
