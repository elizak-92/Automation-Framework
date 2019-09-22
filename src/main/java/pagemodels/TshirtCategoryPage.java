package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TshirtCategoryPage extends BasePage {

    private final static By PRODUCT_CONTAINER = By.className("product-container");
    private final static By ADD_TO_CART = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]");

    public TshirtCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        WebElement ele = driver.findElement(PRODUCT_CONTAINER);
        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();
        driver.findElement(ADD_TO_CART).click();
    }
}
