package uk.gov.ipo.feecalculations.rules.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductVariant {
    private String name;

    public ProductVariant(String name) {
        this.name = name;
    }

    public ProductVariant() {
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object variantObject) {
        ProductVariant variant = (ProductVariant) variantObject;
        return this.getName().equals(variant.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
