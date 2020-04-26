package jonathanHughes.htmlReader.webpage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jonathanHughes.htmlReader.TestWebsiteData;
import jonathanHughes.htmlReader.webpage.service.WebpageService;

public class WebpageServiceTest {
	
	TestWebsiteData testData = new TestWebsiteData();
	WebpageService webpageService = new WebpageService();
	
	@Test
	public void extractHTMLWebpagePass() {
		boolean result = webpageService.extractHTML(testData.getWebsite1());
		assertTrue(result);
	}
	
	@Test
	public void extractHTMLWebpage2Pass() {
		boolean result = webpageService.extractHTML(testData.getWebsie2());
		assertTrue(result);
	}
	
	@Test
	public void extractHTMLWebpage3Pass() {
		boolean result = webpageService.extractHTML(testData.getWebsite3());
		assertTrue(result);
	}
	
	@Test
	public void extractHTMLWebpage4Pass() {
		boolean result = webpageService.extractHTML(testData.getWebsite4());
		assertTrue(result);
	}
	
	@Test
	public void extractCSSWebpageFail() {
		boolean result = webpageService.extractHTML("");
		assertTrue(!result);
	}
		
	@Test
	public void extractCSSWebpagePassExtenalCSS() throws JsonMappingException, JsonProcessingException {
		boolean result = webpageService.extractCSS("{\"rules\" : [], \"links\" : [\"https://developers.redhat.com/blog/wp-content/plugins/selection-sharer/css/selection-sharer.css?ver=0.1\"]}");
		assertTrue(result);
	}
	
	@Test
	public void extractHTMLWebpageFail() {
		boolean result = webpageService.extractHTML("");
		assertTrue(!result);
	}


}
