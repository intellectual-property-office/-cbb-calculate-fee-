package uk.gov.ipo.feecalculations.rules.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.ipo.feecalculations.rules.model.FeeItemComparator;
import uk.gov.ipo.feecalculations.rules.model.Rule;

import java.util.Collections;

@Service
public class RuleService {
    @Autowired
    private RuleDAO ruleDAO;

    public Rule getDetails(Rule rule){
        rule = ruleDAO.getDetails(rule);
        Collections.sort(rule.getFeeBreakdown(), new FeeItemComparator());
        return rule;
    }
}
