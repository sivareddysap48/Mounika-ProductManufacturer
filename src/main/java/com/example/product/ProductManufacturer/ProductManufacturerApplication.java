package com.example.product.ProductManufacturer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.example.product")
@EntityScan("com.example.product.model")
@EnableJpaRepositories("com.example.product.dao")
public class ProductManufacturerApplication {
	

	private final static Logger logger=LoggerFactory.getLogger(ProductManufacturerApplication.class); 
	
	public static void main(String[] args) {
		logger.info("******-WarehouseApplication-START");
		SpringApplication.run(ProductManufacturerApplication.class, args);
		logger.info("******-WarehouseApplication-END");
	}

}
