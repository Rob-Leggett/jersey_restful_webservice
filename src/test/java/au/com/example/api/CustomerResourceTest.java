package au.com.example.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import jakarta.inject.Singleton;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import au.com.example.api.data.Customer;
import au.com.example.service.CustomerService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerResourceTest extends JerseyTest {

	private static CustomerService serviceMock = Mockito.mock(CustomerService.class);

	@Override
	protected Application configure() {
		forceSet(TestProperties.CONTAINER_PORT, "0");
		
		ResourceConfig config = new ResourceConfig(CustomerResource.class);
		config.register(new InjectableProvider());

		return config;
	}

	@BeforeAll
	public void setUpTest() throws Exception {
		super.setUp();
	}

	@AfterAll
	public void tearDownTest() throws Exception {
		super.tearDown();
	}

	@BeforeEach
	public void resetMocks() {
		Mockito.reset(serviceMock);
	}

	/**
	 * Invoke the retrieve customer and check the http response is 200.
	 */
	@Test
	public void testCustomerRetrieveResponse() {
		
		when(serviceMock.retrieve(Mockito.anyLong())).thenReturn(getMockCustomer());

		Response response = target("customer/retrieve/1").request().get();

		Customer customer = response.readEntity(Customer.class);
		
		assertEquals(200, response.getStatus());
		assertEquals("1", customer.getId().toString());
		assertEquals("Robert", customer.getFirstName());
		assertEquals("Leggett", customer.getLastName());
	}

    /**
     * Invoke the delete customer and check the http response is 200.
     */
    @Test
    public void testCustomerDeleteResponse() {

        doNothing().when(serviceMock).delete(Mockito.anyLong());

        Response response = target("customer/1").request().delete();

        assertEquals(200, response.getStatus());
        assertEquals("customer has been successfully deleted", response.readEntity(String.class));
    }
	
	/**
	 * Invoke the save customer and check the http response is 200.
	 */
	@Test
	public void testCustomerSaveResponse() {
		
	    Entity<Customer> customer = Entity.entity(getMockCustomer(), MediaType.APPLICATION_JSON_TYPE);
	    
		doNothing().when(serviceMock).save(Mockito.any(Customer.class));

		Response response = target("customer/save").request().post(customer);

		assertEquals(200, response.getStatus());
		assertEquals("customer has been successfully saved", response.readEntity(String.class));
	}

	// ======= Mocking ==========
	
	/**
	 * Mock object that will be returned
	 * 
	 * @return the customer object
	 */
	private Customer getMockCustomer() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setFirstName("Robert");
		customer.setLastName("Leggett");
		
		return customer;
	}

	/**
	 * Create an Injectable Provider that binds this factory to the customer service.
	 * When provide is invoked a mock service object will be returned.
	 */
	static class InjectableProvider extends AbstractBinder implements Factory<CustomerService> {
		
		@Override
		protected void configure() {
			bindFactory(this).to(CustomerService.class).in(Singleton.class);
		}

		public CustomerService provide() {
			return serviceMock;
		}

		public void dispose(CustomerService service) {
			// no-op
		}
	}
}
