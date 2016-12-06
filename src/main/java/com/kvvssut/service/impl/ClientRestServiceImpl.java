package com.kvvssut.service.impl;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.kvvssut.integration.dto.RestDemoRequestResource;
import com.kvvssut.integration.service.RestDemoIntgService;
import com.kvvssut.service.ClientRestService;

public class ClientRestServiceImpl implements ClientRestService {
	
	@Inject
	private RestDemoIntgService restDemoIntgService;
	
	private final static String PATH_RESTDEMO_APPLICATION = "/restapplication/kvvssut/rest/";
	private final static String HOST_PATH = "http://localhost:8080";

	@Override
	public Response doRestDemoCall(String userName,	RestDemoRequestResource restDemoRequestResource) {
		Object[] statuses = new Object[2];
		try {
			statuses = restDemoIntgService.callRestEasyDemoApplication(restDemoRequestResource, HOST_PATH + PATH_RESTDEMO_APPLICATION, userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status((Integer)statuses[0]).entity(statuses[1]).build();
	}
	
	public Response doRestDemoCall(String userName) {
		Object[] statuses = new Object[2];
		try {
			statuses = restDemoIntgService.callRestEasyDemoApplication(HOST_PATH + PATH_RESTDEMO_APPLICATION, userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status((Integer)statuses[0]).entity(statuses[1]).build();
	}

}
