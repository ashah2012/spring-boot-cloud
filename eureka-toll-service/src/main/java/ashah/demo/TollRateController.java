package ashah.demo;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TollRateController {

	@RequestMapping("/tollrate/{stationId}")
	public TollRate getTollRate(@PathVariable int stationId) {
		
		TollRate tr;
		
		switch (stationId) {
		case 1:
			tr = new TollRate(stationId, new BigDecimal("0.55"), Instant.now().toString());
			break;

		case 2:
			tr = new TollRate(stationId, new BigDecimal("0.65"), Instant.now().toString());
			break;
			
		case 3:
			tr = new TollRate(stationId, new BigDecimal("0.75"), Instant.now().toString());
			break;	
			
		default:
			tr = new TollRate(stationId, new BigDecimal("1.00"), Instant.now().toString());
			break;
		}
		
		return tr;
	}
	
	
}
