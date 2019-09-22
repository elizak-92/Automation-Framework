package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    private final static By BANK_WIRE_PAYMENT = By.className("bankwire");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void clickPayByBankWire() {
        driver.findElement(BANK_WIRE_PAYMENT).click();
    }
}
