package framework;

import org.openqa.selenium.By;
import java.util.Calendar;
import java.util.Date;


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

    private By destinationBox = By.id("qf-0q-destination");

    private By results = By.xpath("//table[@cellspacing='0']/tbody/tr/td/div[2]");

    private By resultPanel = By.xpath("/html/body/div[5]");

    private By close = By.xpath("//*[@id=\"main-content\"]/main/div[2]/div/div[1]/div/div[1]/div[1]/div/div/h1");

    private By numNights = By.className("widget-query-num-nights");

    private By editAddRoom = By.xpath("//*[@id=\"main-content\"]/main/div[2]/div/div[1]/div/div[1]/div[1]/div/div/form/div[4]/button");

    private By moreOptionsBtn = By.id("qf-0q-compact-occupancy");

    private By numRooms = By.id("qf-0q-rooms");

    private By numAdults = By.id("qf-0q-room-0-adults");

    private By numChildren = By.id("qf-0q-room-0-children");

    private By ageChild1 = By.id("qf-0q-room-0-child-0-age");

    private By ageChild2 = By.id("qf-0q-room-0-child-1-age");

    private By searchBtn = By.xpath("//button[@type='submit']");

    private By destinationDisplay = By.xpath("//*[@id='search']/div[1]/div/h1");

    private By datesDisplay =  By.xpath("//*[@id='search']/div[1]/div/div[1]/span[1]");

    private By nightsDisplay = By.xpath("//*[@id='search']/div[1]/div/div[1]/span[2]");

    private By otherDetails = By.xpath("//*[@id='search']/div[1]/div/div[1]/span[3]");

    private By overLaySearchBtn = By.xpath("/html/body/div[12]/div[2]/button");

    public String days = null;

    String room = "room";

    String destination = null;

    String adult = "adult";

    String child = "child";

    String inclusiveDates = null;

    String numberOfNights = null;

    String roomAndOccupants = null;

    public void clickOnDestinationBox() throws InterruptedException {

        /*try {
            if (isEnabled(overlay)){
                clickOn(closeOverlay);
            }
        }catch (NoSuchElementException e){
            clickOn(searchKey);
        }*/
    }

    public void enterSearchKey(String value) throws InterruptedException {
        setValueToInputField(destinationBox, value);
        Thread.sleep(1000);
    }

    public void enterFinalDestination(String value) throws InterruptedException {

        searchString(results, value);
        clickOn(close);
    }

    public void selectTomorrowsDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,1);
        Date checkIn = calendar.getTime();
        String day = stringDate(checkIn,"d");
        clickOn(dateBox);
        selectElemFromList(daysLeftSide, day);
        inclusiveDates = stringDate(checkIn,"EEE d - ");
    }

    public void selectCheckOutDate(int n) {
        n++;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,n);
        Date checkOut = calendar.getTime();
        String day = stringDate(checkOut,"d");
        clickOn(dateBox2);
        selectElemFromList(daysLeftSide, day);
        inclusiveDates = inclusiveDates+(stringDate(checkOut,"EEE d MMMM yyyy"));
        days = Integer.toString(n-1);
    }

    public String numberOfNightsDisplayed() {
        return getTextFromElement(numNights);
    }

    public void selectOption() {
        selectFromDropDown(moreOptionsBtn, 2);
    }

    public void enterOtherOptions() {
        selectFromDropDown(numRooms, 0);
        selectFromDropDown(numAdults, 1);
        selectFromDropDown(numChildren, 2);
        selectFromDropDown(ageChild1, 4);
        selectFromDropDown(ageChild2, 5);
        if (Integer.parseInt(getSelectedOption(numRooms))>1){
            room = "rooms";
        }
        if (Integer.parseInt(getSelectedOption(numAdults))>1){
            adult = "adults";
        }
        if (Integer.parseInt(getSelectedOption(numChildren))>1){
            child = "children";
        }
        roomAndOccupants =getSelectedOption(numRooms)+" "+room+", "+ getSelectedOption(numAdults)+" "+adult+", "+getSelectedOption(numChildren)+" "+child;

    }

    public void clickOnSearchBtn() {

        destination = getAttribute(destinationBox,"value");
        numberOfNights = getTextFromElement(numNights)+" nights";
        clickOn(searchBtn);
        System.out.println(inclusiveDates);
        System.out.println(getTextFromElement(datesDisplay));
        System.out.println(getTextFromElement(nightsDisplay));
        System.out.println(numberOfNights);
        System.out.println(getTextFromElement(otherDetails));
        System.out.println(roomAndOccupants);
        System.out.println(destination);
        System.out.println(getTextFromElement(destinationDisplay));

    }

    public boolean selectionDisplayedCorrectly(){
        boolean correctDisplay = false;
        if (getTextFromElement(destinationDisplay).equals(destination) && getTextFromElement(datesDisplay).equals(inclusiveDates)
                && getTextFromElement(nightsDisplay).equals(numberOfNights) && getTextFromElement(otherDetails).equals(roomAndOccupants)){
            correctDisplay = true;
        }
    return correctDisplay;
    }
}