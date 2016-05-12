package hello;

import javax.jms.ConnectionFactory;
import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.FileSystemUtils;

@SpringBootApplication
@EnableScheduling
@EnableJms
@ComponentScan
public class Application {

	// Strictly speaking this bean is not necessary as boot creates a default
	@Bean
	JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
		SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		return factory;
	}

	public static void main(String[] args) {
		// Clean out any ActiveMQ data from a previous run
		FileSystemUtils.deleteRecursively(new File("activemq-data"));
		SpringApplication.run(Application.class, args);
		System.out.println("system is up!!");
	}

}