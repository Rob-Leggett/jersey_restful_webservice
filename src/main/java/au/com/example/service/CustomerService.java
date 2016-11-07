package au.com.example.service;

import au.com.example.api.data.Customer;

public interface CustomerService {

	public Customer retrieve(Long id);

    public void delete(Long id);
	
	public void save(Customer customer);
}
