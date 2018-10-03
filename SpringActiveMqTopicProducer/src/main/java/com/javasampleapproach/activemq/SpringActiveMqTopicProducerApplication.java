package com.javasampleapproach.activemq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.activemq.jms.JmsPublisher;
import com.javasampleapproach.activemq.models.Company;
import com.javasampleapproach.activemq.models.Product;

@SpringBootApplication
public class SpringActiveMqTopicProducerApplication implements CommandLineRunner {

	@Autowired
	JmsPublisher publisher;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringActiveMqTopicProducerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		Product iphone10 = new Product("Iphone 10");
		Product iPadPro = new Product("IPadPro");
		
		List<Product> appleProducts = new ArrayList<Product>(Arrays.asList(iphone10, iPadPro));
		
		Company apple = new Company("Apple", appleProducts);
		
		iphone10.setCompany(apple);
		iPadPro.setCompany(apple);
		
		// send message to ActiveMQ
		publisher.send(apple);

	}
}
