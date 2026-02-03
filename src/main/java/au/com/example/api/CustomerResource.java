package au.com.example.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import au.com.example.api.data.Customer;
import au.com.example.service.CustomerService;

@Path(value = "customer")
public class CustomerResource {

	private final CustomerService customerService;

	@Inject
	public CustomerResource(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GET
	@Path(value = "retrieve/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("id") Long id) {
		return customerService.retrieve(id);
	}

    @DELETE
    @Path(value = "{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("id") Long id) {
        customerService.delete(id);

        return Response.status(Status.OK).entity("customer has been successfully deleted").type(MediaType.APPLICATION_JSON).build();
    }
	
	@POST
	@Path(value = "save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveCustomer(Customer customer) {
		customerService.save(customer);
		
		return Response.status(Status.OK).entity("customer has been successfully saved").type(MediaType.APPLICATION_JSON).build();
	}
}
