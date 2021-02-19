package uk.gov.ipo.feecalculations.rules.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.ipo.feecalculations.rules.api.APIService;
import uk.gov.ipo.feecalculations.rules.model.API;

@RestController
public class RuleController {

	private static final Logger logger = LoggerFactory.getLogger(RuleController.class);

	@Autowired
	private APIService apiService;

	@PostMapping("/ipo/FeeCalculationRule")
	public API api(@RequestBody API api) {
		return apiService.getFeeBreakdown(api);
	}

}
