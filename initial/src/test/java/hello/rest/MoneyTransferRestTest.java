package hello.rest;

import com.jayway.restassured.RestAssured;
import hello.Application;
import hello.bean.MoneyTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by elvis on 11/05/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class MoneyTransferRestTest {

	@Value("${local.server.port}")
	int port;

	@Test
	public void testDoTransfer() throws Exception {
		RestAssured.port = port;

		final MoneyTransaction transaction = new MoneyTransaction();
//		transaction.setSender("Elvis");
		transaction.setReceiver("Bruna");
		transaction.setTransferValue(85.90);

		RestAssured.given() //
				.pathParam("name", "Elvis")
				.body(transaction) //
				.when().post("/user/{name}/transfer") //
				.then().statusCode(200);
	}
}