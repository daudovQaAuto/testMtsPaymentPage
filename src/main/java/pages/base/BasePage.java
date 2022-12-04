package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static commonAndConstant.Constant.TimeOutVariables.EXPLICIT_WAIT;

//в бэйс пэйдж у нас находятся методы, которые выполняются для всех страниц
public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    /**The method for navigating to a specific URl(website)*/
    public void goToUrl(String url){
        driver.get(url);
    }
    /** Waiting for visibility certain element in DOM model */
    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver,EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    /** Waiting for certain element in DOM model to be clickable */
    public WebElement elementIsClickable(WebElement element_1){
        new WebDriverWait(driver,EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(element_1));
        return element_1;
    }
}
