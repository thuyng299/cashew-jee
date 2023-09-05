package org.nonit.cashewmanagement.rest;

import org.nonit.cashewmanagement.service.ProductService;
import org.nonit.cashewmanagement.service.model.Product;
import org.nonit.cashewmanagement.service.model.Supplier;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.exception.ResourceNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/products")
public class ProductResource {

    @Inject
    private ProductService productService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getProductList(){
        return Response.ok(productService.getProductList()).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Product product) throws InputValidationException, ResourceNotFoundException {
        Product createdProduct = productService.create(product);
        return Response.created(URI.create("products/" + createdProduct.getId())).entity(createdProduct).build();
    }
}
