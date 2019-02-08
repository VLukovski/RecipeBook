package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.OwnerService;

@Path("/owner")
public class OwnersEndpoint {
	
	@Inject
	private OwnerService service;

	@Path("/getAllOwners")
	@GET
	@Produces({ "application/json" })
	public String getAllOwners() {
		return service.getAllOwners();
	}
	
	@Path("/cycleOwners/{owner}")
	@GET
	@Produces({ "application/json" })
	public int cycleOwners(@PathParam("owner") String owner) {
		return service.cycleOwners(owner);
	}
	
	@Path("/getAnOwner/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAnOwner(@PathParam("id") Long id) {
		return service.getAnOwner(id);
	}

	@Path("/createOwner")
	@POST
	@Produces({ "application/json" })
	public String addOwner(String owner) {
		return service.addOwner(owner);
	}

	@Path("/deleteOwner/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteOwner(@PathParam("id") Long id) {
		return service.deleteOwner(id);
	}

	public void setService(OwnerService service) {
		this.service = service;
	}

}
