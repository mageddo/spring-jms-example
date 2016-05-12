package hello.jms;

import hello.bean.MoneyTransaction;
import hello.utils.ReceiversConstants;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by elvis on 11/05/16.
 */

@Component
public class MoneyTransferReceiver {

	@JmsListener(destination = ReceiversConstants.MONEY_TRANSFER_DESTINATION)
	public void doTransfer(final MoneyTransaction transaction) {
		System.out.println(
				String.format(
						"Transfering %.2f from %s to %s", transaction.getTransferValue(),
						transaction.getSender(), transaction.getReceiver()
				)
		);
	}
}
