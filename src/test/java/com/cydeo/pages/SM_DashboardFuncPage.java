package com.cydeo.pages;

import com.cydeo.utlilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SM_DashboardFuncPage {

    public SM_DashboardFuncPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//li[@style='display: block;']")
    public List<WebElement> allModules;







}
