package de.tekup.loan.soap.ws.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.loan.soap.ws.api.loaneligibility.CustomerRequest;
import de.tekup.loan.soap.ws.api.loaneligibility.WsResponse;
import de.tekup.loan.soap.ws.api.services.LoanService;

@Endpoint
public class LoanEligibilityEndpoint {
	
	private static final String NAME_SPACE=  "http://www.tekup.de/loan/soap/ws/api/loanEligibility";
	@Autowired
	private LoanService service;
	
	@PayloadRoot(namespace = NAME_SPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public WsResponse getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkEligibilty(request);
	}

}
