package springapp.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import springapp.service.SimpleProductManager;

public class InventoryControllelrTests {

	@Test
	public void testHandleRequestView() throws Exception{
		InventoryController controller = new InventoryController();
		controller.setProductManager(new SimpleProductManager());
		
		ModelAndView modelAndView = controller.handleRequest(null, null);
		
		assertEquals("inventory", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		
		Map modelMap = (Map) modelAndView.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		
		assertNotNull(nowValue);
	}
}
