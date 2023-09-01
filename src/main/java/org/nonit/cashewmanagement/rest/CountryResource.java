package org.nonit.cashewmanagement.rest;

import org.nonit.cashewmanagement.service.CountryService;
import org.nonit.cashewmanagement.service.model.Country;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;
import org.nonit.cashewmanagement.utils.exception.ResourceNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/countries")
public class CountryResource {

  @Inject
  private CountryService countryService;
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public Response getCountryList(){
    return Response.ok(countryService.getCountryList()).build();
  }

  @POST
  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  public Response create(Country country) throws InputValidationException, ResourceNotFoundException {
    Country createdCountry = countryService.create(country);
    return Response.created(URI.create("countries/" + createdCountry.getId())).entity(createdCountry).status(Response.Status.CREATED).build();
  }
  }
