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
import com.hommy.administrator.dao.impl.DevicesOperation;
import com.hommy.administrator.dao.objects.Device;
import com.hommy.administrator.dao.objects.Devices;

@Path("/devices")
public class DeviceService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDevices() throws JsonProcessingException {
		Devices devices = new DevicesOperation().getAllDevice();

		String result = devices.toJSON();
		return Response.status(200).entity(result).build();

	}

	@Path("/device")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDevice(@QueryParam("name") String name) throws JsonProcessingException {
		Device device = null;

		if (name != null) {
			device = new DevicesOperation().getDevice(name);
		}

		if (device != null) {
			return Response.status(200).entity(device.toJSON()).build();
		} else {
			return Response.status(200)
					.entity(new OperationResult(Result.FAILED, "Could not find device with this name.").toJSON())
					.build();
		}
	}

	@Path("/remove")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeDevice(@QueryParam("id") int id) throws JsonProcessingException {
		boolean isRemovedSuccessfully = false;

		if (id > 0) {
			isRemovedSuccessfully = new DevicesOperation().removeDevice(id);
		}

		if (isRemovedSuccessfully) {
			return Response.status(200).entity(new OperationResult(Result.OK).toJSON()).build();
		} else {
			return Response.status(200)
					.entity(new OperationResult(Result.FAILED, "Could not find device with this id.").toJSON()).build();
		}
	}

	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addDevice(final String device) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		boolean isAddedSuccessfully = false;

		if (device != null) {
			Device newDevice = mapper.readValue(device, Device.class);
			isAddedSuccessfully = new DevicesOperation().addDevice(newDevice);
		}

		if (isAddedSuccessfully) {
			return Response.status(200).entity(new OperationResult(Result.OK).toJSON()).build();
		} else {
			return Response.status(200).entity(new OperationResult(Result.FAILED).toJSON()).build();
		}
	}
}
