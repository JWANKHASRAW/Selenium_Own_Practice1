package com.cydeo.utlilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {



    /*
    This class will be storing only the utility methods that can be used across the project.
     */

    public static void sleep(int second){
        //This method will accept int( in seconds) and execute Thread.sleep method for given duration
        second *=1000;
        try{
            Thread.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // this method will accept a String as expected value and verify actual URL CONTAINS the value
    public static void verifyURLContains(String expectedInURL){

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    public static void switchWindowAndVerify( String expectedInUrl, String expectedTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for(String each: allWindowHandles){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL " + Driver.getDriver().getCurrentUrl()); //printing each url

            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle) );


    }

    //in this method we are moving the mouse to the given element
    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();

    }

    //return a list of string from a list of elements
    // accept a list of element and return a list of strim
    public static List<String> getElementText(List<WebElement> list){

        List<String> elementTexts = new ArrayList<>();
        for(WebElement el : list){
            elementTexts.add(el.getText());
        }

        return elementTexts;
    }


    public static void verifyTitleEqual(String expectedTitle){


        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }


    public static void verifyTitleContain(String expectedTitle){


        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }


    public static void waitForInvisibilityOfGivenElement(WebElement target){


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));



    }

    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param time
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }





    //this method accepts a dropdown element and returns a List<String> that contains all options values as String
    public static List<String> dropdownOptions_as_STRING(WebElement dropdownElement){

        Select month = new Select(dropdownElement);
        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions(); //we are storing all the actual month options into a list of webelement
        List<String> actualMonth_as_String = new ArrayList<>(); //to store the months after iteration into a String of Arraylist

        for (WebElement each : actualMonth_as_WEBELEMENT) { //looping through the list<WebElement>, getting all options' texts, and storing them into List<String>
            actualMonth_as_String.add(each.getText()); //adding the webelements to an arryList

        }


    return actualMonth_as_String;

    }

    public static void WebTableTitleContains(String expectedTitle){

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedTitle));
    }



    public static String paymentOption(String cardType){

        if(cardType == "visa") {
            Driver.getDriver().findElement(By.xpath("//label[.='Visa']")).click();
        }else if(cardType == "masterCard"){
            Driver.getDriver().findElement(By.xpath("//label[.='MasterCard']")).click();
        }else if(cardType == "americanExpress"){
            Driver.getDriver().findElement(By.xpath("//label[.='American Express']")).click();
        }

        return cardType;
    }


    public static void clickRadioButtons(List<WebElement> radioButtons, String attributeValue){//each element has diff value

        for (WebElement each : radioButtons) {
            if(each.getAttribute("value").equalsIgnoreCase( attributeValue)){
                each.click();
            }

        }


    }




}
