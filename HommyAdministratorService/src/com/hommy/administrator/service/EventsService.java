package com.hommy.administrator.service;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hommy.administrator.dao.impl.EventsOperation;
import com.hommy.administrator.dao.objects.Event;
import com.hommy.administrator.dao.objects.Events;

@Path("/events")
public class EventsService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEvents() throws JsonProcessingException {
		Events events = new EventsOperation().getAllEvents();

		String result = events.toJSON();
		return Response.status(200).entity(result).build();

	}

	@Path("/event")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvent(@QueryParam("name") String name) throws JsonProcessingException {
		Event event = null;

		if (name != null) {
			event = new EventsOperation().getEvent(name);
		}

		if (event != null) {
			return Response.status(200).entity(event.toJSON()).build();
		} else {
			return Response.status(200)
					.entity(new OperationResult(Result.FAILED, "Could not find an event with this name").toJSON())
					.build();
		}
	}

	@Path("/remove")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeEvent(@QueryParam("id") int id) throws JsonProcessingException {
		boolean isRemovedSuccessfully = false;

		if (id > 0) {
			isRemovedSuccessfully = new EventsOperation().removeEvent(id);
		}

		if (isRemovedSuccessfully) {
			return Response.status(200).entity(new OperationResult(Result.OK).toJSON()).build();
		} else {
			return Response.status(200).entity(new OperationResult(Result.FAILED).toJSON()).build();
		}
	}

	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEvent(final String event) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		boolean isAddedSuccessfully = false;

		if (event != null) {
			Event newEvent = mapper.readValue(event, Event.class);
			isAddedSuccessfully = new EventsOperation().addEvent(newEvent);
		}

		if (isAddedSuccessfully) {
			return Response.status(200).entity(new OperationResult(Result.OK).toJSON()).build();
		} else {
			return Response.status(200).entity(new OperationResult(Result.FAILED).toJSON()).build();
		}
	}
}
