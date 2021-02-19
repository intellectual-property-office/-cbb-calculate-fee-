package uk.gov.ipo.feecalculations.rules.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.ipo.feecalculations.rules.model.API;
import uk.gov.ipo.feecalculations.rules.model.Rule;
import uk.gov.ipo.feecalculations.rules.rule.RuleService;

import java.util.List;

@Service
public class APIService {

    @Autowired
    RuleService ruleService;

    public API getFeeBreakdown(API api){
        List<Rule> rules = api.getFeeCalculation();

        for(Rule eachRule : rules){
            eachRule = ruleService.getDetails(eachRule);
        }

        return api;
    }
}
