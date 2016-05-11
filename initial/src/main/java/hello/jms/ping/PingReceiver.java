package hello.jms.ping;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static hello.utils.ReceiversConstants.MAILBOX_DESTINATION;

@Component
public class PingReceiver {

    /**
     * When you receive a message, print it out, then shut down the application. Finally, clean up any ActiveMQ server
     * stuff.
     */
    @JmsListener(destination = MAILBOX_DESTINATION, containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message) {
        System.out.println("the receive read the ping message <" + message + ">");
    }
}