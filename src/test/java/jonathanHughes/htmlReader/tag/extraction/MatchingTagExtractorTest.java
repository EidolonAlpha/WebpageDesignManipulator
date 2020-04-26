package jonathanHughes.htmlReader.tag.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.extraction.TagExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.util.ClosingTagIndexFinder;

public class MatchingTagExtractorTest {
	
	TagExtractor tagExtractor = new TagExtractor();
	ClosingTagIndexFinder matchingTagExtractor = new ClosingTagIndexFinder();
	
	@Test
	public void test_invalid_tag() {
		String html = "<sfsdf>sdsdsf";
		List<Tag> tagList = tagExtractor.extract(html);
		int matchingEndTagIndex = matchingTagExtractor.getIndexOfMatchingEndTag(tagList, 0);
		assertEquals(-1, matchingEndTagIndex);
	}
	
	@Test
	public void test_no_matching_tag() {
		String html = "<sfsdf> <dsfd>";
		List<Tag> tagList = tagExtractor.extract(html);
		int matchingEndTagIndex = matchingTagExtractor.getIndexOfMatchingEndTag(tagList, 0);
		assertEquals(-1, matchingEndTagIndex);
	}
	
	@Test
	public void test_get_matching_tag() {
		String html = "<tag>inner tag 1 content</tag>";
		List<Tag> tagList = tagExtractor.extract(html);
		int matchingEndTagIndex = matchingTagExtractor.getIndexOfMatchingEndTag(tagList, 0);
		assertEquals(1, matchingEndTagIndex);
	}
	
	@Test
	public void test_get_matching_tag_with_nested_tag_match_outer() {
		String html = "<tag> <tag>inner tag 1 content</tag> </tag>";
		List<Tag> tagList = tagExtractor.extract(html);
		int matchingEndTagIndex = matchingTagExtractor.getIndexOfMatchingEndTag(tagList, 0);
		assertEquals(3, matchingEndTagIndex);
	}
	
	@Test
	public void test_get_matching_tag_with_nested_tag_match_inner() {
		String html = "<tag> <tag>inner tag 1 content</tag> </tag>";
		List<Tag> tagList = tagExtractor.extract(html);
		int matchingEndTagIndex = matchingTagExtractor.getIndexOfMatchingEndTag(tagList, 1);
		assertEquals(2, matchingEndTagIndex);
	}
	
	@Test
	public void test_get_matching_tag_with_multiple_nested_tags_match_outer() {
		String html = "<tag> <tag>inner tag 1 content</tag> <tag>inner tag 2 content</tag> </tag>";
		List<Tag> tagList = tagExtractor.extract(html);
		int matchingEndTagIndex = matchingTagExtractor.getIndexOfMatchingEndTag(tagList, 0);
		assertEquals(5, matchingEndTagIndex);
	}
	
	@Test
	public void test_get_matching_tag_with_multipe_nested_tags_match_inner_first() {
		String html = "<tag> <tag>inner tag 1 content</tag> <tag>inner tag 2 content</tag></tag>";
		List<Tag> tagList = tagExtractor.extract(html);
		int matchingEndTagIndex = matchingTagExtractor.getIndexOfMatchingEndTag(tagList, 1);
		assertEquals(2, matchingEndTagIndex);
	}
	
	@Test
	public void test_get_matching_tag_with_multipe_nested_tags_match_inner_second() {
		String html = "<tag> <tag>inner tag 1 content</tag> <tag>inner tag 2 content</tag></tag>";
		List<Tag> tagList = tagExtractor.extract(html);
		int matchingEndTagIndex = matchingTagExtractor.getIndexOfMatchingEndTag(tagList, 3);
		assertEquals(4, matchingEndTagIndex);
	}
	
}
