package hello.rest;

import hello.bean.MoneyTransaction;
import hello.jms.MoneyTransferProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by elvis on 11/05/16.
 */
@RestController
public class MoneyTransferRest {

	@Autowired
	private MoneyTransferProducer moneyTransferProducer;

	@RequestMapping(value = "/user/{name}/transfer", method = RequestMethod.POST)
	public @ResponseBody void doTransfer(final @RequestBody MoneyTransaction moneyTransaction,
			 final @PathVariable("name") String senderName){

		moneyTransaction.setSender(senderName);
		moneyTransferProducer.doTransfer(moneyTransaction);

	}
}
