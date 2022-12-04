package tests.topUpAnyPhoneNumber.negative_scenarion;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static commonAndConstant.Constant.MobileTopUpTestData.MOBILE_PAYMENT_VOID_FIELD;
import static commonAndConstant.Constant.Urls.MOBILE_PAYMENT_URL;

public class MobilePhoneTopUpPageNegativeTest extends BaseTest {

    @Test
    public void checkAccessWithVoidCreds(){
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        mobilePhoneTopUpPage
                .submitPayButton()
                .checkAccessWithVoidTelephoneNumberField(MOBILE_PAYMENT_VOID_FIELD)
                .checkAccessWithVoidMoneyAmountField(MOBILE_PAYMENT_VOID_FIELD)
                .checkAccessWithVoidCardNumberField(MOBILE_PAYMENT_VOID_FIELD)
                .checkAccessWithVoidExpiredDataField(MOBILE_PAYMENT_VOID_FIELD)
                .checkAccessWithVoidCvvField(MOBILE_PAYMENT_VOID_FIELD);
    }
}
