package uk.gov.ipo.feecalculations.rules.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.ArrayList;

public class API {
    private List<Rule> feeCalculation;

    public API() {
        feeCalculation = new ArrayList<Rule>();
    }

    @JsonProperty("feeCalculation")
    public List<Rule> getFeeCalculation() {
        return feeCalculation;
    }

    public void setFeeCalculation(List<Rule> feeCalculation) {
        this.feeCalculation = feeCalculation;
    }
}
