package hello.bean;

import java.io.Serializable;

/**
 * Created by elvis on 11/05/16.
 */
public class MoneyTransaction implements Serializable {

	private String sender;
	private String receiver;
	private double transferValue;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public double getTransferValue() {
		return transferValue;
	}

	public void setTransferValue(double transferValue) {
		this.transferValue = transferValue;
	}
}
