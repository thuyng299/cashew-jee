package org.nonit.cashewmanagement.rest;

import org.nonit.cashewmanagement.service.IncomingDetailService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/incomings")
public class IncomingDetailResource {

    @Inject
    private IncomingDetailService incomingDetailService;

    @GET
    @Path("/total-stock-finished-good")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTotalStockAmountOfFinishedGood(){
        return Response.ok(incomingDetailService.getTotalStockAmountOfFinishedGood()).build();
    }

    @GET
    @Path("/total-product-cost")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTotalCostOfProduct(){
        return Response.ok(incomingDetailService.getTotalCostOfProduct()).build();
    }
}
