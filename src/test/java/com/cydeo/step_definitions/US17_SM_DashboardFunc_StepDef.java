package com.cydeo.step_definitions;

import com.cydeo.pages.CRM_LoginPage;
import com.cydeo.pages.SM_DashboardFuncPage;
import com.cydeo.utlilities.ConfigurationReader;
import com.cydeo.utlilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US17_SM_DashboardFunc_StepDef {


        CRM_LoginPage login = new CRM_LoginPage();
        SM_DashboardFuncPage dashboardPage = new SM_DashboardFuncPage();

    @Given("sales manager is on the login page")
    public void sales_manager_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("CRMurl"));

    }
    @When("user enter the login information")
    public void user_enter_the_login_information() {

        login.inputUsername.sendKeys(ConfigurationReader.getProperty("SalesManager_Email"));
        login.inputPassword.sendKeys(ConfigurationReader.getProperty("SalesManager_Pass"));
        login.loginButton.click();
    }
    @Then("sales manager should see the following modules")
    public void sales_manager_should_see_the_following_modules(List<String> expectedModules) {
        List<String> actualModules = new ArrayList<>();
        for(WebElement eachModule: dashboardPage.allModules){

            actualModules.add(eachModule.getText());
        }
        Assert.assertEquals(expectedModules, actualModules );

    }


}
