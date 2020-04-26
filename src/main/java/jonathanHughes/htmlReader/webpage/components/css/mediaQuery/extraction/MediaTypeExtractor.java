package jonathanHughes.htmlReader.webpage.components.css.mediaQuery.extraction;

import jonathanHughes.htmlReader.webpage.components.css.mediaQuery.model.MediaType;
import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class MediaTypeExtractor implements IExtractor<String, MediaType>{

	@Override
	public MediaType extract(String mediaQuery) {
		boolean not = false;
		boolean only = false;
		boolean and = false;
		if (mediaQuery.indexOf("(") > -1) {
			String 	mediaTypeValue = mediaQuery.substring(0,mediaQuery.indexOf("(")).trim();
			if (mediaTypeValue.contains("not")) {
				//mediaTypeValue = mediaTypeValue.replace("not", "").trim();
				not = true;
			}
			if (mediaTypeValue.contains("only")) {
				//mediaTypeValue = mediaTypeValue.replace("only", "").trim();
				only = true;
			}
			if (mediaTypeValue.contains("and")) {
				//mediaTypeValue = mediaTypeValue.replace("and", "").trim();
				and = true;
			}
			if (mediaTypeValue.isEmpty()) {
				return new MediaType(not, only, and, "");
			}
			return new MediaType(not, only, and, mediaTypeValue);
		}
		return null;
	}

}
