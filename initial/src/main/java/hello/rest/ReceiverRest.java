package hello.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static hello.utils.ReceiversConstants.MAILBOX_DESTINATION;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 5/11/16 6:59 PM
 */
@Controller
public class ReceiverRest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    public String ping() {

        MessageCreator messageCreator = (session) -> {
            return session.createTextMessage("ping!");
        };
        System.out.println("Sending a new message.");
        jmsTemplate.send(MAILBOX_DESTINATION, messageCreator);
        return "ok";
    }
}
