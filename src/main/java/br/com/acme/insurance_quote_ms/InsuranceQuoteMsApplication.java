package br.com.acme.insurance_quote_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InsuranceQuoteMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceQuoteMsApplication.class, args);
	}
}
