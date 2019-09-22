package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BasePage {

    private final static By CHECKBOX = By.xpath("//*[@id=\"cgv\"]");
    private final static By PROCEED_TO_CHECKOUT = By.xpath("//*[@id=\"form\"]/p/button");

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckBox() {
        driver.findElement(CHECKBOX).click();
    }

    public void clickProceedToCheckout() {
        driver.findElement(PROCEED_TO_CHECKOUT).click();
    }

}
