package stepsdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagemodels.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutomationPracticeStepDef {

    private HomePage homePage;
    private WebDriver driver;
    private AuthenticationPage authenticationPage;
    private OrderHistoryPage orderHistoryPage;

    @When("^user opens the automationpractice website and clicks the Sign in button$")
    public void userOpensTheAutomationPracticeWebsiteAndClicksTheSignInButton() {
        homePage = new HomePage(getWebDriver());
        homePage.openHomePage();
        homePage.clickSignUpButton();
    }

    @When("^user opens the automationpractice website$")
    public void userOpensTheAutomationPracticeWebsite() {
        homePage = new HomePage(getWebDriver());
        homePage.openHomePage();
    }

    @And("^user clicks the Add to cart button$")
    public void userClicksTheAddToCartButton() {
        TshirtCategoryPage tcp = new TshirtCategoryPage(getWebDriver());
        tcp.clickAddToCart();
    }

    @And("^user selects a \"([^\"]*)\" and adds it to the cart$")
    public void userClicksTheAddToCartButton(String tshirt) {
        TshirtCategoryPage tcp = new TshirtCategoryPage(getWebDriver());
        String expected = "Faded Short Sleeve T-shirts";
        String actual = tshirt;
        assertEquals(expected, actual);
        tcp.clickAddToCart();
    }

    @And("^selects t-shirts category from the navigation menu$")
    public void userSelectsTshirtCategory() {
        homePage.selectTshirtCategory();
    }

    @And("^user clicks the Proceed to checkout button$")
    public void userClicksTheProceedToCheckoutButton() {
        homePage.clickProceedToCheckout();
    }


    @When("^user opens the automationpractice website and selects \"([^\"]*)\" category$")
    public void userOpensTheAutomationPracticeWebsiteAndSelectCategory() {
        homePage.clickSignUpButton();
    }

    @And("^user clicks the Proceed to checkout button on the Summary page$")
    public void userClicksTheProceedToCheckoutButtonOnTheSummaryPage() {
        SummaryPage summaryPage = new SummaryPage(getWebDriver());
        summaryPage.openSummaryPage();
        summaryPage.clickProceedToCheckoutSummary();
    }


    @And("^user inserts \"([^\"]*)\" and \"([^\"]*)\" and clicks the Sign in button$")
    public void theUserInsertsEmailAndPasswordAndClickTheSignInButton(String email, String password) {
        authenticationPage.getEmailInput(email);
        authenticationPage.getPasswordInput(password);
        authenticationPage.clickTheSignInButton();
    }

    @And("^user clicks the Proceed to checkout button on the Addresses page$")
    public void userClicksTheProceedToCheckoutButtonOnTheAddressesPage() {
        MyAddressesPage myAddressesPage = new MyAddressesPage(getWebDriver());
        myAddressesPage.clickTheProceedToCheckoutButton();
    }

    @And("^user selects the terms of service checkbox$")
    public void userSelectsTheCheckbox() {
        ShippingPage shippingPage = new ShippingPage(getWebDriver());
        shippingPage.clickCheckBox();
        shippingPage.clickProceedToCheckout();
    }

    @And("^user clicks Pay by bank wire button$")
    public void userClicksPayByBankWireButton() {
        PaymentPage payment = new PaymentPage(getWebDriver());
        payment.clickPayByBankWire();
    }

    @And("^user clicks the I Confirm My Order button$")
    public void userClicksTheIConfirmMyOrderButton() {
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(getWebDriver());
        orderSummaryPage.clickTheconfirmMyOrderButton();
    }

    @And("^user clicks the My Personal Information button$")
    public void andTheUserClicksTheMyPersonalInformationButton() {
        MyAccountPage myAccountPage = new MyAccountPage(getWebDriver());
        myAccountPage.clickMyPersonalInformationButton();
    }

    @And("^user updates the First Name field to \"([^\"]*)\" and clicks Save$")
    public void theUserUpdatesTheFirstNameFieldTo(String firstName) {
        MyAddressesPage myAddressesPage = new MyAddressesPage(getWebDriver());
        myAddressesPage.removeFirstName();
        myAddressesPage.getfirstNameInput(firstName);
        myAddressesPage.confirmPassword();
        myAddressesPage.clickTheSaveButton();
    }

    @And("^user logs out$")
    public void userLogsOut() {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.clickSignOutButton();
        driver.close();
    }

    @Then("the Authentication page is displayed$")
    public void theAuthenticationPageIsDisplayed() {
        authenticationPage = new AuthenticationPage(getWebDriver());
        authenticationPage.getPageTitle();
    }


    @And("^user opens my Account Page$")
    public void userOpensMyAccountPage() {
        SummaryPage summaryPage = new SummaryPage(getWebDriver());
        summaryPage.goToMyAccountPage();
    }

    @And("^user clicks the Order History and Details button$")
    public void userClicksTheOrderHistoryButton() {
        orderHistoryPage = new OrderHistoryPage(getWebDriver());
        orderHistoryPage.clickOrderHistoryPageButton();
    }

    @Then("^a new order is displayed for today's date, with a total price of \"([^\"]*)\", using a payment method \"([^\"]*)\" with a status of \"([^\"]*)\"$")
    public void userGoesToTheOrderHistoryPage(String price, String payment, String status) {
        orderHistoryPage.checkHistoryOrder(price, payment, status);
    }

    @And("^the following confirmation message is displayed:$")
    public void theFollowingConfirmationMessageIsDisplayed(String msg) {
        String expected = "Product successfully added to your shopping cart";
        String actual = msg;
        assertEquals(expected, actual);
    }

    private WebDriver getWebDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\dev\\selenium\\binaries\\windows\\googlechrome\\64bit\\chromedriver.exe");
            ChromeDriver chromeDriver = new ChromeDriver();
            chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver = chromeDriver;
            return chromeDriver;
        }
        return driver;
    }

}
