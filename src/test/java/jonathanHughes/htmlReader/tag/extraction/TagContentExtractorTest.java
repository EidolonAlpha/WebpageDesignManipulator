package jonathanHughes.htmlReader.tag.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.content.TagContent;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.content.extraction.TagContentExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.extraction.TagExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.util.ClosingTagIndexFinder;

public class TagContentExtractorTest {
	
	TagContentExtractor tagContentExtractor = new TagContentExtractor();
	TagExtractor tagExtractor = new TagExtractor();
	private ClosingTagIndexFinder closingTagIndexFinder = new ClosingTagIndexFinder();

	@Before
	public void setup() {
		
	}
	
	@Test
	public void test_extraction_of_tag_content() {
		String html = "<tag>inner tag 1 content</tag>";
		List<Tag> tagList = tagExtractor.extract(html);
		int endTag = closingTagIndexFinder.getIndexOfMatchingEndTag(tagList, 0);
		List<TagContent> tagContent = tagContentExtractor.extractTagContent(html, tagList, 0, endTag);
		assertEquals("inner tag 1 content", tagContent.get(0).getContentText());
		assertEquals(1, tagContent.size());
	}
	
	@Test
	public void test_extraction_of_tag_content_no_tags() {
		String html = "ssdfgsdgsdg";
		List<Tag> tagList = tagExtractor.extract(html);
		int endTag = closingTagIndexFinder.getIndexOfMatchingEndTag(tagList, 0);
		assertEquals(-1, endTag);
	}
	
	@Test
	public void test_extraction_of_tag_content_with_two_same_level_tags() {
		String html = "<tag>tag 1 content</tag> <tag>tag 2 content</tag>";
		List<Tag> tagList = tagExtractor.extract(html);
		int endTag = closingTagIndexFinder.getIndexOfMatchingEndTag(tagList, 0);
		List<TagContent> tagContent = tagContentExtractor.extractTagContent(html, tagList, 0, endTag);
		assertEquals("tag 1 content", tagContent.get(0).getContentText());
		assertEquals("tag 2 content", tagContent.get(1).getContentText());
		assertEquals(2, tagContent.size());
	}
	
	@Test
	public void test_extraction_of_outer_tag_content_with_multiple_inner_tags() {
		String html = "<tag> <tag>inner tag 1 content</tag> <tag>inner tag 2 content</tag> </tag>";
		List<Tag> tagList = tagExtractor.extract(html);
		int endTag = closingTagIndexFinder.getIndexOfMatchingEndTag(tagList, 0);
		List<TagContent> tagContent = tagContentExtractor.extractTagContent(html, tagList, 0, endTag);
		assertEquals(" <tag>inner tag 1 content</tag> <tag>inner tag 2 content</tag> ", tagContent.get(0).getContentText());
	}
	
	@Test
	public void test_extraction_of_inner_tag_content_with_multiple_inner_tags() {
		String html = "<tag> <tag>inner tag 1 content</tag> <tag>inner tag 2 content</tag> </tag>";
		List<Tag> tagList = tagExtractor.extract(html);
		int endTag = closingTagIndexFinder.getIndexOfMatchingEndTag(tagList, 0);
		List<TagContent> tagContent = tagContentExtractor.extractTagContent(html, tagList, 0, endTag);
		assertEquals(" <tag>inner tag 1 content</tag> <tag>inner tag 2 content</tag> ",  tagContent.get(0).getContentText());
		assertEquals(1, tagContent.size());
	}
	
	@Test
	public void test_extraction_of_multiple_tags_with_attributes_in_tag() {
		String html = "<a href=\"#\" class=\"active\"> Home</a> <a href=\"#\">Link</a> <a href=\"#\">Link</a><a href=\"#\" class=\"right\">Link</a>";
		List<Tag> tagList = tagExtractor.extract(html);
		int startTagIndex = 0;
		int endTag = closingTagIndexFinder.getIndexOfMatchingEndTag(tagList, startTagIndex);
		List<TagContent> tagContent = tagContentExtractor.extractTagContent(html, tagList, 0, endTag);
		assertEquals(" Home",  tagContent.get(0).getContentText());
		assertEquals(1, tagContent.size());
	}
}
