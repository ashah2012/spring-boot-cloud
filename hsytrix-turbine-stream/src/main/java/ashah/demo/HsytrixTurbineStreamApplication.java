package ashah.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@EnableTurbineStream
@SpringBootApplication
public class HsytrixTurbineStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(HsytrixTurbineStreamApplication.class, args);
	}

}
