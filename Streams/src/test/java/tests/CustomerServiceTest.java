package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import services.CustomerService;
import services.CustomerServiceFor;
import services.CustomerServiceInterface;
import entities.Customer;

public class CustomerServiceTest {

	@Test
	public void testFindByName() {
		int x = 50;
		List<Customer> testData = DataProducer.getTestData(x);
		CustomerServiceInterface cs = new CustomerService(testData);
		CustomerServiceFor csFor = new CustomerServiceFor(testData);
		List<Customer> res;
		List<Customer> resFor;
		
		for(int i=0;i<x;i++){
			res = cs.findByName("Customer: "+i);
			resFor = csFor.findByNameFor("Customer: "+i);
			assertEquals(res, resFor);
		}
		
		for(int i=0;i<x;i++){
			res = cs.customersWhoBoughtMoreThan(5);
			resFor = csFor.customersWhoBoughtMoreThanFor(5);
			assertEquals(res, resFor);
		}
		
		for(int i=0;i<x;i++){
			res = cs.customersWhoSpentMoreThan(5);
			resFor = csFor.customersWhoSpentMoreThanFor(5);
			assertEquals(res, resFor);
		}
		
		res = cs.customersWithNoOrders();
		resFor = csFor.customersWithNoOrdersFor();
		assertEquals(res, resFor);
		
		int t1 = (int)cs.avgOrders(false);
		int t2 = (int)csFor.avgOrdersFor(false);
		assertEquals(t1,t2);
		
		//assertEquals(cs.wasProductBought(testData.get(x-1).getBoughtProducts().get(1)), csFor.wasProductBoughtFor(testData.get(x-1).getBoughtProducts().get(1)));
		//assertEquals(cs.countBuys(testData.get(x-1).getBoughtProducts().get(1)), csFor.countBuysFor(testData.get(x-1).getBoughtProducts().get(1)));		
	}
	

}
