package org.nonit.rest;

import org.nonit.service.RegionService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/regions")
public class RegionResource {
    @Inject
    private RegionService regionService;


}
