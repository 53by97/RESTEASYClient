package com.kvvssut.integration.service.impl;

import org.jboss.resteasy.client.ClientResponse;

import com.kvvssut.integration.client.BaseRestClient;
import com.kvvssut.integration.client.RestEasyDemoIntgClient;
import com.kvvssut.integration.dto.RestDemoRequestResource;
import com.kvvssut.integration.service.RestDemoIntgService;

public class RestDemoIntgServiceImpl extends BaseRestClient implements RestDemoIntgService {

	@Override
	public Object [] callRestEasyDemoApplication(RestDemoRequestResource restDemoRequestResource, String callURL, String param) throws Exception {
		RestEasyDemoIntgClient restEasyDemoIntgClient;
		ClientResponse<String> clientResponse = null;
		Object [] statuses = new Object[2];
		
		try {
			restEasyDemoIntgClient = getClient(RestEasyDemoIntgClient.class, callURL);
			clientResponse = restEasyDemoIntgClient.putToRestEasyDemo(restDemoRequestResource, param);
			if(clientResponse != null){
				statuses[0] = clientResponse.getStatus();
				statuses[1] = clientResponse.getEntity();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseConnection(clientResponse);
		}

		return statuses; 
	}
	
	@Override
	public Object[] callRestEasyDemoApplication(String requestPath, String userName) throws Exception {
		RestEasyDemoIntgClient restEasyDemoIntgClient;
		ClientResponse<String> clientResponse = null;
		Object [] statuses = new Object[2];
		
		try {
			restEasyDemoIntgClient = getClient(RestEasyDemoIntgClient.class, requestPath);
			clientResponse = restEasyDemoIntgClient.getBalanceFromRestEasyDemoByUsername(userName);
			if(clientResponse != null){
				statuses[0] = clientResponse.getStatus();
				statuses[1] = clientResponse.getEntity();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseConnection(clientResponse);
		}

		return statuses;
	}

}
