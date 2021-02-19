package uk.gov.ipo.feecalculations.rules.model;

import java.util.Comparator;

public class FeeItemComparator implements Comparator<FeeItem> {

    @Override
    public int compare(FeeItem feeItem1, FeeItem feeItem2) {
        String registrationFeeId = "registration_fee";

        if(feeItem1.getId().equals(registrationFeeId)){
            return -1;
        }
        else if(feeItem2.getId().equals(registrationFeeId)){
            return 1;
        }
        else{
            return feeItem1.getId().compareTo(feeItem2.getId());
        }
    }
}
