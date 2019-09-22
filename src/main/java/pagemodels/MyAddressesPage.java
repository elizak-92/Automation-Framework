package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAddressesPage extends BasePage {

    private static final By SAVE_BUTTON = By.xpath("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button");
    private static final By FIRST_NAME_INPUT = By.id("firstname");
    private static final By PROCEED_TO_CHECKOUT = By.xpath("//*[@id=\"center_column\"]/form/p/button");
    private static final By CURRENT_PASSWORD = By.xpath("//*[@id=\"old_passwd\"]");

    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }

    public void clickTheProceedToCheckoutButton() {
        driver.findElement(PROCEED_TO_CHECKOUT).click();
    }

    public void clickTheSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public void removeFirstName() {
        driver.findElement(FIRST_NAME_INPUT).clear();
    }

    public void getfirstNameInput(String firstName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
    }

    public void confirmPassword() {
        driver.findElement(CURRENT_PASSWORD).sendKeys("Password123");
    }

}