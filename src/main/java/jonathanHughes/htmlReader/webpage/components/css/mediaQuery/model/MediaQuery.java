package jonathanHughes.htmlReader.webpage.components.css.mediaQuery.model;

import java.util.List;

public class MediaQuery {
	
	MediaType type;
	List<MediaFeatures> features;
	
	public MediaQuery(MediaType type, List<MediaFeatures> features) {
		this.type = type;
		this.features = features;
	}
	
	@Override
	public String toString() {
		String query = "";
		if (type!= null) {
			query += type.toString() + " ";
		}
		for (MediaFeatures mediaFeatures : features) {
			query += mediaFeatures.toString();
		}
	
		return query.replaceAll("\\s+", " ");
	}
	
}
