package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinition.SharedSD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 * Created by joselitowilliamraymundo on 2/17/18.
 */
public class HotelsHomePage extends BasePage {

    private By dateBox = By.id("qf-0q-localised-check-in");

    private By dateBox2 = By.id("qf-0q-localised-check-out");

    private By daysLeftSide = By.xpath("//*[@class='widget-daterange-cont']/div[1]/div[2]/table/tbody/tr/td");

    private By overlay = By.id("managed-overlay");

    private By closeOverlay = By.xpath("//*[@id=\"managed-overlay\"]/button");

    private By closeButton = By.className("widget-overlay-close");

    public boolean selected = false;

    private By searchKey = By.id("qf-0q-destination");

    private By results = By.xpath("/html/body/div[5]/table/tbody/tr/td");

    private By resultPanel = By.xpath("/html/body/div[5]");

    private By close = By.xpath("//*[@id=\"main-content\"]/main/div[2]/div/div[1]/div/div[1]/div[1]/div/div/h1");

    private By numNights = By.className("widget-query-num-nights");

    private By editAddRoom = By.xpath("//*[@id=\"main-content\"]/main/div[2]/div/div[1]/div/div[1]/div[1]/div/div/form/div[4]/button");

    private By moreOptionsBtn = By.id("qf-0q-compact-occupancy");

    private By numRooms = By.id("qf-0q-rooms");

    private By numAdult = By.id("qf-0q-room-0-adults");

    private By numChildren = By.id("qf-0q-room-0-children");

    private By ageChild1 = By.id("qf-0q-room-0-child-0-age");

    private By ageChild2 = By.id("qf-0q-room-0-child-1-age");

    private By searchBtn = By.xpath("//button[@type='submit']");

    private By multiDesOverlay = By.xpath("/html/body/div[12]");

    private By radioBtn = By.xpath("/html/body/div[12]/div[1]/ul/li[6]/label/input");

    private By overLaySearchBtn = By.xpath("/html/body/div[12]/div[2]/button");

    Calendar cal = Calendar.getInstance();


    public void clickOnDestinationBox() throws InterruptedException {

        if (getDriver().findElement(overlay) != null) {
            clickOn(closeOverlay);
        }
    }

    public void enterSearchKey(String value) throws InterruptedException {
        spellOutString(searchKey, value);
        Thread.sleep(4000);
    }

    public void enterFinalDestination(String value) throws InterruptedException {

        searchString(results, value);
        clickOn(close);
    }

    public void selectTomorrowsDate() {
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date dateTomorrow = cal.getTime();
        String stringTomorrow = stringDate(dateTomorrow);
        String[] dateArray = stringTomorrow.split("-");
        String day = dateArray[0];
        String monthYear = dateArray[1];
        clickOn(dateBox);
        selectElemFromList(daysLeftSide, day);
    }

    public void selectCheckOutDate() {
        cal.add(Calendar.DAY_OF_MONTH, 6);
        Date checkOut = cal.getTime();
        String stringCheckOut = stringDate(checkOut);
        String[] dateArray = stringCheckOut.split("-");
        String day = dateArray[0];
        String monthYear = dateArray[1];
        clickOn(dateBox2);
        selectElemFromList(daysLeftSide, day);
    }

    public String numberOfNightsDisplayed() {
        return getTextFromElement(numNights);
    }

    public void selectOption() {
        selectFromDropDown(moreOptionsBtn, 2);

    }

    public void enterOtherOptions() {
        selectFromDropDown(numRooms, 0);
        selectFromDropDown(numAdult, 1);
        selectFromDropDown(numChildren, 2);
        selectFromDropDown(ageChild1, 4);
        selectFromDropDown(ageChild2, 5);


    }

    public void clickOnSearchBtn() {
        clickOn(searchBtn);
    }
}