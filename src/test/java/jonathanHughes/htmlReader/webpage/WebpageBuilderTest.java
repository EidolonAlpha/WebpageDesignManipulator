package jonathanHughes.htmlReader.webpage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jonathanHughes.htmlReader.TestWebsiteData;
import jonathanHughes.htmlReader.webpage.builder.WebpageBuilder;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.model.Webpage;

public class WebpageBuilderTest {
	
	WebpageBuilder webpageBuilder = new WebpageBuilder(new Webpage());
	TestWebsiteData testData = new TestWebsiteData();
	private String[] selectorList = ".gallery,.content,.sidebar,.middle,.middle.layout-1 .gallery,.middle.layout-1 .content,.middle.layout-1 .sidebar,.middle.layout-2,.middle.layout-2 .gallery ,.middle.layout-2 .content ,.middle.layout-2 .sidebar".split(",");
	
	@Test
	public void buildCSSRuleSet() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String cssStringList = "[\".gallery { height: 100px; background-color: rgb(204, 204, 204); }\",\".content { height: 200px; background-color: rgb(238, 238, 238); }\",\".sidebar { height: 200px; background-color: rgb(170, 170, 170); }\",\".middle { display: flex; flex-flow: row wrap; }\",\".middle.layout-1 .gallery { order: 1; width: 100%; }\",\".middle.layout-1 .content { order: 3; width: 75%; }\",\".middle.layout-1 .sidebar { order: 2; width: 25%; }\",\".middle.layout-2 { position: relative; }\",\".middle.layout-2 .gallery { width: 75%; margin-left: 25%; }\",\".middle.layout-2 .content { width: 75%; margin-left: 25%; }\",\".middle.layout-2 .sidebar { position: absolute; top: 0px; left: 0px; width: 25%; height: 100%; }\"]";
		List<String> cssList = mapper.readValue(cssStringList, new TypeReference<List<String>>(){});
		webpageBuilder.buildWebpageCSSRuleSetListFrom(cssList, new ArrayList<String>());
		Webpage webpage = webpageBuilder.getWebpage();
		webpage.setCSSRuleSetList(webpageBuilder.buildWebpageCSSRuleSetListFrom(cssList, new ArrayList<String>()));
		List<CssRuleSet> returnedCSSRuleList = webpage.getCssRules().getCssRuleSetList();
		assertEquals(11, returnedCSSRuleList.size());
		assertEquals(".gallery", returnedCSSRuleList.get(0).getSelector());
		for (int i = 0; i < selectorList.length; i++) {
			assertEquals(selectorList[i].trim().replaceAll(" ", ""), returnedCSSRuleList.get(i).getSelector().toString());
		}
	}
	
	@Test
	public void findSubRulesSetFromParentSelector() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String cssStringList = "[\".gallery { height: 100px; background-color: rgb(204, 204, 204); }\",\".content { height: 200px; background-color: rgb(238, 238, 238); }\",\".sidebar { height: 200px; background-color: rgb(170, 170, 170); }\",\".middle { display: flex; flex-flow: row wrap; }\",\".middle.layout-1 .gallery { order: 1; width: 100%; }\",\".middle.layout-1 .content { order: 3; width: 75%; }\",\".middle.layout-1 .sidebar { order: 2; width: 25%; }\",\".middle.layout-2 { position: relative; }\",\".middle.layout-2 .gallery { width: 75%; margin-left: 25%; }\",\".middle.layout-2 .content { width: 75%; margin-left: 25%; }\",\".middle.layout-2 .sidebar { position: absolute; top: 0px; left: 0px; width: 25%; height: 100%; }\"]";
		List<String> cssList = mapper.readValue(cssStringList, new TypeReference<List<String>>(){});
		
		webpageBuilder.buildWebpageTagListFrom(testData.getWebsite1());
		Webpage webpage = webpageBuilder.getWebpage();
		webpage.setCSSRuleSetList(webpageBuilder.buildWebpageCSSRuleSetListFrom(cssList, new ArrayList<String>()));
		webpage.setTagPairList(webpageBuilder.buildWebpageTagPairListFrom(testData.getWebsite1()));
		
		CssRuleSet parent = webpage.getParentRuleSetOf("gallery");
		assertEquals(null, parent);
	}
	
	@Test
	public void findSubRulesSetFromParentSelector2() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String cssStringList = "["
				+ "\"* {box-sizing: border-box;}\","
				+ "\"body {font-family: Arial, Helvetica, sans-serif;}\","
				+ "\"/* Style the header */ header { background-color: #666; padding: 30px; text-align: center; font-size: 35px; color: white; } \","
				+ "\"/* Create two columns/boxes that floats next to each other */ nav { float: left; width: 30%; height: 300px; /* only for demonstration, should be removed */ background: #ccc;padding: 20px;}\","
				+ "\"/* Style the list inside the menu */nav ul {list-style-type: none;padding: 0;}\","
				+ "\"article {float: left;padding: 20px;width: 70%; background-color: #f1f1f1; height: 300px; /* only for demonstration, should be removed */}\","
				+ "\"section:after {content: ;display: table;clear: both;}\","
				+ "\"/* Style the footer */footer {background-color: #777;padding: 10px;text-align: center;color: white;}\","
				+ "\"/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */@media (max-width: 600px) {nav, article {width: 100%;height: auto;}}\"]";
		List<String> cssList = mapper.readValue(cssStringList, new TypeReference<List<String>>(){});
		
		webpageBuilder.buildWebpageTagListFrom(testData.getWebsite1());
		Webpage webpage = webpageBuilder.getWebpage();
		webpage.setCSSRuleSetList(webpageBuilder.buildWebpageCSSRuleSetListFrom(cssList, new ArrayList<String>()));
		webpage.setTagPairList(webpageBuilder.buildWebpageTagPairListFrom(testData.getWebsite1()));
		
		CssRuleSet parent = webpage.getParentRuleSetOf("ul");
		assertEquals(null, parent);
	}

}
