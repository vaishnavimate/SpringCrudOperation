package com.CrudOperation.CrudOperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.CrudOperation.CrudOperation", "com.CrudOperation.CrudOperation.Product.Service", "com.CrudOperation.CrudOperation.Product.dao"})

//@SpringBootApplication
@ComponentScan("com.CrudOperation.CrudOperation.Product.Service")
@ComponentScan("com.CrudOperation.CrudOperation.Product.dao")
public class CrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationApplication.class, args);
		System.out.println("Applicatoin Started");
	}

}
