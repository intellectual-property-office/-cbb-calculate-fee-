package uk.gov.ipo.feecalculations.rules.rule;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.ipo.feecalculations.rules.model.Rule;

@Component
public class RuleDAO {

    @Autowired
    private KieSession session;

    public Rule getDetails(Rule rule){


        session.insert(rule);
        session.fireAllRules();
        return rule;
    }
}
