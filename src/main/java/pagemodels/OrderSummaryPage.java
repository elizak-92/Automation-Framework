package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage extends BasePage {

    private final static By CONFIRM_ORDER = By.xpath("//*[@id=\"cart_navigation\"]/button");

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    public void clickTheconfirmMyOrderButton() {
        driver.findElement(CONFIRM_ORDER).click();
    }


}
