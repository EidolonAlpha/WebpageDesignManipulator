package jonathanHughes.htmlReader.webpage.components.css.extraction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jonathanHughes.htmlReader.webpage.components.css.mediaQuery.extraction.CssMediaRuleExtractor;
import jonathanHughes.htmlReader.webpage.components.css.mediaQuery.model.MediaQuery;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.extraction.CssRuleSetExtractor;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class CssExtractor implements IExtractor<String, List<CssRuleSet>> {
	
	private final static Logger LOGGER = Logger.getLogger(CssExtractor.class.getName());
	
	private final Pattern cssPattern = Pattern.compile("[^\\}]+,?\\{.*?\\}\\}?");
	private CssRuleSetExtractor ruleSetExtractor = new CssRuleSetExtractor();
	private CssMediaRuleExtractor cssMediaExtractor = new CssMediaRuleExtractor();

	@Override
	public List<CssRuleSet> extract(String cssString) {
		List<CssRuleSet> cssRuleSetList = new ArrayList<CssRuleSet>();
		if (cssString == null) {
			return cssRuleSetList;
		}
		LOGGER.info("Extracting Css Ruleset from " + cssString);
		cssString = cssString.replaceAll(" ", "");
		CssRuleSet extractedRule;
		
		String[] cssList = reasignMediaRule(getCSSList(cssString));
		for (String cssRulesetText : cssList) {
			MediaQuery mediaRestrictionRule = null;	
			cssRulesetText = commentRemover(cssRulesetText).trim();
			if (cssRulesetText.startsWith("@")) {
				mediaRestrictionRule = cssMediaExtractor.extract(cssRulesetText);
				cssRulesetText = removeMediaRuleFromRulesetString(cssRulesetText,mediaRestrictionRule.toString());
			}
			extractedRule = ruleSetExtractor.extract(cssRulesetText.trim());
			if (mediaRestrictionRule != null ) {
				extractedRule.setMediaRestrictionRule(mediaRestrictionRule);
				LOGGER.info("Media Query assigned to Ruleset");
			}
			if (extractedRule.getSelector() != null) {
				cssRuleSetList.add(extractedRule);
				LOGGER.info("Extracted Ruleset added to list");
				System.out.println("");
			}
		}
		return cssRuleSetList;
	}
	
	private String[] getCSSList(String cssText){
		String text = cssText.replace("\n", "").replace("\r", "");
		Matcher cssMatcher = cssPattern.matcher(text);
		String[] foundCSS = cssMatcher.results().map(MatchResult::group).toArray(String[]::new);
		return foundCSS;
	}
	
	private String[] reasignMediaRule(String[] foundCSS) {
		boolean inMediaQuery = false;
		String mediaQuery = "";
		for (int i = 0; i < foundCSS.length; i++) {
			if (inMediaQuery) {
				foundCSS[i] = mediaQuery + " {" + foundCSS[i];
			}
			if (foundCSS[i].startsWith("@") && !inMediaQuery && !foundCSS[i].endsWith("}}")) {
				inMediaQuery = true;
				mediaQuery = cssMediaExtractor.extract(foundCSS[i]).toString();
				foundCSS[i] += "}";
			}
			else if (foundCSS[i].endsWith("}}")) {
				inMediaQuery = false;
				mediaQuery = "";
			}
		}
		return foundCSS;
	}
	
	private String removeMediaRuleFromRulesetString(String cssText, String mediaExtractionRuleText) {
		LOGGER.info("Detected Media query indicator");
		cssText = cssText.replaceAll(" ", "");
		String mediaExtractionRule = mediaExtractionRuleText.replaceAll(" ", "");
		cssText = cssText.replace(mediaExtractionRule, "").trim();
		if (cssText.endsWith("}}")) {
			return cssText.substring(1,cssText.lastIndexOf("}"));
		}
		else {
			return cssText.substring(1);
		}
		
	}
	
	//COMMENT REMOVER
	
	private String commentRemover(String cssText) {
		Pattern commentPattern = Pattern.compile("\\/\\*.+?\\*\\/");
		Matcher commentMatcher = commentPattern.matcher(cssText);
		return commentMatcher.replaceAll(" ");
	}
	
}
