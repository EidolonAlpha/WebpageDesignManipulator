package jonathanHughes.htmlReader.webpage.components.html.util;

public class CommentRemover {
	
	private final String multilineCommentPatternString = "\\/\\*(.+\\s)\\*\\/";
	private final String commentTagPatternString = "<!--.+[^>]-->";
	private final String commentLinePatternString = "//.*";
	
	public String removeCommentsFromHTML(String html) {
		String commentlessHTML = removeCommentTags(html);
		commentlessHTML = removeMultiLineComments(commentlessHTML);
		commentlessHTML = removeCommentLine(commentlessHTML);
		return commentlessHTML;
	}
	
	private String removeMultiLineComments(String html) {
		return html.replaceAll(multilineCommentPatternString, "");
	}
	
	private String removeCommentTags(String html) {
		return html.replaceAll(commentTagPatternString, "");
	}
	
	private String removeCommentLine(String html) {
		return html.replaceAll(commentLinePatternString, "");
	}

}
