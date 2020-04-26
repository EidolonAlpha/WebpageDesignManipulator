package jonathanHughes.htmlReader.css.extraction.mediaQuery;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import jonathanHughes.htmlReader.webpage.components.css.mediaQuery.extraction.MediaTypeExtractor;
import jonathanHughes.htmlReader.webpage.components.css.mediaQuery.model.MediaType;

public class MediaTypeExtractorTests {
	
	MediaTypeExtractor mediaTypeExtractor = new MediaTypeExtractor();
	
	@Test
	public void testExtractionOfInvalid() {
		String mediaRule = "qwerty";
		MediaType type = mediaTypeExtractor.extract(mediaRule);
		assertEquals(null, type);
	}
	
	@Test
	public void testExtractionOfMediaTypeScreen() {
		String mediaRule = "@media screen and (max-width: 600px)";
		MediaType type = mediaTypeExtractor.extract(mediaRule);
		assertEquals("@media screen and", type.getMediaTypeValue());
	}
	
	@Test
	public void testExtractionOfMediaTypeScreenOnly() {
		String mediaRule = "@media only screen and (max-width: 600px)";
		MediaType type = mediaTypeExtractor.extract(mediaRule);
		assertEquals("@media only screen and", type.getMediaTypeValue());
		assertTrue(type.isOnly());
		assertTrue(!type.isNot());
	}
	
	@Test
	public void testExtractionOfMediaTypeScreenNot() {
		String mediaRule = "@media not screen and (max-width: 600px)";
		MediaType type = mediaTypeExtractor.extract(mediaRule);
		assertEquals("@media not screen and", type.getMediaTypeValue());
		assertTrue(type.isNot());
		assertTrue(!type.isOnly());
	}

}
