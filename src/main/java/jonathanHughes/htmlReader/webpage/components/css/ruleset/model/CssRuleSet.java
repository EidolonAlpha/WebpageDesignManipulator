package jonathanHughes.htmlReader.webpage.components.css.ruleset.model;

import java.util.List;
import java.util.Optional;

import jonathanHughes.htmlReader.webpage.components.css.mediaQuery.model.MediaQuery;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model.CssDeclaration;

public class CssRuleSet {
	
	private String selector;
	private List<CssDeclaration> cssDeclarationList;
	private Optional<MediaQuery> mediaRestrictionRule;
	
	public CssRuleSet(String selector, List<CssDeclaration> declarationList) {
		this.selector = selector;
		this.cssDeclarationList = declarationList;
		this.mediaRestrictionRule = Optional.empty();
	}
	
	public CssRuleSet(String selector, List<CssDeclaration> declarationList, MediaQuery mediaRestrictionRule) {
		this.selector = selector;
		this.cssDeclarationList = declarationList;
		this.mediaRestrictionRule = Optional.ofNullable(mediaRestrictionRule);
	}
	
	public void setSelector(String selector) {
		this.selector = selector;
	}

	public void setCssDeclarationList(List<CssDeclaration> cssDeclarationList) {
		this.cssDeclarationList = cssDeclarationList;
	}
	
	public String getFullSelector() {
		if (mediaRestrictionRule.isEmpty()) {
			return selector;
		}
		else {
			return mediaRestrictionRule.get().toString() + " " + selector;
		}
	}

	public String getSelector() {
		return selector;
	}

	public List<CssDeclaration> getCssDeclaration() {
		return cssDeclarationList;
	}
	
	public CssDeclaration getCssDelaration(String property) {
		for (CssDeclaration cssDeclaration : cssDeclarationList) {
			if (cssDeclaration.getProperty().equals(property)) {
				return cssDeclaration;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String css = "";
		if (!mediaRestrictionRule.isEmpty()) {
			css += mediaRestrictionRule.get().toString() + " { ";
		}
		
		css += selector + " { ";
		
		for (CssDeclaration cssDeclaration : cssDeclarationList) {
			if (!cssDeclaration.toString().equals(": ;")) {
				css += cssDeclaration.toString().trim() + " ";
			}
		}
		css = css.trim() + " }";
		
		if (!mediaRestrictionRule.isEmpty()) {
			css += " }";
		}
		
		return css;
	}
	
	public String toStringNoMedia() {
		String css = "";
		
		css += selector + " { ";
		
		for (CssDeclaration cssDeclaration : cssDeclarationList) {
			if (!cssDeclaration.toString().equals(": ;")) {
				css += cssDeclaration.toString().trim() + " ";
			}
		}
		css = css.trim() + " }";
		
		return css;
	}
	
	

	public Optional<MediaQuery> getMediaRestrictionRule() {
		return mediaRestrictionRule;
	}

	public void setMediaRestrictionRule(MediaQuery mediaRestrictionRule) {
		this.mediaRestrictionRule = Optional.of(mediaRestrictionRule);
	}
}
