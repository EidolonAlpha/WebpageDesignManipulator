package jonathanHughes.htmlReader.webpage.components.css.mediaQuery.model;

public class MediaType {
	
	boolean not;
	boolean only;
	boolean and;
	String mediaTypeValue;
	
	public MediaType(boolean not, boolean only, boolean and, String mediaTypeValue) {
		this.not = not;
		this.only = only;
		this.and = and;
		this.mediaTypeValue = mediaTypeValue;
	}

	public boolean isNot() {
		return not;
	}

	public boolean isOnly() {
		return only;
	}

	public String getMediaTypeValue() {
		return mediaTypeValue;
	}
	
	@Override
	public String toString() {
		String type = "";
		if (not) {
			type += "not ";
		}
		if (only) {
			type += "only ";
		}
		type += mediaTypeValue;
		if (and) {
			type += " and ";
		}
		return type;
	}

}
