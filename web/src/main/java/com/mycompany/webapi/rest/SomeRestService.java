package com.mycompany.webapi.rest;


import com.mycompany.webapi.model.ApiResponse;
import com.mycompany.webapi.model.Something;
import com.mycompany.webapi.model.dto.SomethingDTO;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Path("/something")
public class SomeRestService {

	private static final Logger logger = Logger.getLogger(SomeRestService.class.getName());

  @GET
  @Path("/")
  @PermitAll
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll(@DefaultValue("*") @QueryParam("filter") String filter) {

    logger.info("Start getAll");
    /*
     * TODO:
     * List<Something> somethingList = service.getAll(filter);
     */
    List<SomethingDTO> somethingList = new ArrayList<>();
    somethingList.add(new SomethingDTO(1, "anything1"));
    somethingList.add(new SomethingDTO(2, "anything2"));
    somethingList.add(new SomethingDTO(3, "anything3"));

    logger.info("End getAll");

    Response.Status status = Response.Status.OK;
    Response response = Response.status(status)
        .entity(new ApiResponse<>(status.getStatusCode(), status.toString(), somethingList))
        .type(MediaType.APPLICATION_JSON)
        .build();
    return response;
  }

	@GET
	@Path("/{id}")
  @PermitAll
  @Produces(MediaType.APPLICATION_JSON)
	public Response getSomething(@PathParam("id") final Integer id) {

    logger.info("Start getSomething");
    /*
     * TODO:
     * Something something = service.get(id);
     */
    Something something = new Something(id, "anything");

    logger.info("End getSomething");

    Response.Status status = Response.Status.OK;
    Response response = Response.status(status)
        .entity(new ApiResponse<>(status.getStatusCode(), status.toString(), something))
        .type(MediaType.APPLICATION_JSON)
        .build();
    return response;
	}

	@POST
	@Path("/")
  @PermitAll
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
	public Response createSomething(final Something something) {

    logger.info("Start createSomething");

    /*
     * TODO:
     * somethingCreated = service.create(something);
     */
    Something somethingCreated = something;
    somethingCreated.setId(1);
    somethingCreated.setName("anything");

    logger.info("End createSomething");

    Response.Status status = Response.Status.CREATED;
    Response response = Response.status(status)
        .entity(new ApiResponse<>(status.getStatusCode(), status.toString(), something))
        .type(MediaType.APPLICATION_JSON)
        .build();
    return response;
	}

	@PUT
	@Path("/{id}")
  @RolesAllowed({"user", "admin"})
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
	public Response updateSomething(@PathParam("id") final Integer id) {

    logger.info("Start updateSomething");

    /*
     * TODO:
     * something = service.update(something);
     */
    Something something = new Something(id, "anything");

    logger.info("End updateSomething");

    Response.Status status = Response.Status.ACCEPTED;
    Response response = Response.status(status)
        .entity(new ApiResponse<>(status.getStatusCode(), status.toString(), something))
        .type(MediaType.APPLICATION_JSON)
        .build();
    return response;
	}

	@DELETE
  @Path("/{id}")
  @RolesAllowed({"admin"})
  @Produces(MediaType.APPLICATION_JSON)
	public Response deleteSomething(@PathParam("id") final Integer id) {

    logger.info("Start deleteSomething");

    /*
     * TODO:
     * service.delete(id);
     */

    logger.info("End deleteSomething");

    Response.Status status = Response.Status.ACCEPTED;
    Response response = Response.status(status)
        .entity(new ApiResponse<>(status.getStatusCode(), status.toString(), id))
        .type(MediaType.APPLICATION_JSON)
        .build();
    return response;
	}
}
