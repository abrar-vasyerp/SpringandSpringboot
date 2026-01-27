package org.abrar.spinjparelationship;

import org.abrar.spinjparelationship.service.ProductService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpinJpaRelationshipApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context=SpringApplication.run(SpinJpaRelationshipApplication.class, args);
        ProductService productService=context.getBean(ProductService.class);
        productService.printTopSellingProductsLastNDays(7);

    }

}
