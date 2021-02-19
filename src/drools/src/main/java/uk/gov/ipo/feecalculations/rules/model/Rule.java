package uk.gov.ipo.feecalculations.rules.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rule {
    private String productRight;
    private String productService;
    private Date dateTime;
    private String paymentChannel;
    private String paymentOption;
    private List<ProductVariant> productVariant;
    private List<ProductDataItem> productData;

    private List<FeeItem> feeBreakdown;

    public Rule() {
        this.feeBreakdown = new ArrayList<FeeItem>();
    }

    @JsonProperty("productRight")
    public String getProductRight() {
        return productRight;
    }

    public void setProductRight(String productRight) {
        this.productRight = productRight;
    }

    @JsonProperty("productService")
    public String getProductService() {
        return productService;
    }

    public void setProductService(String productService) {
        this.productService = productService;
    }

    @JsonProperty("dateTime")
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @JsonProperty("paymentChannel")
    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    @JsonProperty("paymentOption")
    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    @JsonProperty("productVariant")
    public List<ProductVariant> getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(List<ProductVariant> productVariant) {
        this.productVariant = productVariant;
    }

    @JsonProperty("productData")
    public List<ProductDataItem> getProductData() {
        return productData;
    }

    public void setProductData(List<ProductDataItem> productData) {
        this.productData = productData;
    }

    @JsonProperty("feeBreakdown")
    public List<FeeItem> getFeeBreakdown() {
        return feeBreakdown;
    }

    public void setFeeBreakdown(List<FeeItem> feeBreakdown) {
        this.feeBreakdown = feeBreakdown;
    }
}
