package com.cydeo.step_definitions;

import com.cydeo.pages.CRM_LoginPage;
import com.cydeo.utlilities.ConfigurationReader;
import com.cydeo.utlilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class CRM_Login_StepDef {

    CRM_LoginPage loginPage = new CRM_LoginPage();

    @Given("user is on ERP login page")
    public void user_is_on_erp_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("CRMurl"));

    }
    @When("user enter {string} username")
    public void user_enter_username(String string) {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("SalesManager_Email"));
    }
    @When("user enter {string} password")
    public void user_enter_password(String string) {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("SalesManager_Pass"));

    }
    @Then("user clicks to login button")
    public void user_clicks_to_login_button() {
        loginPage.loginButton.click();

    }


    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("CRMurl"));
    }
    @When("user enters below correct credentials")
    public void user_enters_below_correct_credentials(Map<String, String> credentials) {

        loginPage.inputUsername.sendKeys(credentials.get("username"));
        loginPage.inputPassword.sendKeys(credentials.get("password"));


    }


    @When("user enters below correct credentials info")
    public void userEntersBelowCorrectCredentialsInfo(Map<String, String> credentialsInfo)  {

        loginPage.inputUsername.sendKeys(credentialsInfo.get("username"));
        loginPage.inputPassword.sendKeys(credentialsInfo.get("password"));

    }
}
