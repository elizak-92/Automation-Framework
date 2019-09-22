package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class OrderHistoryPage extends BasePage {

    private final static By PAGE_TITLE = By.xpath("/html/head/title");
    private final static By HISTORY_PAGE_BUTTON = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a");
    private final static By ORDER_REFERENCE = By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]");
    private final static By DATE = By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[2]");
    private final static By TOTAL_PRICE = By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[3]/span");
    private final static By PAYMENT = By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[4]");
    private final static By STATUS = By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[5]/span");

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public void checkHistoryOrder(String price, String payment, String status) {
        String orderReference = driver.findElement(ORDER_REFERENCE).getText();
        assertFalse(orderReference.isEmpty());
        String date = driver.findElement(DATE).getText();
        LocalDate today = LocalDate.now();
        String dateFormatter = today.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        assertTrue(date.equals(dateFormatter));
        price = driver.findElement(TOTAL_PRICE).getText();
        assertTrue(price.equals("$19.25"));
        payment = driver.findElement(PAYMENT).getText();
        assertTrue(payment.equals("Bank wire"));
        status = driver.findElement(STATUS).getText();
        assertTrue(status.equals("On backorder"));
    }

    public void clickOrderHistoryPageButton() {
        driver.findElement(HISTORY_PAGE_BUTTON).click();
    }

}