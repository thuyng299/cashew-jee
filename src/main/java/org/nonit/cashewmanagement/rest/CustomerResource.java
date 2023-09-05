package org.nonit.cashewmanagement.rest;

import org.nonit.cashewmanagement.service.CustomerService;
import org.nonit.cashewmanagement.service.model.Customer;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.exception.ResourceNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/customers")
public class CustomerResource {

    @Inject
    private CustomerService customerService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getActiveList(){
        return Response.ok(customerService.getActiveList()).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Customer customer) throws InputValidationException, ResourceNotFoundException {
        Customer createdCustomer = customerService.create(customer);
        return Response.created(URI.create("customers/" + createdCustomer.getId())).entity(createdCustomer).build();
    }


}
