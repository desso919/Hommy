package com.hommy.administrator.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/admin")
public class AdministratorService {

	@GET
	@Path("/name")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSurveys() {

		return Response.status(200).build();
	}
}
