package org.nonit.cashewmanagement.rest;

import org.nonit.cashewmanagement.service.RegionService;
import org.nonit.cashewmanagement.service.model.Region;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.exception.ResourceNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;


@Path("/regions")
public class RegionResource {
    @Inject
    private RegionService regionService;

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Region region) throws InputValidationException {
        Region createdRegion = regionService.create(region);
        return Response.created(URI.create("regions/" + createdRegion.getId())).entity(createdRegion).status(Response.Status.CREATED).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRegionList() {
        return Response.ok(regionService.getRegionList()).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") Long id) throws ResourceNotFoundException {
        regionService.delete(id);
        return Response.noContent().build();
    }
}
