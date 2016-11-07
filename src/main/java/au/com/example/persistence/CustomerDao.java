package au.com.example.persistence;

import au.com.example.entity.CustomerEntity;

public interface CustomerDao {
	
	public CustomerEntity retrieve(Long id);

    public void delete(Long id);
	
	public void save(CustomerEntity customer);
}
