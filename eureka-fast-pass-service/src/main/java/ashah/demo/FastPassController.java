/**
 * 
 */
package ashah.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AnirudhS
 *
 */
@RestController
public class FastPassController {

	
	List<FastPassCustomer> customers = new ArrayList<FastPassCustomer>();
	
	public FastPassController() {
		
		FastPassCustomer fc1 = new FastPassCustomer("1", "Erene", "985632147", new BigDecimal("500.65"));
		FastPassCustomer fc2 = new FastPassCustomer("2", "Erika", "8954231675", new BigDecimal("1500.65"));
		FastPassCustomer fc3 = new FastPassCustomer("3", "Joseph", "123456789", new BigDecimal("200.65"));
		
		
		customers.add(fc1);
		customers.add(fc2);
		customers.add(fc3);
		
	}
	
	@RequestMapping(path="/fastpass", params = {"fastpassid"})
	public FastPassCustomer getCustomerById(@RequestParam String fastpassid) {
		Predicate<FastPassCustomer> p = c -> c.getFastPassId().equals(fastpassid);
		FastPassCustomer customer = customers.stream().filter(p).findFirst().get();
		
		return customer;
		
		
	}
	
	@RequestMapping(path="/fastpass", params = {"fastpassPhone"})
	public FastPassCustomer getCustomerByPhone(@RequestParam String fastpassPhone) {
		Predicate<FastPassCustomer> p = c -> c.getFastPassPhone().equals(fastpassPhone);
		FastPassCustomer customer = customers.stream().filter(p).findFirst().get();
		
		return customer;
		
		
	}
	
}
