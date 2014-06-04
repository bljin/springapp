package spring.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRunner {

    final static Log logger = LogFactory.getLog(MessageRunner.class);
    
    /**
     * Main method.
     */
    public static void main(String[] args) {
        logger.info("Initializing Spring context.");
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
        
        logger.info("Spring context initialized.");

        Message message = (Message) applicationContext.getBean("message");

        logger.info("message='" + message.getMessage() + "'");
    }

}