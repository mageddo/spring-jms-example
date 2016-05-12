package hello.jms;

import static hello.utils.ReceiversConstants.MAILBOX_DESTINATION;

import java.util.Random;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PingReceiver {

	private static Integer ID = 0;

	/**
	 * When you receive a message, print it out, then shut down the application. Finally, clean up any ActiveMQ server
	 * stuff.
	 */
	@JmsListener(destination = MAILBOX_DESTINATION, containerFactory = "defaultFactory")
	public void receiveMessage(String message) {

		++ID;

		final int sleepTime = new Random().nextInt(1500);
		System.out.println(String.format("PingReceiver %d sleeping %d ms....", ID, sleepTime));
		try {
			Thread.sleep(sleepTime);
		} catch(InterruptedException e) {
		}
		System.out.println(ID + " back to work!");

		System.out.println("the receive read the ping message <" + message + ">");
	}
}