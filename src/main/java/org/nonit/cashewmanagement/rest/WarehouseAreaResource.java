package org.nonit.cashewmanagement.rest;

import org.nonit.cashewmanagement.service.WarehouseAreaService;
import org.nonit.cashewmanagement.service.model.WarehouseArea;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.exception.ResourceNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/areas")
public class WarehouseAreaResource {

    @Inject
    private WarehouseAreaService warehouseAreaService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAreaList(){
        return Response.ok(warehouseAreaService.getAreaList()).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(WarehouseArea warehouseArea) throws InputValidationException, ResourceNotFoundException {
        WarehouseArea createdArea = warehouseAreaService.create(warehouseArea);
        return Response.created(URI.create("areas/" + createdArea.getId())).entity(createdArea).build();
    }
}
