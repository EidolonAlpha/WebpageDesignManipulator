//package jonathanHughes.htmlReader.layout;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import jonathanHughes.htmlReader.layout.model.ElementLayout;
//import jonathanHughes.htmlReader.manipulation.layout.LayoutManipulator;
//
//public class LayoutManipulatorTest {
//	
//	LayoutManipulator layoutManipulator;
//	private ObjectMapper mapper = new ObjectMapper();
//		
//	@Test
//	public void positionElementsTest() throws JsonMappingException, JsonProcessingException {
//		List<WebpageElement> siblingList = new ArrayList<WebpageElement>();
//		String values = "[\"cssPath:   .middle.layout-1 .gallery, width : 100.00%, height : 33.33%\",\"cssPath:   .middle.layout-1 .content.content-edited, width : 50.00%, height : 66.67%\",\"cssPath:   .middle.layout-1 .sidebar, width : 25.00%, height : 66.67%\"]\r\n" + 
//				"";
//		List<String> cssList = mapper.readValue(values, new TypeReference<List<String>>(){});
//		for (String css : cssList) {
//			ElementSize elementSize = new ElementSize(css);
//			WebpageElement element = new WebpageElement(elementSize.getCssPath(), elementSize);
//			siblingList.add(element);
//		}
//		ElementLayout layout = new LayoutManipulator(new ElementLayout(siblingList)).getLayout();
//		assertEquals(2, layout.getElememtRows().size());
//		assertEquals(1, layout.getElememtRows().get(0).getElementsInRow().size());
//		assertEquals(2, layout.getElememtRows().get(1).getElementsInRow().size());
//		System.out.println(layout);
//	}
//	
//	@Test
//	public void lengthenElementsTest() throws JsonMappingException, JsonProcessingException {
//		List<WebpageElement> siblingList = new ArrayList<WebpageElement>();
//		String values = "[\"cssPath:   .middle.layout-1 .gallery, width : 100.00%, height : 33.33%\",\"cssPath:   .middle.layout-1 .content.content-edited, width : 50.00%, height : 66.67%\",\"cssPath:   .middle.layout-1 .sidebar, width : 50.00%, height : 66.67%\"]\r\n" + 
//				"";
//		List<String> cssList = mapper.readValue(values, new TypeReference<List<String>>(){});
//		for (String css : cssList) {
//			ElementSize elementSize = new ElementSize(css);
//			WebpageElement element = new WebpageElement(elementSize.getCssPath(), elementSize);
//			siblingList.add(element);
//		}
//		layoutManipulator = new LayoutManipulator(new ElementLayout(siblingList));
//		ElementLayout layout = layoutManipulator.getLayout();
//		layoutManipulator.resizeElementsByClass(".middle.layout-1 .content.content-edited", 75);
//		layout = layoutManipulator.getLayout();
//		assertEquals(100, layout.getElememtRows().get(0).getElementsInRow().get(0).getSize().getWidth());
//		assertEquals(75, layout.getElememtRows().get(1).getElementsInRow().get(0).getSize().getWidth());
//		assertEquals(25, layout.getElememtRows().get(1).getElementsInRow().get(1).getSize().getWidth());
//		System.out.println(layout);
//	}
//	
//	@Test
//	public void shortenElementsTest() throws JsonMappingException, JsonProcessingException {
//		List<WebpageElement> siblingList = new ArrayList<WebpageElement>();
//		String values = "[\"cssPath:   .middle.layout-1 .gallery, width : 100.00%, height : 33.33%\",\"cssPath:   .middle.layout-1 .content.content-edited, width : 50.00%, height : 66.67%\",\"cssPath:   .middle.layout-1 .sidebar, width : 50.00%, height : 66.67%\"]\r\n" + 
//				"";
//		List<String> cssList = mapper.readValue(values, new TypeReference<List<String>>(){});
//		for (String css : cssList) {
//			ElementSize elementSize = new ElementSize(css);
//			WebpageElement element = new WebpageElement(elementSize.getCssPath(), elementSize);
//			siblingList.add(element);
//		}
//		layoutManipulator = new LayoutManipulator(new ElementLayout(siblingList));
//		ElementLayout layout = layoutManipulator.getLayout();
//		layoutManipulator.resizeElementsByClass(".middle.layout-1 .content.content-edited", 40);
//		layout = layoutManipulator.getLayout();
//		assertEquals(100, layout.getElememtRows().get(0).getElementsInRow().get(0).getSize().getWidth());
//		assertEquals(40, layout.getElememtRows().get(1).getElementsInRow().get(0).getSize().getWidth());
//		assertEquals(60, layout.getElememtRows().get(1).getElementsInRow().get(1).getSize().getWidth());
//		System.out.println(layout);
//	}
//	
//	@Test
//	public void maxWidthElementsTest() throws JsonMappingException, JsonProcessingException {
//		List<WebpageElement> siblingList = new ArrayList<WebpageElement>();
//		String values = "[\"cssPath:   .middle.layout-1 .gallery, width : 100.00%, height : 33.33%\",\"cssPath:   .middle.layout-1 .content.content-edited, width : 50.00%, height : 66.67%\",\"cssPath:   .middle.layout-1 .sidebar, width : 50.00%, height : 66.67%\"]\r\n" + 
//				"";
//		List<String> cssList = mapper.readValue(values, new TypeReference<List<String>>(){});
//		for (String css : cssList) {
//			ElementSize elementSize = new ElementSize(css);
//			WebpageElement element = new WebpageElement(elementSize.getCssPath(), elementSize);
//			siblingList.add(element);
//		}
//		layoutManipulator = new LayoutManipulator(new ElementLayout(siblingList));
//		ElementLayout layout = layoutManipulator.getLayout();
//		layoutManipulator.resizeElementsByClass(".middle.layout-1 .content.content-edited", 100);
//		layout = layoutManipulator.getLayout();
//		assertEquals(100, layout.getElememtRows().get(0).getElementsInRow().get(0).getSize().getWidth());
//		assertEquals(1, layout.getElememtRows().get(1).getElementsInRow().size());
//		assertEquals(100, layout.getElememtRows().get(1).getElementsInRow().get(0).getSize().getWidth());
//		assertEquals(50, layout.getElememtRows().get(2).getElementsInRow().get(0).getSize().getWidth());
//		//assertEquals(0, layout.getElememtRows().get(1).getElementsInRow().get(1).getSize().getWidth());
//		//ToDO push to new row
//		System.out.println(layout);
//	}
//
//}
