package jonathanHughes.htmlReader.webpage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jonathanHughes.htmlReader.TestWebsiteData;
import jonathanHughes.htmlReader.webpage.builder.WebpageBuilder;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.model.Webpage;

public class WebpageTest {
	
	private TestWebsiteData webpageData = new TestWebsiteData();
	private WebpageBuilder webpageBuilder;
	private Webpage testWebpage = new Webpage();
		
	@Test
	public void getTagPairWithCssSelector() {
		webpageBuilder = new WebpageBuilder(new Webpage());
		webpageBuilder.buildWebpageTagPairListFrom(webpageData.getWebsite4());
		testWebpage.setTagPairList(webpageBuilder.buildWebpageTagPairListFrom(webpageData.getWebsite4()));
		assertEquals("<div class=\"content\">", testWebpage.getHtmlTags().getTagPairWithCssClass(".middle.layout-1 .content").get(0).getStartTag().toString());
	}
	
	@Test
	public void getTagPairParentWithCssSelector() {
		webpageBuilder = new WebpageBuilder(new Webpage());
		webpageBuilder.buildWebpageTagPairListFrom(webpageData.getWebsite4());
		testWebpage.setTagPairList(webpageBuilder.buildWebpageTagPairListFrom(webpageData.getWebsite4()));
		TagPair parentTagPair = testWebpage.getHtmlTags().getParentTagPair(".middle.layout-1 .content");
		assertEquals("StartTag : <div class=\"middle layout-1\"> Content : [        <div class=\"gallery\">Gallery</div>        <div class=\"content\">Content (this layout works perfectly)</div>        <div class=\"sidebar\">Sidebar</div>    ] EndTag : </div>", parentTagPair.toString());
	}
	
	@Test
	public void getTagPairSiblingsWithCssSelector() {
		webpageBuilder = new WebpageBuilder(new Webpage());
		testWebpage.setTagPairList(webpageBuilder.buildWebpageTagPairListFrom(webpageData.getWebsite4()));
		testWebpage.setCSSRuleSetList(webpageBuilder.buildWebpageCSSRuleSetListFrom(webpageData.getWebsite1CssList(), new ArrayList<String>()));
		List<CssRuleSet> siblingTagPairList = testWebpage.getSiblingRuleSetOf(".middle.layout-1 .content");
		assertEquals(3, siblingTagPairList.size());
		assertEquals(".middle.layout-1.gallery { width: 100%; }", siblingTagPairList.get(0).toString());
		assertEquals(".middle.layout-1.content { width: 75%; }", siblingTagPairList.get(1).toString());
		assertEquals(".middle.layout-1.sidebar { width: 25%; }", siblingTagPairList.get(2).toString());
		System.out.println();
	}

}
