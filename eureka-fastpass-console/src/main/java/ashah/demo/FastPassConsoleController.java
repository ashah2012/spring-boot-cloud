package ashah.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class FastPassConsoleController {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFastPassCustomerBackup")
	@RequestMapping("/customerdetails")
	public FastPassCustomer getFastPassCustomer(@RequestParam String fastpassid) {

		FastPassCustomer customer = restTemplate.getForObject(
				"http://eureka-fast-pass-service/fastpass?fastpassid=" + fastpassid, FastPassCustomer.class);
		return customer;
	}

	public FastPassCustomer getFastPassCustomerBackup(@RequestParam String fastpassid) {

		System.out.println("Fallback method called::");
		FastPassCustomer customer = new FastPassCustomer(fastpassid, "", "", null);
		return customer;
	}

}
