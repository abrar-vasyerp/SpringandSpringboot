package com.abrar.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

        ConfigurableApplicationContext context=SpringApplication.run(DemoApplication.class, args);
        BillingService b1=context.getBean(BillingService.class);
        BillingService b2=context.getBean(BillingService.class);

        b1.billWithGST();
        b2.billWithIGST();

        System.out.println("hashcode: "+b1.hashCode());
        System.out.println("hashcode: "+b2.hashCode());



	}

}
