package ashah.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaTollServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaTollServiceApplication.class, args);
	}

}
