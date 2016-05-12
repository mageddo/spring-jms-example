package hello.jms.ping;

import hello.bean.MoneyTransaction;
import hello.utils.ReceiversConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * Created by elvis on 11/05/16.
 */
@Component
public class MoneyTransferProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void doTransfer(final MoneyTransaction transaction){
		MessageCreator messageCreator = (session) -> {
			return session.createObjectMessage(transaction);
		};
		jmsTemplate.send(ReceiversConstants.MONEY_TRANSFER_DESTINATION, messageCreator);
	}
}
