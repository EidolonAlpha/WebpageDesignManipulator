package jonathanHughes.htmlReader.webpage.components.css;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jonathanHughes.htmlReader.webpage.components.css.ruleset.selector.CssSelectorExtractor;

@RestController
public class CssController {
	
	private CssSelectorExtractor cssSelectorExtractor = new CssSelectorExtractor();
	
	@RequestMapping(value = "css/extract/selector")
	public ResponseEntity<Object> extractCssSelector(@RequestBody String ruleSetString) {
		String selector = cssSelectorExtractor.extract(ruleSetString);
		return new ResponseEntity<>(selector, HttpStatus.OK);
	}

}
