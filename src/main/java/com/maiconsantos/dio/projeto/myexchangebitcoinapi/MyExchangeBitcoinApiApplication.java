package com.maiconsantos.dio.projeto.myexchangebitcoinapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MyExchangeBitcoinApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyExchangeBitcoinApiApplication.class, args);
	}
}
