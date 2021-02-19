package uk.gov.ipo.feecalculations.rules.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RuleTest {

    @Test
    public void testRuleIsInitialisedWithEmptyFeeBreakdownList(){
        Rule rule = new Rule();
        assertNotNull(rule.getFeeBreakdown());
    }

    @Test
    public void testRuleProductVariantsListCanFindContainingVariant(){
        Rule rule = new Rule();

        ProductVariant variant1 = new ProductVariant("Class1");
        ProductVariant variant2 = new ProductVariant("Class2");

        List<ProductVariant> productVariant = new ArrayList<>();
        productVariant.add(variant1);
        productVariant.add(variant2);

        rule.setProductVariant(productVariant);

        boolean variantsContainsClass1 = rule.getProductVariant().contains(new ProductVariant("Class1"));
        assertTrue(variantsContainsClass1);

        boolean variantsContainsClass2 = rule.getProductVariant().contains(new ProductVariant("Class2"));
        assertTrue(variantsContainsClass2);

        boolean variantsContainsClass3 = rule.getProductVariant().contains(new ProductVariant("Class3"));
        assertFalse(variantsContainsClass3);
    }

    @Test
    public void testRuleProductDataItemListCanFindContainingDataItem(){
        Rule rule = new Rule();

        ProductDataItem item1 = new ProductDataItem("number-of-claims", 10);
        ProductDataItem item2 = new ProductDataItem("number-of-claims", 25);

        List<ProductDataItem> dataItems = new ArrayList<>();
        dataItems.add(item1);
        dataItems.add(item2);

        rule.setProductData(dataItems);

        boolean dataItemsContains10Claims = rule.getProductData().contains(new ProductDataItem("number-of-claims", 10));
        assertTrue(dataItemsContains10Claims);

        boolean dataItemsContains25Claims = rule.getProductData().contains(new ProductDataItem("number-of-claims", 25));
        assertTrue(dataItemsContains25Claims);

        boolean dataItemsContains35Claims = rule.getProductData().contains(new ProductDataItem("number-of-claims", 35));
        assertFalse(dataItemsContains35Claims);
    }
}
