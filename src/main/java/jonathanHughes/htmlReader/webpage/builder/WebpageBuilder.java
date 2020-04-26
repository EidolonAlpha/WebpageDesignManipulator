package jonathanHughes.htmlReader.webpage.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import jonathanHughes.htmlReader.webpage.components.css.extraction.CssExtractor;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.extraction.TagPairExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.extraction.TagExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;
import jonathanHughes.htmlReader.webpage.model.Webpage;

public class WebpageBuilder {
	
	private final static Logger LOGGER = Logger.getLogger(WebpageBuilder.class.getName());
	
	private Webpage webpage;
	private CssExtractor cssExtractor = new CssExtractor();
	private TagPairExtractor tagPairExtractor = new TagPairExtractor();
	private TagExtractor tagExtractor = new TagExtractor();
	

	public WebpageBuilder(Webpage webpage) {
		this.webpage = webpage;
	}
	
	//Extract html tags from passed in string
	
	public List<TagPair> buildWebpageTagPairListFrom(String html) {
		//String commentlessHtml = commentRemover.removeCommentsFromHTML(html);
		LOGGER.info("Building Tag Pair list for webpage");
		List<TagPair> tagPairList = tagPairExtractor.extract(html.replace("\n", "").replace("\r",""));
		webpage.setTagPairList(tagPairList);
		if (webpage.getHtmlTags() == null) {
			LOGGER.warning("No TagList has been build for the webpage");
		}
		else {
			LOGGER.info("TagList has been build for the webpage");
		}
		return tagPairList;
	}
	
	public List<Tag> buildWebpageTagListFrom(String html) {
		return tagExtractor.extract(html.replace("\n", "").replace("\r",""));
	}

	//Extract css rules from passed in css strings
	
	public List<CssRuleSet> buildWebpageCSSRuleSetListFrom(List<String> cssStringList, List<String> extrnalCss) {
		List<CssRuleSet> extractedCSSRuleSet = new ArrayList<CssRuleSet>();
		for (String css : cssStringList) {
			List<CssRuleSet> currentCSS = cssExtractor.extract(css);
			if (currentCSS !=null) {
				extractedCSSRuleSet.addAll(currentCSS);
			}
		}
		extractedCSSRuleSet.addAll(getExternalCSSFromLink(extrnalCss));
		return extractedCSSRuleSet;
	}
	
	//Extract Css from external css files
	
	private List<CssRuleSet> extractCssFromFile(String fileLink) {
		LOGGER.info("Extracting CSS from external File " + fileLink);
		HttpEntity<String> requestEntity = new HttpEntity<String>("");
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(fileLink, HttpMethod.GET, requestEntity, String.class);
			return cssExtractor.extract(responseEntity.getBody());
		} catch (Exception e) {
			LOGGER.warning("No CSS retuened");
			return null;
		}
	}
	
	private List<CssRuleSet> getExternalCSSFromLink(List<String> externalCssList) {
		List<CssRuleSet> ruleSet = new ArrayList<CssRuleSet>();
		for (String link : externalCssList) {
			List<CssRuleSet> result = extractCssFromFile(link);
			if (result != null) {
				ruleSet.addAll(result);
			}
		}
		return ruleSet;
	}

	public Webpage getWebpage() {
		return this.webpage;
	}
	
}
