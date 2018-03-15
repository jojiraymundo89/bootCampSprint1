package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyHomePage;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.Assert;

/**
 * Created by joselitowilliamraymundo on 3/10/18.
 */
public class DarkSkySD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();


    @Given("^I am on homepage of DarkSky$")
    public void iAmOnDarkSkyHomePage() {

        Assert.assertEquals(darkSkyHomePage.getDriver().getTitle(), "Dark Sky - 260 Broadway, New York City, NY", "Wrong HomePage");

    }

    @When("^I scroll to days of the week$")
    public void scrollToDaysOfWeek() {

        darkSkyHomePage.scrollToDays();
    }

    @Then("^I verify days of the week is displayed correctly$")
    public void verifyCorrectOrderOfDays() {
        Assert.assertEquals(darkSkyHomePage.actualDaysArrangement(),darkSkyHomePage.expectedDaysArrangement(),"Not Equal");
    }

    @When("^I click on todays bar$")
    public void clickOnTdaysBar(){
        darkSkyHomePage.clickOnTodaysBar();
    }

    @Then("^I verify low and high temp displayed correctly on parent bar$")
    public void verifyLowHighTemp(){
        Assert.assertEquals(darkSkyHomePage.parentTemp(),darkSkyHomePage.childTemp(),"Not Equal");
    }

    @When("^I click on Time Machine$")
    public void clickOnTimeMachine(){
        darkSkyHomePage.clickOnTimeMachine();
    }

    @When("^I select tomorrow's date$")
    public void selectTomorrowsDate() throws InterruptedException {
        darkSkyHomePage.selectTomorrowsDate();
    }

    @Then("^I verify selected date is not clickable$")
    public void verifyDateNotClickable(){
        Assert.assertEquals(darkSkyHomePage.selectedDateNotClickable(),true,"Date is CLICKABLE");
    }
    @And("^I verify date is displayed in correct format$")
    public void verifyCorrectDisplay(){
        Assert.assertEquals(darkSkyHomePage.actualDateDisplay(),darkSkyHomePage.expectedDateDisplay,"Incorrect Display of Date");
        System.out.println("Actual Date Display "+darkSkyHomePage.actualDateDisplay());
        System.out.println("Expected Date Display "+darkSkyHomePage.expectedDateDisplay);
    }
}
