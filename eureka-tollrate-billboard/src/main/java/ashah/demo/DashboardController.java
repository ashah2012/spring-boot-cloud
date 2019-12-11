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
public class DashboardController {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getTollRateBackup")
	@RequestMapping("/dashboard")
	public String getTollRate(@RequestParam int stationId) {

		TollRate tollRate = restTemplate.getForObject("http://eureka-toll-service/tollrate/" + stationId,
				TollRate.class);
		return tollRate.getCurrentRate().toPlainString();
	}

	public String getTollRateBackup(@RequestParam int stationId) {

		System.out.println("Fallback method called::");
		return "1.00";
	}
}
