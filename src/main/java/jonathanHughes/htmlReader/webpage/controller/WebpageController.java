package jonathanHughes.htmlReader.webpage.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jonathanHughes.htmlReader.webpage.controller.resetEntities.output.EditedCssReturnEntity;
import jonathanHughes.htmlReader.webpage.service.WebpageService;

@RestController
public class WebpageController {
	
	private final static Logger LOGGER = Logger.getLogger(WebpageController.class.getName());
	
	WebpageService webpageService = new WebpageService();
	private Semaphore webpageAccess = new Semaphore(1);
	
	@RequestMapping(value = "/HtmlExtraction")
	public ResponseEntity<Object> extractHtml(@RequestBody String htmlString) {
		LOGGER.info("Recieved Request for HTML extraction");
		webpageAccess.acquireUninterruptibly();
		boolean htmlExtraction = webpageService.extractHTML(htmlString);
		webpageAccess.release();
		return new ResponseEntity<>(htmlExtraction, HttpStatus.OK);
	}

	@RequestMapping(value = "/CSSRules")
	public ResponseEntity<Object> exractCSSRules(@RequestBody String cssString) throws IOException, InterruptedException {
		LOGGER.info("Recieved Request for CSS extraction");
		webpageAccess.acquireUninterruptibly();
		boolean cccExtraction = webpageService.extractCSS(cssString);
		webpageAccess.release();
		return new ResponseEntity<>(cccExtraction, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/SaveCssChanges")
	public ResponseEntity<Object> detectChangesInCssFrom(@RequestBody String cssString) throws JsonMappingException, JsonProcessingException {
		LOGGER.info("Recieved Request for CSS change detection");
		webpageAccess.acquireUninterruptibly();
		List<EditedCssReturnEntity> changedCssList = webpageService.saveCssChanges(cssString);
		webpageAccess.release();
		return new ResponseEntity<>(changedCssList, HttpStatus.OK);
	}

}
