package com.crm.crm;


import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crm.crm.clientopportunity.ClientOpportunity;
import com.crm.crm.clientopportunity.ClientOpportunityDaoService;


@SpringBootTest
class CrmApplicationTests {
	
	@Autowired
	ClientOpportunityDaoService cliOpp;
	
	@Test
	void whenContactResultTrue_CliOppClientIsTrue() {
		ClientOpportunity opportunity= cliOpp.findAllOpportunities().get(0);
		boolean isClient= opportunity.isClient();
		cliOpp.setOpportunityAsClient(opportunity.getIdClientOpp());
		
		assertNotEquals(isClient, opportunity.isClient());
	}

}
