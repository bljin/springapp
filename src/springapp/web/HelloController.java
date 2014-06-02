package springapp.web;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController  implements Controller  {
	protected final Log logger = LogFactory.getLog(getClass());
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
		throws ServletException, IOException {
		String now = (new Date()).toString();
		logger.info("Return Hello View" + now);
		return new ModelAndView("WEB-INF/jsp/hello.jsp", "now", now);
	}
}
