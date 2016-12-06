package com.kvvssut.integration.service;

import com.kvvssut.integration.dto.RestDemoRequestResource;

public interface RestDemoIntgService {
	
	public Object [] callRestEasyDemoApplication(RestDemoRequestResource restDemoRequestResource, String callURL, String userName) throws Exception;

	public Object[] callRestEasyDemoApplication(String requestPath, String userName) throws Exception;

}
