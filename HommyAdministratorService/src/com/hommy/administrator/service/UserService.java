package com.hommy.administrator.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hommy.administrator.dao.impl.UsersOperation;
import com.hommy.administrator.dao.objects.User;
import com.hommy.utils.HommyUtil;

@Path("/users")
public class UserService {

	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@QueryParam("username") String username, @QueryParam("password") String password)
			throws JsonProcessingException {
		User user = new UsersOperation().getUser(username, password);

		if (user != null) {
			String result = user.toJSON();
			return Response.status(200).entity(result).build();
		} else {
			return Response.status(200).entity(HommyUtil.EMPTY_JSON).build();
		}
	}
}
