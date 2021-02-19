package uk.gov.ipo.feecalculations.rules.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class APIControllerTest {

    @Autowired
    private MockMvc mvc;

    private String trademarkInput = "{ \"feeCalculation\": [ { \"productRight\": \"TRADEMARK\", \"dateTime\": \"2020-08-17T00:00:00.000+0000\", \"paymentOption\": \"PAY_NOW\", \"paymentChannel\": \"BANK_TRANSFER\", \"productService\": \"APPLICATION_TO_REGISTER_A_TRADE_MARK\", \"productVariant\": [ { \"name\": \"Class1\" } ], \"productData\": [] } ] }";
    private String trademarkInputAllClasses = "{ \"feeCalculation\": [ { \"productRight\": \"TRADEMARK\", \"dateTime\": \"2020-08-17T00:00:00.000+0000\", \"paymentOption\": \"PAY_NOW\", \"paymentChannel\": \"BANK_TRANSFER\", \"productService\": \"APPLICATION_TO_REGISTER_A_TRADE_MARK\", \"productVariant\": [ { \"name\": \"Class1\" }, { \"name\": \"Class2\" }, { \"name\": \"Class3\" }, { \"name\": \"Class4\" }, { \"name\": \"Class5\" }, { \"name\": \"Class6\" }, { \"name\": \"Class7\" }, { \"name\": \"Class8\" }, { \"name\": \"Class9\" }, { \"name\": \"Class10\" }, { \"name\": \"Class11\" }, { \"name\": \"Class12\" }, { \"name\": \"Class13\" }, { \"name\": \"Class14\" }, { \"name\": \"Class15\" }, { \"name\": \"Class16\" }, { \"name\": \"Class17\" }, { \"name\": \"Class18\" }, { \"name\": \"Class19\" }, { \"name\": \"Class20\" }, { \"name\": \"Class21\" }, { \"name\": \"Class22\" }, { \"name\": \"Class23\" }, { \"name\": \"Class24\" }, { \"name\": \"Class25\" }, { \"name\": \"Class26\" }, { \"name\": \"Class27\" }, { \"name\": \"Class28\" }, { \"name\": \"Class29\" }, { \"name\": \"Class30\" }, { \"name\": \"Class31\" }, { \"name\": \"Class32\" }, { \"name\": \"Class33\" }, { \"name\": \"Class34\" }, { \"name\": \"Class35\" }, { \"name\": \"Class36\" }, { \"name\": \"Class37\" }, { \"name\": \"Class38\" }, { \"name\": \"Class39\" }, { \"name\": \"Class40\" }, { \"name\": \"Class41\" }, { \"name\": \"Class42\" }, { \"name\": \"Class43\" }, { \"name\": \"Class44\" }, { \"name\": \"Class45\" } ], \"productData\": [] } ] }";
    private String designInput = "{ \"feeCalculation\": [ { \"productRight\": \"DESIGN\", \"dateTime\": \"2020-08-17T00:00:00.000+0000\", \"paymentOption\": \"PAY_NOW\", \"paymentChannel\": \"BANK_TRANSFER\", \"productService\": \"APPLICATION_TO_REGISTER_ONE_OR_MORE_DESIGNS\", \"productData\": [] } ] }";
    private String patentInput = "{ \"feeCalculation\": [ { \"productRight\": \"PATENT\", \"dateTime\": \"2020-08-17T00:00:00.000+0000\", \"paymentOption\": \"PAY_NOW\", \"paymentChannel\": \"BANK_TRANSFER\", \"productService\": \"REQUEST_FOR_GRANT_OF_A_PATENT\", \"productVariant\": [], \"productData\": [] } ] }";
    private String patentSearchInput = "{ \"feeCalculation\": [ { \"productRight\": \"PATENT\", \"dateTime\": \"2020-08-17T00:00:00.000+0000\", \"paymentOption\": \"PAY_NOW\", \"paymentChannel\": \"BANK_TRANSFER\", \"productService\": \"REQUEST_A_SEARCH_FOR_A_UK_APPLICATION\", \"productVariant\": [], \"productData\": [{ \"name\": \"number-of-claims\", \"value\": 25 } ] } ] }";

    private String url = "/ipo/FeeCalculationRule";

    @Test
    public void testPostRequestReturnsOkStatus() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(trademarkInput))
                .andExpect(status().isOk());
    }

    @Test
    public void testPostRequestReturnsBadRequestWhenContentIsEmpty() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testRuleControllerReturnsIpoFeeCalculationAsTopLevelItem() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(trademarkInput))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feeCalculation").exists());
    }


    @Test
    public void testRuleControllerReturnsFeeCalculationAsArray() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(trademarkInput))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feeCalculation").isArray());
    }

    @Test
    public void testRuleControllerReturnsInputAsOutput() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(trademarkInput))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feeCalculation[0].productRight").value("TRADEMARK"))
                .andExpect(jsonPath("$.feeCalculation[0].dateTime").value("2020-08-17T00:00:00.000+0000"))
                .andExpect(jsonPath("$.feeCalculation[0].paymentOption").value("PAY_NOW"))
                .andExpect(jsonPath("$.feeCalculation[0].paymentChannel").value("BANK_TRANSFER"))
                .andExpect(jsonPath("$.feeCalculation[0].productVariant[0].name").value("Class1"));
    }

    @Test
    public void testRuleControllerReturnsTrademarkRegistrationFeeInfeeBreakdown() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(trademarkInput))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[0].value").value("170"))
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[0].name").value("Trademark Registration Fee"));
    }

    @Test
    public void testRuleControllerReturnsDesignRegistrationFeeInfeeBreakdown() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(designInput))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[0].value").value("120"))
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[0].name").value("Design Registration Fee"));
    }

    @Test
    public void testRuleControllerReturnsPatentRegistrationFeeInfeeBreakdown() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(patentInput))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[0].value").value("60"))
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[0].name").value("Patent Registration Fee"));
    }

    @Test
    public void testRuleControllerReturnsPatentSearchFeeInfeeBreakdown() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(patentSearchInput))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[0].value").value("60"))
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[0].name").value("Patent Registration Fee"))
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[1].value").value("150"))
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[1].name").value("Patent Search"));
    }

    @Test
    public void testRuleControllerReturnsTrademarkClassFeeInfeeBreakdown() throws Exception {
        for(int index = 1 ; index <= 45 ; index++){
            runTestOnClassFeaBreakdownItem(index);
        }
    }

    public void runTestOnClassFeaBreakdownItem(int index) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(trademarkInputAllClasses))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.feeCalculation[0].feeBreakdown[" + index + "].value").value("50"));
    }

}