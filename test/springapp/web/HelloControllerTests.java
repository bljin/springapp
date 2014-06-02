package springapp.web;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import springapp.web.HelloController;



public class HelloControllerTests {
	@Test
	public void testHandleRequestView() throws Exception{		
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        //assertEquals("hello.jsp", modelAndView.getViewName());
        assertEquals("WEB-INF/jsp/hello.jsp", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("now");
        assertNotNull(nowValue);
    }
}
