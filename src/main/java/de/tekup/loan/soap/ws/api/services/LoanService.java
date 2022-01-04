package de.tekup.loan.soap.ws.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.loan.soap.ws.api.loaneligibility.CustomerRequest;
import de.tekup.loan.soap.ws.api.loaneligibility.WsResponse;

@Service
public class LoanService {
	
	public WsResponse checkEligibilty(CustomerRequest request) {
		
		WsResponse response = new WsResponse();
		
		List<String> criteriaMismatch = response.getCriteriaMismatch();
		
		if(!(request.getAge() >=30 && request.getAge() <= 50))
			criteriaMismatch.add("Customer age must be between 30 and 50.");
		if(!(request.getCibilScore()>500))
			criteriaMismatch.add("Customer cibilScore must be over 500.");
		if(!(request.getYearlyIncome()>=20000))
			criteriaMismatch.add("Customer yearly income must be over 20000");
		
		if(criteriaMismatch.size() == 0)
		{
			response.setIsEligible(true);
			response.setApprovedAmount((long) (((request.getCibilScore()*1.0)/1000.0)*request.getYearlyIncome()));
		}
		else {
			response.setIsEligible(false);
			response.setApprovedAmount(0);
		}
		
		
		return response;
	}

}
