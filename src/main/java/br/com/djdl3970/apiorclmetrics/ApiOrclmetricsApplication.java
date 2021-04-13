package br.com.djdl3970.apiorclmetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.djdl3970.apiorclmetrics")
@EntityScan(basePackages = "br.com.djdl3970.apiorclmetrics.models")
public class ApiOrclmetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiOrclmetricsApplication.class, args);
	}

}
