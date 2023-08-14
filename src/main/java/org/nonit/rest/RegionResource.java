package org.nonit.rest;

import org.nonit.service.RegionService;
import org.nonit.service.model.Region;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;


@Path("regions")
public class RegionResource {
    @Inject
    private RegionService regionService;

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Region region) {
        Region createdRegion = regionService.create(region);
        return Response.created(URI.create("regions/" + createdRegion.getId())).entity(createdRegion).status(Response.Status.CREATED).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRegionList() {
        return Response.ok(regionService.getRegionList()).build();
    }
}
