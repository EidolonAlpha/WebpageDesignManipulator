//package jonathanHughes.htmlReader;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//
//import jonathanHughes.htmlReader.webpage.css.model.cssRuleSet.CssRuleSet;
//import jonathanHughes.htmlReader.webpage.extraction.WebpageExtraction;
//import jonathanHughes.htmlReader.webpage.html.tag.models.tagPair.TagPair;
//
//public class WebpageExtractionTest {
//	
//	WebpageExtraction webpageExtraction = new WebpageExtraction();
//	
//	@Test
//	public void extractWebsiteCSS() {
//		String webstieHtml = new TestWebsiteData().getWebsite3();
//		webpageExtraction.setUpWebpage(webstieHtml);
//		List<CssRuleSet> extractedCSS = webpageExtraction.getExtractedCss();
//		assertEquals("[.gallery { height: 100px; background-color: #CCC; }, .content { height: 200px; background-color: #EEE; }, .sidebar { height: 200px; background-color: #AAA; }, .middle { display: flex; flex-direction: row; flex-wrap: wrap; }, .middle.layout-1 .gallery { order: 1; width: 100%; }, .middle.layout-1 .content { order: 3; width: 75%; }, .middle.layout-1 .sidebar { order: 2; width: 25%; }, .middle.layout-2 { position: relative; }, .middle.layout-2 .gallery { width: 75%; margin-left: 25%; }, .middle.layout-2 .content { width: 75%; margin-left: 25%; }, .middle.layout-2 .sidebar { position: absolute; top: 0; left: 0; width: 25%; height: 100%; }]", extractedCSS.toString());
//	}
//	
//	@Test
//	public void extractWebsitePatentStartTagValue() {
//		String websiteHtml = new TestWebsiteData().getWebsite1();
//		webpageExtraction.setUpWebpage(websiteHtml);
//		List<TagPair> tagPairList = webpageExtraction.getParentTagPair();
//		TagPair tagPair = tagPairList.get(0);
//		String parentTagValue = tagPair.getStartTag().getTagValue();
//		assertEquals("html", parentTagValue);
//	}
////	
////	@Test
////	public void extractWebsitePatentEndTagValue() {
////		String websiteHtml = new TestWebsiteData().getWebsite1();
////		webpageExtraction.setUpWebpage(websiteHtml);
////		List<TagPair> tagPairList = webpageExtraction.getParentTagPair();
////		TagPair tagPair = tagPairList.get(0);
////		String parentTagValue = tagPair.getEndTag().getTagValue();
////		assertEquals("/html", parentTagValue);
////	}
////	
////	@Test
////	public void extractWebsitePatentStartTagAttributeType() {
////		String websiteHtml = new TestWebsiteData().getWebsite1();
////		webpageExtraction.setUpWebpage(websiteHtml);
////		List<TagPair> tagPairList = webpageExtraction.getParentTagPair();
////		TagPair tagPair = tagPairList.get(0);
////		Tag parentTag = tagPair.getStartTag();
////		List<TagAtribute> tagAtteibuteList = parentTag.getTagAttributes();
////		assertEquals(1, tagAtteibuteList.size());
////		TagAtribute tagAttribute = tagAtteibuteList.get(0);
////		assertEquals("lang", tagAttribute.getType());
////	}
////	
////	@Test
////	public void extractWebsitePatentStartTagAttributeValue() {
////		String websiteHtml = new TestWebsiteData().getWebsite1();
////		webpageExtraction.setUpWebpage(websiteHtml);
////		List<TagPair> tagPairList = webpageExtraction.getParentTagPair();
////		TagPair tagPair = tagPairList.get(0);
////		Tag parentTag = tagPair.getStartTag();
////		List<TagAtribute> tagAtteibuteList = parentTag.getTagAttributes();
////		assertEquals(1, tagAtteibuteList.size());
////		TagAtribute tagAttribute = tagAtteibuteList.get(0);
////		assertEquals("en", tagAttribute.getValue());
////	}
////	
////	@Test
////	public void extractWebsitePatentTagPairContent() {
////		String websiteHtml = new TestWebsiteData().getWebsite1();
////		webpageExtraction.setUpWebpage(websiteHtml);
////		List<TagPair> tagPairList = webpageExtraction.getParentTagPair();
////		TagPair tagPair = tagPairList.get(0);
////		List<TagContent> tagContent = tagPair.getContent();
////		assertEquals(1, tagContent.size());
////	}
////	
////	@Test
////	public void extractWebsitePatentTagPairInnerTagPairs() {
////		String websiteHtml = new TestWebsiteData().getWebsite1();
////		webpageExtraction.setUpWebpage(websiteHtml);
////		List<TagPair> tagPairList = webpageExtraction.getParentTagPair();
////		TagPair tagPair = tagPairList.get(0);
////		List<TagPair> innerTagPairList = tagPair.getInnerTagList();
////		assertEquals(2, innerTagPairList.size());
////		TagPair innerTagPair = innerTagPairList.get(0);
////		assertEquals("head", innerTagPair.getStartTag().getTagValue());
////	}
////	
////	@Test
////	public void extractWebsitePatentTagsNumber() {
////		String websiteHtml = new TestWebsiteData().getWebsite1();
////		webpageExtraction.setUpWebpage(websiteHtml);
////		List<TagPair> tagPairList = webpageExtraction.getParentTagPair();
////		assertEquals(1, tagPairList.size());
////	}
////	
////	@Test
////	public void extractWebsiteCssListSizeTest() {
////		String websiteHtml = new TestWebsiteData().getWebsite1();
////		webpageExtraction.setUpWebpage(websiteHtml);
////		List<CssRuleSet> css = webpageExtraction.getExtractedCss();
////		assertEquals(9, css.size());
////	}
////	
////	@Test
////	public void extractWebsite2PatentStartTagValue() {
////		String websiteHtml = new TestWebsiteData().getWebsie2();
////		webpageExtraction.setUpWebpage(websiteHtml);
////		List<TagPair> tagPairList = webpageExtraction.getParentTagPair();
////		TagPair tagPair = tagPairList.get(0);
////		String parentTagValue = tagPair.getStartTag().getTagValue();
////		assertEquals("html", parentTagValue);
////	}
//	
//}
