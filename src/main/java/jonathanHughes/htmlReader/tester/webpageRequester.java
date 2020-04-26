//package jonathanHughes.htmlReader.tester;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import jonathanHughes.htmlReader.webpage.builder.WebpageBuilder;
//import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
//import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.attribute.model.TagAtribute;
//import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;
//import jonathanHughes.htmlReader.webpage.model.Webpage;
//
//@RestController
//public class webpageRequester {
//	
//	Webpage webpage = new  Webpage();
//	WebpageBuilder builder = new WebpageBuilder(webpage);
//	private String cssRuleSetFile;
//	
//	@RequestMapping(value = "/WebpageDataExtractionForTestAll")
//	public ResponseEntity<Object> getExtractedCssFromList(@RequestBody String urlList) throws IOException, InterruptedException {
//		Map<String, Boolean> results = new HashMap<String, Boolean>();
//		for (String url : urlList.split(",")) {
//			System.out.println("Checking " + url);
//			getCssFrom(url.trim());
//			results.put(url, (Boolean) getExtractedCssFrom(url).getBody());
//		}
//		return new ResponseEntity<>(results, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/WebpageDataExtractionForTestAllReturnCss")
//	public ResponseEntity<Object> doesCssExtractionWorkFromList(@RequestBody String urlList) throws IOException, InterruptedException {
//		Map<String, Boolean> results = new HashMap<String, Boolean>();
//		for (String url : urlList.split(",")) {
//			System.out.println("Checking " + url);
//			getCssFrom(url.trim());
//			results.put(url, !cssRuleSetFile.isEmpty());
//		}
//		return new ResponseEntity<>(results, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/WebpageDataExtractionForTestAllReturnHTML")
//	public ResponseEntity<Object> doesHTMLExtractionWorkFromList(@RequestBody String urlList) throws IOException, InterruptedException {
//		Map<String, Boolean> results = new HashMap<String, Boolean>();
//		for (String url : urlList.split(",")) {
//			System.out.println("Checking " + url);
//			String htmlFile = getHtmlFrom(url.trim());
//			results.put(url, !htmlFile.isEmpty());
//		}
//		return new ResponseEntity<>(results, HttpStatus.OK);
//	}
//	
//	
//	@RequestMapping(value = "/WebpageDataExtractionTest")
//	public ResponseEntity<Object> getExtractedCssFrom(@RequestBody String url) throws IOException, InterruptedException {
//		String html = getBodyFrom(url);
//		getCssFrom(url);
//		webpage.setTagPairList(builder.buildWebpageTagPairListFrom(html));
//        List<String> cssLinkList = new ArrayList<String>();
//        List<String> cssList = new ArrayList<String>();
//        for (Tag tag : builder.buildWebpageTagListFrom(html)) {
//        	 String link = getCssLinkFrom(tag);
//            if (!link.isEmpty()) {
//            	cssLinkList.add(link);
//    		}
//		}
//        for (TagPair tagPair : webpage.getHtmlTags().getFullTagList()) {
//            String htmlCss = getCssFrom(tagPair);
//            if (!htmlCss.isEmpty()) {
//				cssList.add(htmlCss);
//			}
//		}
//        webpage.setCSSRuleSetList(builder.buildWebpageCSSRuleSetListFrom(cssList, cssLinkList));
//        return new ResponseEntity<>(allCssRulesPresent(), HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/WebpageDataForTest")
//	public ResponseEntity<Object> getCssFrom(@RequestBody String url) throws IOException, InterruptedException {
//		String html = getBodyFrom(url);
//		webpage.setTagPairList(builder.buildWebpageTagPairListFrom(html));
//        List<String> cssLinkList = new ArrayList<String>();
//        List<String> cssList = new ArrayList<String>();
//        for (Tag tag : builder.buildWebpageTagListFrom(html)) {
//        	 String link = getCssLinkFrom(tag);
//            if (!link.isEmpty()) {
//            	if (link.startsWith("/")) {
//            		if (url.substring(8).contains("/")) {
//            			int endIndex = url.substring(8).indexOf("/");
//						link = url.substring(8,endIndex) + link;
//					}
//            		else {
//						link = url + link;
//					}
//				}
//            	cssLinkList.add(link);
//    		}
//		}
//        for (TagPair tagPair : webpage.getHtmlTags().getFullTagList()) {
//            String htmlCss = getCssFrom(tagPair);
//            if (!htmlCss.isEmpty()) {
//				cssList.add(htmlCss);
//			}
//		}
//        cssRuleSetFile = commentRemover(createCssRuleFrom(cssList, cssLinkList)).replaceAll(" ", "").replaceAll("\r", "").replaceAll("\n", "").replaceAll("\t", "");
//        
//        return new ResponseEntity<>(cssRuleSetFile, HttpStatus.OK);
//	}
//	
//	private boolean allCssRulesPresent() {
//		boolean allPresent = true;
//		for (String cssRule : webpage.getCssRules().getCssRuleSetListAsStringListNoMedia()) {
//			String test = cssRule.replaceAll(" ", "").replaceAll("\t", "");
//			String test2 = test.substring(0,  test.indexOf("}")-1);
//			if (!cssRuleSetFile.contains(test) && !cssRuleSetFile.contains(test2)) {
//				System.out.println(test);
//				allPresent = false;
//			}
//		}
//		return allPresent;
//	}
//	
//	private String commentRemover(String cssText) {
//		Pattern commentPattern = Pattern.compile("\\/\\*.+?\\*\\/");
//		Matcher commentMatcher = commentPattern.matcher(cssText);
//		return commentMatcher.replaceAll(" ");
//	}
//	
//	public String getBodyFrom(@RequestBody String url) throws IOException, InterruptedException {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .build();
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//		return response.body();
//	}
//	
//	private String getCssLinkFrom(Tag tag) {
//		String styleSheetLink = "";
//		TagAtribute tagRel = tag.getTagAttribute("rel");
//		if (tagRel != null) {
//			if (tagRel.getValue().equalsIgnoreCase("stylesheet")) {
//				styleSheetLink = tag.getTagAttribute("href").getValue();
//			}
//		}
//		return styleSheetLink;
//	}
//	
//	private String getCssFrom(TagPair tagPair) {
//		String css = "";
//		TagAtribute attributeType = tagPair.getStartTag().getTagAttribute("type");
//		if (attributeType != null) {
//			if (attributeType.getValue().equalsIgnoreCase("text/css")) {
//				css = tagPair.getContent().toString();
//			}
//		}
//		return css;
//	}
//	
//	public String getHtmlFrom(String url) throws IOException, InterruptedException {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .build();
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//        return response.body();
//	}
//	
//	private String createCssRuleFrom(List<String> cssStringList, List<String> extrnalCss) {
//		String cssRule = "";
//		for (String fileLink : extrnalCss) {
//			HttpEntity<String> requestEntity = new HttpEntity<String>("");
//			RestTemplate restTemplate = new RestTemplate();
//			try {
//				ResponseEntity<String> responseEntity = restTemplate.exchange(fileLink, HttpMethod.GET, requestEntity, String.class);
//				cssRule += responseEntity.getBody();
//			} catch (Exception e) {
//				
//			}
//		}
//		for (String rule : cssStringList) {
//			cssRule += rule;
//		}
//		return cssRule;
//	}
//
//}
