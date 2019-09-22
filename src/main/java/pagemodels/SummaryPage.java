package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends BasePage {

    private final static By PROCEED_TO_CHECKOUT = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
    private final static By ACCOUNT_PAGE = By.className("account");
    private static final String PAGE_URL = "http://automationpractice.com/index.php?controller=order";


    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceedToCheckoutSummary() {
        driver.findElement(PROCEED_TO_CHECKOUT).click();
    }

    public void openSummaryPage() {
        driver.navigate().to(PAGE_URL);
    }

    public void goToMyAccountPage() {
        driver.findElement(ACCOUNT_PAGE).click();
    }

}
