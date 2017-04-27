package services;

import java.util.ArrayList;
import java.util.List;

import entities.Customer;
import entities.Product;

public class CustomerServiceFor {
	private List<Customer> cust;

	public CustomerServiceFor(List<Customer> customers) {
		this.cust = customers;
	}
	public List<Customer> findByNameFor(String name)
	{
		List<Customer> tmpList = new ArrayList<Customer>();
		for(Customer c : cust)
			if(c.getName().equals(name))
				tmpList.add(c);
		return tmpList;
	}
	public List<Customer> findByFieldFor(String fieldName, Object value)
	{
		List<Customer> tmpList = new ArrayList<Customer>();
		for(Customer c : cust){
			if(c.getId()==(int)value && fieldName=="id")
				tmpList.add(c);
			if(c.getName().equals(value) && fieldName=="name")
				tmpList.add(c);
			if(c.getEmail().equals(value) && fieldName=="email")
				tmpList.add(c);
			if(c.getPhoneNo().equals(value) && fieldName=="phoneNo")
				tmpList.add(c);
			if(c.getTaxId().equals(value) && fieldName=="taxId")
				tmpList.add(c);
			if(c.getBoughtProducts().equals(value) && fieldName=="boughtProducts")
				tmpList.add(c);
		}
		return tmpList;			
	}	
	public List<Customer> customersWhoBoughtMoreThanFor(int number) {
		List<Customer> tmpList = new ArrayList<Customer>();
		for(Customer c : cust)
			if(c.getBoughtProducts().size()>number)
				tmpList.add(c);
		return tmpList;
	}
	public List<Customer> customersWhoSpentMoreThanFor(double price) {
		List<Customer> tmpList = new ArrayList<Customer>();
		double priceSum;
		for(Customer c : cust)
		{
			priceSum = 0;
			for(Product p : c.getBoughtProducts())
				priceSum += p.getPrice();
			if(priceSum>price)
				tmpList.add(c);
		}
		return tmpList;
	}
	public List<Customer> customersWithNoOrdersFor() {
		List<Customer> tmpList = new ArrayList<Customer>();
		for(Customer c : cust)
			if(c.getBoughtProducts().size()==0)
				tmpList.add(c);
		return tmpList;
	}
	public double avgOrdersFor(boolean includeEmpty) {
		double priceSum=0;
		for(Customer c : cust){
			for(Product p : c.getBoughtProducts())
				priceSum += p.getPrice();			
		}
		return priceSum/cust.size();
	}
	public boolean wasProductBoughtFor(Product p)
	{
		for(Customer c : cust)
			for(Product pp : c.getBoughtProducts())
				if(pp.equals(p))
					return true;
		return false;
	}
	public int countBuysFor(Product p)
	{
		int countProd=0;
		for(Customer c: cust)
			for(Product pp : c.getBoughtProducts())
				if(pp.equals(p))
					countProd++;
		return countProd;
	}
}
