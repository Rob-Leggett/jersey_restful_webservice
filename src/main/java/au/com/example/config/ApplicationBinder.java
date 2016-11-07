package au.com.example.config;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import au.com.example.persistence.CustomerDao;
import au.com.example.persistence.CustomerDaoImpl;
import au.com.example.service.CustomerService;
import au.com.example.service.CustomerServiceImpl;

public class ApplicationBinder extends AbstractBinder {
	
    @Override
    protected void configure() {
    	// services
        bind(CustomerServiceImpl.class).to(CustomerService.class).in(Singleton.class);
        
        // dao
        bind(CustomerDaoImpl.class).to(CustomerDao.class).in(Singleton.class);
    }
}