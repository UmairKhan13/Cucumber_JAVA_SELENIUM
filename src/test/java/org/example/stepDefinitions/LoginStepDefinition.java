package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.generalizedOperations.enums.IdentifierType;
import org.example.pageObjectClass.loginModule.LoginPagePOM;

import static org.example.drivers.WebDriverManager.*;
import static org.example.generalizedOperations.commonActions.WebPortalActions.getElementText;
import static org.example.generalizedOperations.commonActions.WebPortalActions.isElementDisplayed;
import static org.example.pageObjectClass.loginModule.LoginModuleIdentifiers.*;
import static org.example.pageObjectClass.loginModule.LoginPageTestData.*;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginStepDefinition
{
    LoginPagePOM loginPagePOM;

    @Before
    public void setup()
    {
        loginPagePOM = new LoginPagePOM();
        setUpWebDriver();
    }

    @After
    public void tearDown()
    {
        loginPagePOM = null;
        closeWebDriver();
        quitWebDriver();
    }

    @Given("User is on Swag Labs page")
    public void user_is_on_swag_labs_page() {
        navigateTo(getWebPortalURL());
        maximizeWindow();
    }

   @Given("User enters valid username and password")
   public void user_enters_valid_username_and_password() {
       loginPagePOM.EnterEmail(CORRECT_USER_EMAIL);
       loginPagePOM.EnterPassword(CORRECT_USER_PASSWORD);
    }

    @When("Clicks on login button")
    public void clicks_on_login_button() {
        loginPagePOM.ClickLoginButton();
    }

    @Then("User is navigated to home page")
    public void user_is_navigated_to_home_page() {
        assertEquals(getElementText(IdentifierType.CSS, productTitleTxt), PRODUCT_TITLE);
    }

    @Given("User entered invalid {string} and {string}")
    public void user_entered_invalid_and(String email, String password) {
        loginPagePOM.EnterEmail(email);
        loginPagePOM.EnterPassword(password);
    }
    @When("User click on the login button")
    public void user_click_on_the_login_button() {
        loginPagePOM.ClickLoginButton();
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        assertEquals(getElementText(IdentifierType.CSS, errorMessageTxtBox), ERROR_MESSAGE_ON_WRONG_CREDENTIALS);
    }

    @Given("User login using valid username and password")
    public void user_login_using_valid_username_and_password() {
        loginPagePOM.EnterEmail(CORRECT_USER_EMAIL);
        loginPagePOM.EnterPassword(CORRECT_USER_PASSWORD);
        loginPagePOM.ClickLoginButton();
    }
    @When("Goto Dashboard")
    public void goto_dashboard() {
       loginPagePOM.ClickOnDashboard();
    }

    @When("Clicks on Logout Button")
    public void clicks_on_logout_button() {
        loginPagePOM.ClickOnLogoutButton();
    }

    @Then("User should be redirected to the Login Page")
    public void user_should_be_redirected_to_the_login_page() {
       assertTrue(isElementDisplayed(IdentifierType.CSS, EmailTxtBox));
    }


}
