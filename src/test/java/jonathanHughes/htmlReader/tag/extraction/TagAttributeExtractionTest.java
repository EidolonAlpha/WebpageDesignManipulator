package jonathanHughes.htmlReader.tag.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.extraction.TagAttributeExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;

public class TagAttributeExtractionTest {
	
private TagAttributeExtractor tagAttributeExtractor = new TagAttributeExtractor();
		
	@Test
	public void test_tag_extraction_no_attributes_valid() {
		String html = "";
		List<TagAtribute> extractedAttributes = tagAttributeExtractor.extract(html);
		assertEquals(0, extractedAttributes.size());
	}
	
	@Test
	public void test_tag_extraction_invalid_attributes_valid() {
		String html = "dsfdsf";
		List<TagAtribute> extractedAttributes = tagAttributeExtractor.extract(html);
		assertEquals(0, extractedAttributes.size());
	}
	
	@Test
	public void test_tag_extraction_single_attribute_valid() {
		String html = "style = \"color:blue;\"";
		List<TagAtribute> extractedAttributes = tagAttributeExtractor.extract(html);
		assertEquals(1, extractedAttributes.size());
		TagAtribute firstAttribute = extractedAttributes.get(0);
		assertEquals("style", firstAttribute.getType());
		assertEquals("color:blue;", firstAttribute.getValue());
	}
	
	@Test
	public void test_tag_extraction_multiple_attribute_no_spacing() {
		String html = "jsmodel=\"jivSc\"class=\"srp tbo vasq\"";
		List<TagAtribute> extractedAttributes = tagAttributeExtractor.extract(html);
		TagAtribute firstAttribute = extractedAttributes.get(0);
		assertEquals(2, extractedAttributes.size());
		assertEquals("jsmodel", firstAttribute.getType());
		assertEquals("jivSc", firstAttribute.getValue());
		TagAtribute secondAttribute = extractedAttributes.get(1);
		assertEquals("class", secondAttribute.getType());
		assertEquals("srp tbo vasq", secondAttribute.getValue());
	}
	
	
	@Test
	public void test_tag_extraction_multiple_attribute_valid_spacing() {
		String html = "jsmodel=\"jivSc\" class=\"srp tbo vasq\"";
		List<TagAtribute> extractedAttributes = tagAttributeExtractor.extract(html);
		TagAtribute firstAttribute = extractedAttributes.get(0);
		assertEquals(2, extractedAttributes.size());
		assertEquals("jsmodel", firstAttribute.getType());
		assertEquals("jivSc", firstAttribute.getValue());
		TagAtribute secondAttribute = extractedAttributes.get(1);
		assertEquals("class", secondAttribute.getType());
		assertEquals("srp tbo vasq", secondAttribute.getValue());
	}
}
