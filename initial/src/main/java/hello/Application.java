package hello;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	// Strictly speaking this bean is not necessary as boot creates a default
	@Bean
	JmsListenerContainerFactory<?> defaultFactory(final ActiveMQConnectionFactory connectionFactory, final Environment environment) {
		final String trustedPackagesString = environment.getProperty("org.apache.activemq.SERIALIZABLE_PACKAGES");
		final SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		connectionFactory.setTrustedPackages(new ArrayList<>(Arrays.asList(
			trustedPackagesString.split(",")
		)));
		LOGGER.warn("trustedPackages={}", trustedPackagesString);
		return factory;
	}

	public static void main(String[] args) {
		// Clean out any ActiveMQ data from a previous run
		FileSystemUtils.deleteRecursively(new File("activemq-data"));
		SpringApplication.run(Application.class, args);
		System.out.println("system is up!!");
	}

}