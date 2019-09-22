package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BasePage {

    private final static By LOGIN = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    private final static By PROCEED_TO_CHECKOUT = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    private final static By WOMEN_CONTAINER = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
    private final static By TSHIRT_CATEGORY = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a");


    private final static By SIGN_OUT = By.className("logout");

    private static final String PAGE_URL = "http://automationpractice.com";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.navigate().to(PAGE_URL);
    }

    public void clickSignUpButton() {
        driver.findElement(LOGIN).click();
    }


    public void selectTshirtCategory() {
        WebElement ele = driver.findElement(WOMEN_CONTAINER);
        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();
        driver.findElement(TSHIRT_CATEGORY).click();
    }

    public void clickProceedToCheckout() {
        driver.findElement(PROCEED_TO_CHECKOUT).click();
    }

    public void clickSignOutButton() {
        driver.findElement(SIGN_OUT).click();
    }

}