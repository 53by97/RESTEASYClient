package com.kvvssut.integration.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import com.kvvssut.integration.dto.RestDemoRequestResource;

@Path("")
public interface RestEasyDemoIntgClient {
	
	@PUT
	@Path("/method/{param}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse<String> putToRestEasyDemo(RestDemoRequestResource restDemoRequestResource, @PathParam("param") String userName);

	@GET
	@Path("/method/{param}/balance")
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse<String> getBalanceFromRestEasyDemoByUsername(@PathParam("param") String userName);
}
