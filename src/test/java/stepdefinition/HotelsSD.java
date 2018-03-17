package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BasePage;
import framework.HotelsHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.ParseException;

/**
 * Created by joselitowilliamraymundo on 2/17/18.
 */
public class HotelsSD {

    public HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^I am on Hotels homepage$")
    public void iAmOnHotelsHomePage() {

        Assert.assertEquals(BasePage.getDriver().getTitle(), "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals");
    }

    @Then("^I verify that desired check-in date is selected$")
    public void verifyCustomCheckIn() {
        Assert.assertEquals(hotelsHomePage.selected,true,"No selection made");
    }

    @When("^I click on destination box$")
    public void clickOnDestinationBox() throws InterruptedException {
        hotelsHomePage.clickOnDestinationBox();


    }

    @And("^I enter (.+) as (search key|final destination)$")
    public void sendText(String value, String field) throws InterruptedException {
        switch (field){
            case "search key":
                hotelsHomePage.enterSearchKey(value);
                break;
            case "final destination":
                hotelsHomePage.enterFinalDestination(value);
                break;
        }
    }

    @And("^I select tomorrows date in Check-in date$")
    public void selectTomorrow(){
        hotelsHomePage.selectTomorrowsDate();
    }

    @And("^I select ([0-9]) days stay$")
    public void selectCheckOut(int n){
        hotelsHomePage.selectCheckOutDate(n);

    }

    @Then("^I verify that number of nights is correctly displayed$")
    public void verifyCorrectDisplay(){
        Assert.assertEquals(hotelsHomePage.numberOfNightsDisplayed(),hotelsHomePage.days,"Not Equal");
    }

    @When("^I click on options$")
    public void selectOption(){
        hotelsHomePage.selectOption();

    }

    @And("^I enter 2 adults, 2 children and ages$")
    public void enterOtherOptions(){
        hotelsHomePage.enterOtherOptions();
    }

    @And("^I click on search button")
    public void clickOnSearchBtn(){
        hotelsHomePage.clickOnSearchBtn();

    }

    @Then("^I verify that selection made is correctly displayed$")
    public void verifySelectionDisplay(){
    Assert.assertEquals(hotelsHomePage.selectionDisplayedCorrectly(),true,"Wrong Display");
    }
}
