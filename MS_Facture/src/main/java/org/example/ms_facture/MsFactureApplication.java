package org.example.ms_facture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class MsFactureApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFactureApplication.class, args);
	}


}
