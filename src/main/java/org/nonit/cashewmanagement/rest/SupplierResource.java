package org.nonit.cashewmanagement.rest;

import org.nonit.cashewmanagement.service.SupplierService;
import org.nonit.cashewmanagement.service.model.Supplier;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.exception.ResourceNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/suppliers")
public class SupplierResource {

    @Inject
    private SupplierService supplierService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getActiveList(){
        return Response.ok(supplierService.getActiveList()).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Supplier supplier) throws InputValidationException, ResourceNotFoundException{
        Supplier createdSupplier = supplierService.create(supplier);
        return Response.created(URI.create("suppliers/" + createdSupplier.getId())).entity(createdSupplier).build();
    }

}
