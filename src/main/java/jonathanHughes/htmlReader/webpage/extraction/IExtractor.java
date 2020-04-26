package jonathanHughes.htmlReader.webpage.extraction;

public interface IExtractor<DataToExract,Result> {
	
	public Result extract(DataToExract data);
	
	
}
