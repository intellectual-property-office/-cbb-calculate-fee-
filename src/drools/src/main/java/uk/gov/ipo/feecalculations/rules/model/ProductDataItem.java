package uk.gov.ipo.feecalculations.rules.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ProductDataItem {
    private String name;
    private Integer value;

    public ProductDataItem(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public ProductDataItem() {
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object dataItemObject) {
        ProductDataItem dataItem = (ProductDataItem) dataItemObject;
        return this.getName().equals(dataItem.getName()) && this.getValue().equals(dataItem.getValue());
    }
}
