package jonathanHughes.htmlReader.webpage.components.css.mediaQuery.extraction;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jonathanHughes.htmlReader.webpage.components.css.mediaQuery.model.MediaFeatures;
import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class MediaFeaturesExtractor implements IExtractor<String, List<MediaFeatures>>{
	
	private final String featurePatternString = "[^(]+(?=\\))";
	private final Pattern featurePattern = Pattern.compile(featurePatternString);

	@Override
	public List<MediaFeatures> extract(String mediaFeaturesString) {
		Matcher matcher = featurePattern.matcher(mediaFeaturesString);
		List<MediaFeatures> featureList = new ArrayList<MediaFeatures>();
		while (matcher.find()) {
			String featureString = matcher.group();
			String[] featureStringArray = featureString.split(":");
			if (featureStringArray.length == 2) {
				featureList.add(new MediaFeatures(featureStringArray[0].trim(), featureStringArray[1].trim()));
			}
		}
		return featureList;
	}

}
