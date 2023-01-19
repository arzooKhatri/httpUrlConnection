package com.apiCall.apiCall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiCallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCallApplication.class, args);
        System.out.println("Api Call With HttpUrl Connection Running Successfully");
    }
}
