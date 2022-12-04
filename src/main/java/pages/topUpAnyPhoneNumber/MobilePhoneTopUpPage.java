package pages.topUpAnyPhoneNumber;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import pages.base.BasePage;

public class MobilePhoneTopUpPage extends BasePage {

    public MobilePhoneTopUpPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Locators for positive tests
     * */
    private final By loginButton = By.xpath("//a[@class='mts16-other-sites__btn login-button']");
    private final By inputPhoneNumber = By.xpath("(//input[@data-type='phone'])[1]");
    private final By inputMoneyAmount = By.xpath("//input[@data-type='amount']");
    private final By inputCardNumber = By.xpath("(//input[@inputmode='numeric'])[2]");
    private final By inputCardExpDate = By.xpath("(//input[@name='ExpiryMonthYear'])[2]");
    private final By inputCardCVV = By.xpath("(//input[@name='Cvc'])[2]");
    private final By buttonSubmitPay = By.xpath("//button[@name='btn_submit']");
    private final By paymentRejectNotification = By.xpath("//span[contains(text(),'Извините, платеж')]");
    private final By regionSelectionButton = By.xpath("//span[@class='vcnCurrentRegionName']");
    private final By region = By.xpath("(//li[@class='mts16-popup-regions__item']//descendant::a)[2]");
   // private final By selectedRegion = By.xpath("//span[@class='mts16-top-panel__region-arrow']/preceding-sibling::span");
    private final By selectedRegion = By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div/span[1]");
    private final By mainPageButton = By.xpath("//li[@class='mts16-mainmenu__lv1-item ']//a[@href='/']");
    private final By bankProductsButton = By.xpath("//li[@class='mts16-mainmenu__lv1-item ']//a[@href='/page/bankproducts']");
    private final By promoButton = By.xpath("//li[@class='mts16-mainmenu__lv1-item ']//a[@href='/promo']");
    private final By autopaymentButton = By.xpath("//li[@class='mts16-mainmenu__lv1-item ']//a[@href='/autopayment']");


    /**
     * Locators for negative tests
     * */
    private final By voidTelephoneNumberFieldError = By.xpath("//div[@data-error_holder='Parameter[0]_NUMBER']");
    private final By voidMoneyAmountFieldError = By.xpath("//div[@data-error_holder='Sum']");
    private final By voidCardNumberFieldError = By.xpath("//div[@data-error_holder='Pan']");
    private final By voidExpiredDataFieldError = By.xpath("//div[@data-error_holder='Exp']");
    private final By voidCvcFieldError = By.xpath("//div[@data-error_holder='Cvc']");




    /* METHODS TO CHECK PHONE TOP UP ABILITY
     * Методы для проверки возможности оплаты
     * */
    /**
     * Clicking button for getting access to user account
     * */
    public MobilePhoneTopUpPage loginPageAccessibility(){
        driver.findElement(loginButton).click();
        return this;
    }
    /**
     * Enter phone number excluding country code
     * @param number phone number (ввести номер телефона)
     * */
    public MobilePhoneTopUpPage enterPhoneNumber(String number){
        driver.findElement(inputPhoneNumber).sendKeys(number);
        return this;
    }
    /**
     * Enter amount of replenishment money
     * @param amount money amount (ввести сумму пополнения)
     * */
    public MobilePhoneTopUpPage enterAmountOfMoney(String amount){
        driver.findElement(inputMoneyAmount).sendKeys(amount);
        return this;
    }
    /**
     * Enter card number
     * @param card card number (ввести номер банковской карты)
     * */
    public MobilePhoneTopUpPage enterCardFrom (String card){
        driver.findElement(inputCardNumber).sendKeys(card);
        return this;
    }
    /**
     * Enter expired date of card (Format "0422")
     * @param expDate expired date of card (ввести дату окончания срока действия карты )
     * */
    public MobilePhoneTopUpPage enterCardExpDate(String expDate){
        driver.findElement(inputCardExpDate).sendKeys(expDate);
        return this;
    }
    /**
     * Enter CVV of the card (Format "123")
     * @param cvv cvv of the card (ввести CVV номер карты  )
     * */
    public MobilePhoneTopUpPage enterCardCVV (String cvv){
        waitElementIsVisible(driver.findElement(inputCardCVV));
        driver.findElement(inputCardCVV).sendKeys(cvv);
        return this;
    }
    /**
     * Push the "Оплатить" button
     * */
    public MobilePhoneTopUpPage submitPayButton(){
        driver.findElement(buttonSubmitPay).click();
        return this;
    }
    /**
     * Expecting the page with payment rejection
     * */
    public MobilePhoneTopUpPage checkPaymentRejection (String text){
        waitElementIsVisible(driver.findElement(paymentRejectNotification));
        WebElement paymentFailure = driver.findElement(paymentRejectNotification);
        Assertions.assertEquals(text, paymentFailure.getText());
        return this;
    }




