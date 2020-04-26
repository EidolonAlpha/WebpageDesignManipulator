package jonathanHughes.htmlReader.webpage.components.html.tagPair.extraction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jonathanHughes.htmlReader.webpage.components.html.tagPair.content.TagContent;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.content.extraction.TagContentExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.model.TagPair;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.extraction.TagExtractor;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.model.Tag;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.tag.util.TagPositionInString;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.util.ClosingTagIndexFinder;
import jonathanHughes.htmlReader.webpage.components.html.tagPair.util.TagPairIndexPairPosition;
import jonathanHughes.htmlReader.webpage.extraction.IExtractor;

public class TagPairExtractor implements IExtractor<String,  List<TagPair>>{
	
	private final static Logger LOGGER = Logger.getLogger(TagPairExtractor.class.getName());
	
	private TagExtractor tagListExtractor = new TagExtractor();
	private TagContentExtractor tagContentExtractor = new TagContentExtractor();
	private ClosingTagIndexFinder closingTagIndexFinder = new ClosingTagIndexFinder();
	private TagPositionInString tagPositionExtractor = new TagPositionInString();
	
	@Override
	public List<TagPair> extract(String htmlString) {
		LOGGER.info("Starting Tag Pair Extraction from " + htmlString);
		List<Tag> tagList = tagListExtractor.extract(htmlString);
		List<TagPairIndexPairPosition> tagPairIndexList = getTagPairIndexs(tagList);		
		List<String> sameLevelTagPairs = getSameLevelTagPairList(htmlString, tagList, tagPairIndexList);
		return getTagPairList(sameLevelTagPairs);
	}
	
	private TagPair extractTagPair(String htmlString, List<Tag> tagList, int startIndex, int endIndex) {
		List<TagContent> tagContentList = tagContentExtractor.extractTagContent(htmlString, tagList, startIndex, endIndex);
		List<TagPair> innerTagPair = new ArrayList<TagPair>();
		for (TagContent tagContent : tagContentList) {
			innerTagPair.addAll(extract(tagContent.getContentText()));
		}
		TagPair tagPair = new TagPair(tagList.get(startIndex), tagList.get(endIndex), tagContentList, innerTagPair);
		for (TagPair _innerTagPair : innerTagPair) {
			_innerTagPair.setParentTag(tagPair);
		}
		return tagPair;
	}
	
	private String seperateInnerTags(String html, int innerTagPosition, int outerTagPosition){
		return html.substring(innerTagPosition,outerTagPosition);
	}
	
	private boolean doesTagHasBrotherTags(int start, int end, int listSize) {
		if (start == 0 && end == listSize) {
			return false;
		}
		return true;
	}
	
	private List<String> getSameLevelTagPairList(String htmlString, List<Tag> tagList, List<TagPairIndexPairPosition> tagPairIndexList){
		List<String> sameLevelTagPairs = new ArrayList<String>();
		int lastTagPos = 0;
		for (TagPairIndexPairPosition tagPairIndexPos : tagPairIndexList) {
			int startIndex = tagPairIndexPos.getStartIndex();
			int endIndex = tagPairIndexPos.getEndIndex();
			int startTagPosition = tagPositionExtractor.getPositionOfTag(htmlString, tagList.get(startIndex), startIndex);
			int endTagPosition = tagPositionExtractor.getPositionOfTag(htmlString, tagList.get(endIndex), endIndex) + tagList.get(endIndex).getTagValue().length()+2;
			if (lastTagPos <= startTagPosition) {
				sameLevelTagPairs.add(seperateInnerTags(htmlString, startTagPosition, endTagPosition));
				lastTagPos = endTagPosition;
			}
		}
		return sameLevelTagPairs;
	}
			
	private List<TagPair> getTagPairList(List<String> sameLevelTagPairs) {
		List<TagPair> tagPairList = new ArrayList<TagPair>();
		for (String sameLevelTagPair : sameLevelTagPairs) {
			List<Tag> innerTagList = tagListExtractor.extract(sameLevelTagPair);
			int startIndex = 0;
			int endIndex = closingTagIndexFinder.getIndexOfMatchingEndTag(innerTagList, startIndex);
			if (endIndex != -1) {
				TagPair extractedPair = extractTagPair(sameLevelTagPair, innerTagList, startIndex, endIndex);
				tagPairList.add(extractedPair);
			}
		}
		return tagPairList;
	}
	
	private List<TagPairIndexPairPosition> getTagPairIndexs(List<Tag> tagList){
		List<TagPairIndexPairPosition> tagPairIndexPairList = new ArrayList<TagPairIndexPairPosition>();
		int i = 0;
		if (doesTagHasBrotherTags(0, closingTagIndexFinder.getIndexOfMatchingEndTag(tagList, 0), tagList.size() - 1)) {
			for (Tag tag : tagList) {
				if (!tag.isEndTag()) {
					int closingTagIndex = closingTagIndexFinder.getIndexOfMatchingEndTag(tagList, i);
					int endTagIndex;
					if (closingTagIndex != -1) {
						endTagIndex = closingTagIndex;
					}
					else {
						endTagIndex = i;
					}
					tagPairIndexPairList.add(new TagPairIndexPairPosition(i, endTagIndex));
				}
				i++;
			}
		}
		else if (tagList.size() > 0) {
			tagPairIndexPairList.add(new TagPairIndexPairPosition(0, tagList.size() - 1));
		}
		return tagPairIndexPairList;
	}
		
}
