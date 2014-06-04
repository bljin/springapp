package spring.ioc;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/SetterMessageTest-context.xml"})
public class SetterMessageTest {

    final Log logger = LogFactory.getLog(SetterMessageTest.class);
    
    @Autowired
    private SetterMessage message = null;

    /**
     * Tests message.
     */
    @Test
    public void testMessage() {   
        assertNotNull("Constructor message instance is null.", message);
        
        String msg = message.getMessage();
        
        assertNotNull("Message is null.", msg);
        
        String expectedMessage = "Spring is fun.";
        
        assertEquals("Message should be '" + expectedMessage + "'.", expectedMessage, msg);

        logger.info("message='{}'"+ msg);
    }
    
}