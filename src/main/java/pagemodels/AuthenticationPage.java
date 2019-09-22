package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AuthenticationPage extends BasePage {


    private final static By EMAIL_INPUT = By.id("email");
    private final static By PASSWORD_INPUT = By.id("passwd");
    private final static By SIGN_IN_BUTTON = By.id("SubmitLogin");
    private final static By PAGE_TITLE = By.xpath("/html/head/title");


    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public void getEmailInput(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void getPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickTheSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    public void getPageTitle() {
        WebElement element = driver.findElement(PAGE_TITLE);
        element.getLocation();
    }

}