package com.hommy.administrator.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hommy.administrator.dao.impl.RulesOperation;
import com.hommy.administrator.dao.objects.Rules;

@Path("/admin")
public class AdministratorService {

	@GET
	@Path("/rules")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRules() throws JsonProcessingException {
		Rules rules = new RulesOperation().getAllRules();

		String allRules = rules.toJSON();

		return Response.status(200).entity(allRules).build();
	}
}
