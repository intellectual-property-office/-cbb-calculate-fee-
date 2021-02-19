package uk.gov.ipo.feecalculations.rules.model;

import org.junit.jupiter.api.Test;
import uk.gov.ipo.feecalculations.rules.model.ProductVariant;
import uk.gov.ipo.feecalculations.rules.model.Rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class FeeItemComparatorTest {

    @Test
    public void testFeeItemComparatorAlwaysPutsRegistrationFeeAsFirstItem(){
        List<FeeItem> feeItemList = new ArrayList<FeeItem>();

        feeItemList.add(new FeeItem("trademark_class1", "Class 1", new BigDecimal(50)));
        feeItemList.add(new FeeItem("trademark_class2", "Class 2", new BigDecimal(50)));
        feeItemList.add(new FeeItem("registration_fee", "Trademark registration fee", new BigDecimal(170)));
        feeItemList.add(new FeeItem("trademark_class3", "Class 3", new BigDecimal(50)));

        Collections.sort(feeItemList, new FeeItemComparator());

        assertEquals(feeItemList.get(0).getId(), "registration_fee");
    }

    @Test
    public void testFeeItemComparatorAlwaysPutsRegistrationFeeAsFirstItemWhenSortedFromRuleObject(){
        List<FeeItem> feeItemList = new ArrayList<FeeItem>();

        feeItemList.add(new FeeItem("trademark_class1", "Class 1", new BigDecimal(50)));
        feeItemList.add(new FeeItem("trademark_class2", "Class 2", new BigDecimal(50)));
        feeItemList.add(new FeeItem("registration_fee", "Trademark registration fee", new BigDecimal(170)));
        feeItemList.add(new FeeItem("trademark_class3", "Class 3", new BigDecimal(50)));

        Rule rule = new Rule();
        rule.setFeeBreakdown(feeItemList);

        Collections.sort(rule.getFeeBreakdown(), new FeeItemComparator());

        assertEquals(rule.getFeeBreakdown().get(0).getId(), "registration_fee");
    }
}