    /* METHODS TO CHECK ACCESS TO REGION SELECTER
     * Методы для проверки работоспособности селектора региона
     * */
    /**
     * Clicking region choosing bar
     * */
    public MobilePhoneTopUpPage selectRegionBar(){
        driver.findElement(regionSelectionButton).click();
        return this;
    }
    /**
     * Selecting region and matching selected region with presented region on new page
     * */
    public MobilePhoneTopUpPage selectRegion(){
        waitElementIsVisible(driver.findElement(region));
        String selectedRegionValue = driver.findElement(region).getText();
        driver.findElement(region).click();

        waitElementIsVisible(driver.findElement(selectedRegion));
        WebElement selectedRegionOnNewPage = driver.findElement(selectedRegion);
        Assertions.assertEquals(selectedRegionValue, selectedRegionOnNewPage.getText());

        return this;
    }




    /* METHODS TO CHECK CLICKABILITY OF LINKS IN HEADER'S MAIN MENU
     * Методы для проверки кликабельности ссылок в шапке меню
     * */
    /**
     * Check main page link clickability
     * */
    public MobilePhoneTopUpPage checkMainPageAccess (){
        elementIsClickable(driver.findElement(mainPageButton));
        WebElement mainPageButtonElement = driver.findElement(mainPageButton);
        mainPageButtonElement.click();
        return this;
    }
    /**
     * Check bank products link clickability
     * */
    public MobilePhoneTopUpPage checkBankProductsButton (){
        elementIsClickable(driver.findElement(bankProductsButton));
        WebElement bankProductsButtonElement = driver.findElement(bankProductsButton);
        bankProductsButtonElement.click();
        return this;
    }
    /**
     * Check promo link clickability
     * */
    public MobilePhoneTopUpPage checkPromoButton (){
        elementIsClickable(driver.findElement(promoButton));
        WebElement bankProductsButtonElement = driver.findElement(promoButton);
        bankProductsButtonElement.click();
        return this;
    }
    /**
     * Check autopayment link clickability
     * */
    public MobilePhoneTopUpPage checkAutoPaymentButton (){
        elementIsClickable(driver.findElement(autopaymentButton));
        WebElement bankProductsButtonElement = driver.findElement(autopaymentButton);
        bankProductsButtonElement.click();
        return this;
    }




    /* METHODS TO CHECK ACCESS WITH VOID VALUES IN TH FIELDS
    *  Методы для проверки возможности продолжения оплаты с пустыми полями
    *  */
    /**
     * Checking for an error on empty data (number)
     * */
    public MobilePhoneTopUpPage checkAccessWithVoidTelephoneNumberField (String text){
        WebElement errorPhone = driver.findElement(voidTelephoneNumberFieldError);
        waitElementIsVisible(errorPhone);
        Assertions.assertEquals(text, errorPhone.getText());
        return this;
    }
    /**
     * Checking for an error on empty data (money amount)
     * */
    public MobilePhoneTopUpPage checkAccessWithVoidMoneyAmountField (String text){
        WebElement errorAmount  = driver.findElement(voidMoneyAmountFieldError);
        waitElementIsVisible(errorAmount);
        Assertions.assertEquals(text, errorAmount.getText());
        return this;
    }
    /**
     * Checking for an error on empty data (card number)
     * */
    public MobilePhoneTopUpPage checkAccessWithVoidCardNumberField (String text){
        WebElement errorCardNumber = driver.findElement(voidCardNumberFieldError);
        waitElementIsVisible(errorCardNumber);
        Assertions.assertEquals(text, errorCardNumber.getText());
        return this;
    }
    /**
     * Checking for an error on empty data (expired date)
     * */
    public MobilePhoneTopUpPage checkAccessWithVoidExpiredDataField (String text){
        WebElement errorExpired = driver.findElement(voidExpiredDataFieldError);
        waitElementIsVisible(errorExpired);
        Assertions.assertEquals(text, errorExpired.getText());
        return this;
    }
    /**
     * Checking for an error on empty data (CVV)
     * */
    public MobilePhoneTopUpPage checkAccessWithVoidCvvField (String text){
        WebElement errorCvv = driver.findElement(voidCvcFieldError);
        waitElementIsVisible(errorCvv);
        Assertions.assertEquals(text, errorCvv.getText());
        return this;
    }

}
