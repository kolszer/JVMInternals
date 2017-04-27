package services;

import java.util.List;
import java.util.stream.Collectors;

import entities.Customer;
import entities.Product;

public class CustomerService implements CustomerServiceInterface {

	private List<Customer> customers;

	public CustomerService(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public List<Customer> findByName(String name) {
		return customers.stream().filter(c -> c.getName().equals(name)).collect(Collectors.toList());
	}
	@Override
	public List<Customer> findByField(String fieldName, Object value) {
		List<Customer> listCust = customers.stream().filter(c->
		{
			if(c.getId()==(int)value && fieldName=="id")
				return true;
			if(c.getName().equals(value) && fieldName=="name")
				return true;
			if(c.getEmail().equals(value) && fieldName=="email")
				return true;
			if(c.getPhoneNo().equals(value) && fieldName=="phoneNo")
				return true;
			if(c.getTaxId().equals(value) && fieldName=="taxId")
				return true;
			if(c.getBoughtProducts().equals(value) && fieldName=="boughtProducts")
				return true;
			return false;
		}).collect(Collectors.toList());
		return listCust;
	}
	@Override
	public List<Customer> customersWhoBoughtMoreThan(int number) {
		return customers.stream().filter(c -> c.getBoughtProducts().size()>number).collect(Collectors.toList());
	}
	@Override
	public List<Customer> customersWhoSpentMoreThan(double price) 	{
		return customers.stream().filter( c ->
		{
			List<Product> prodList = c.getBoughtProducts().stream().collect(Collectors.toList());
			List<Double> sumList = prodList.stream().map(Product::getPrice).collect(Collectors.toList());
			double sum = sumList.stream().mapToDouble(i->i.doubleValue()).sum();
			return price<sum;
		}).collect(Collectors.toList());
	}
	@Override
	public List<Customer> customersWithNoOrders() {
		return customers.stream().filter(c -> c.getBoughtProducts().size()==0).collect(Collectors.toList());
	}
	@Override
	public void addProductToAllCustomers(Product p) {
		// TODO Auto-generated method stub

	}
	@Override
	public double avgOrders(boolean includeEmpty) {
		List<Product> prodList = customers.stream().flatMap(c->c.getBoughtProducts().stream()).collect(Collectors.toList());
		List<Double> sumList = prodList.stream().map(Product::getPrice).collect(Collectors.toList());
		return sumList.stream().mapToDouble(i->i.doubleValue()).sum()/customers.size();
	}
	@Override
	public boolean wasProductBought(Product p) {
		return customers.stream().filter(c->{
			List<Product> prList = c.getBoughtProducts().stream().filter(z->z.equals(p)).collect(Collectors.toList());
			return prList.size()>0;
		}).collect(Collectors.toList()).size() > 0;
	}
	@Override
	public List<Product> mostPopularProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countBuys(Product p) {
		List<Product> prodList = customers.stream().flatMap(c->c.getBoughtProducts().stream()).collect(Collectors.toList());
		prodList = prodList.stream().filter(pp->pp.equals(p)).collect(Collectors.toList());
		return prodList.size();
	}
	@Override
	public int countCustomersWhoBought(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
