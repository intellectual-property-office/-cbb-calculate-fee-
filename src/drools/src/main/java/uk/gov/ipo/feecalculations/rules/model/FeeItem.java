package uk.gov.ipo.feecalculations.rules.model;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class FeeItem {
    @JsonIgnore
    private String id;

    private String name;
    private BigDecimal value;
    private String description;

    public FeeItem() {
    }

    public FeeItem(String id, String name, BigDecimal value, String description) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public FeeItem(String id, String name, BigDecimal value) {
        this(id, name, value, "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("value")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
