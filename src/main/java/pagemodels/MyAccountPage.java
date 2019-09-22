package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccountPage extends BasePage {

    private static final By MY_PERSONAL_INFO_BUTTON = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a");


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    public void clickMyPersonalInformationButton() {
        driver.findElement(MY_PERSONAL_INFO_BUTTON).click();
    }

}