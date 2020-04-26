package jonathanHughes.htmlReader.css.extraction.mediaQuery;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import jonathanHughes.htmlReader.webpage.components.css.mediaQuery.extraction.MediaFeaturesExtractor;
import jonathanHughes.htmlReader.webpage.components.css.mediaQuery.model.MediaFeatures;

public class MediaFeaturesExtractorTest {
	
	MediaFeaturesExtractor featuresExtractor = new MediaFeaturesExtractor();
	
	@Test
	public void test_extraction_of_invalid() {
		List<MediaFeatures> features = featuresExtractor.extract("qwerty");
		assertEquals(0, features.size());
	}

	@Test
	public void test_extraction_of_max_width() {
		List<MediaFeatures> features = featuresExtractor.extract("media only screen and (max-width: 600px)");
		assertTrue(features.size() == 1);
		assertEquals("max-width", features.get(0).getFeature());
		assertEquals("600px",features.get(0).getValue());
	}
	
	@Test
	public void test_extraction_of_key_frames() {
		List<MediaFeatures> features = featuresExtractor.extract("@keyframes w3-spin {   0% { transform: rotate(0deg); }");
		assertTrue(features.size() == 0);
	}

	
}
