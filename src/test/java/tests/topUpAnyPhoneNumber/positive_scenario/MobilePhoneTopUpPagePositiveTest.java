package tests.topUpAnyPhoneNumber.positive_scenario;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static commonAndConstant.Constant.MobileTopUpTestData.*;
import static commonAndConstant.Constant.Urls.MOBILE_PAYMENT_URL;

public class MobilePhoneTopUpPagePositiveTest extends BaseTest {

    @Test
    public void checkLoginPageAccessibility(){
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        mobilePhoneTopUpPage.loginPageAccessibility();
    }
    @Test
    public void checkRegionSelectorPerfomance(){
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        mobilePhoneTopUpPage.selectRegionBar()
                            .selectRegion();
    }
    @Test
    public void checkMainPageAccessibility(){
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        mobilePhoneTopUpPage.checkMainPageAccess()
                .checkBankProductsButton()
                .checkAutoPaymentButton()
                .checkPromoButton();
    }
    @Test
    public void mobileTopUp(){
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        mobilePhoneTopUpPage.enterPhoneNumber(MOBILE_PAYMENT_PHONE_NUMBER)
                .enterAmountOfMoney("150")
                .enterCardFrom(MOBILE_PAYMENT_CARD)
                .enterCardExpDate(MOBILE_PAYMENT_CARD_EXP_DATE)
                .enterCardCVV(MOBILE_PAYMENT_CARD_CVV)
                .submitPayButton()
                .checkPaymentRejection("Извините, платеж не был совершен");
    }

}
