package com.kvvssut.rest;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.kvvssut.integration.dto.RestDemoRequestResource;
import com.kvvssut.service.ClientRestService;

@Path("client")
public class ClientTesterRest {
	
	private static final Logger logger = Logger.getLogger(ClientTesterRest.class);
	
	@Inject
	private ClientRestService clientRestService;
	
	@PUT
	@Path("/method/{param}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response method(@PathParam("param") String userName, RestDemoRequestResource restDemoRequestResource) {
	return	this.clientRestService.doRestDemoCall(userName, restDemoRequestResource);
	}
	
	@GET
	@Path("/method/{username}/{debit}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response method(@PathParam("username") String userName, @PathParam("debit") BigDecimal amount) {
		RestDemoRequestResource restDemoRequestResource = new RestDemoRequestResource();
		restDemoRequestResource.setAmount(amount);
		return	this.clientRestService.doRestDemoCall(userName, restDemoRequestResource);
	}
	
	@GET
	@Path("/method/{username}/balance")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBalanceByUsername(@PathParam("username") String userName) {
		logger.info("All Done!! Inside");
		return	this.clientRestService.doRestDemoCall(userName);
	}

}
