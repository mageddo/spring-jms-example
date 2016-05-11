package hello.jms.ping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import static hello.utils.ReceiversConstants.MAILBOX_DESTINATION;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 5/11/16 7:50 PM
 */
@Component
public class PingProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void doPing() {
        final MessageCreator messageCreator = (session) -> {
            return session.createTextMessage("ping!");
        };
        System.out.println("Sending a new message.");
        jmsTemplate.send(MAILBOX_DESTINATION, messageCreator);
        System.out.println("message was sent");
    }

}
