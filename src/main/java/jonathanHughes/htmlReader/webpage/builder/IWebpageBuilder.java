package jonathanHughes.htmlReader.webpage.builder;

import java.util.List;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;
import jonathanHughes.htmlReader.webpage.model.Webpage;

public interface IWebpageBuilder {
	
	public List<Tag> buildWebpageTagListFrom(String html);
	
	public List<CssRuleSet> buildWebpageCSSRuleSetListFrom(List<String> cssString, List<String> extrnalCss);
	
	public Webpage getWebpage();

}
