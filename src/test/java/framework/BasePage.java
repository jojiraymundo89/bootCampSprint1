package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import stepdefinition.SharedSD;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class BasePage {

    public static WebDriver getDriver() {
        return SharedSD.getDriver();
    }

    public static WebElement webDriverFluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotFoundException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    public static void doubleClick(By locator){
        Actions action = new Actions(getDriver());
        WebElement element = getDriver().findElement(locator);
        action.doubleClick(element).perform();
    }


    public static void pageLoadWait() {
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public static void clickWhenClikable(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static boolean isClickable(By locator)
    {
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            clickOn(locator);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public static boolean isClickable(WebElement el, WebDriver driver)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public static void clickOnFluentWait(By locator) {
        webDriverFluentWait(locator).click();
    }

    public static void clickOn(By locator) {
        try {
            getDriver().findElement(locator).click();
        } catch (NoSuchElementException e) {
            Assert.fail("No Element found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public String getSelectedOption(By locator, String attribute) {
        Select option = new Select(getDriver().findElement(locator));
        WebElement element = option.getFirstSelectedOption();
        String choice = element.getText();
        choice = element.getAttribute(attribute);
        return choice;
    }

    public String getSelectedOption(By locator){
        Select option = new Select(getDriver().findElement(locator));
        WebElement element = option.getFirstSelectedOption();
        String choice = element.getText();
        return choice;
    }

    public String getTextFromElement(By locator) {
        String text = null;
        try {
            text = getDriver().findElement(locator).getText();
        } catch (NoSuchElementException e) {
            Assert.fail("No Element found with this locator: " + locator.toString());
            e.printStackTrace();
        }
        return text;
    }

    public static boolean isDisplayed(By locator) {
        return getDriver().findElement(locator).isDisplayed();
    }

    public boolean isEnabled(By locator) {
        return getDriver().findElement(locator).isEnabled();
    }

    public boolean isSelected(By locator) {
        return getDriver().findElement(locator).isSelected();
    }

    public void setValueToInputField(By locator, String value) {
        try {
            getDriver().findElement(locator).sendKeys(value);
        } catch (NoSuchElementException e) {
            Assert.fail("No Element found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public String getAttribute(By locator, String value) {
        WebElement y = getDriver().findElement(locator);
        String x = y.getAttribute(value);
        return x;
    }

    public void selectFromDropDown(By locator, String month) {
        Select monthDropDown = new Select(getDriver().findElement(locator));
        monthDropDown.selectByVisibleText(month);
    }

    public void selectFromDropDown(By locator, int index) {
        Select monthDropDown = new Select(getDriver().findElement(locator));
        monthDropDown.selectByIndex(index);
    }

    public static void switchToWindow(int index) {
        List<String> listOfWindows = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(listOfWindows.get(index));
    }

    public static void switchToRootWindowCloseCurrentBrowser() {
        List<String> listOfWindows = new ArrayList<String>(getDriver().getWindowHandles());
        for (int i = 1; i < listOfWindows.size(); i++) {
            getDriver().switchTo().window(listOfWindows.get(i));
            getDriver().close();
        }
        getDriver().switchTo().window(listOfWindows.get(0));
    }

    public void autoComplete(By locator, By locator2, String searchKey, String choice) throws InterruptedException {

        getDriver().findElement(locator).sendKeys(searchKey);
        List<WebElement> list = getDriver().findElements(locator2);
        for (WebElement element : list) {
            if (element.getText().contains(choice)) {
                element.click();
                break;
            }
        }
    }

    public void searchString(By locator, String value) {

            List<WebElement> list = getDriver().findElements(locator);
            for (WebElement element : list) {
                if (element.getText().contains(value)) {
                    element.click();
                    break;
                }
            }
        }


    public void spellOutString(By locator,String value) throws InterruptedException {
        String s = "";
        String newS = "";
        char[] charArray = value.toCharArray();
        int lengthOfString = charArray.length;
        for (int i = 0; i < lengthOfString; i++) {
            s = s.concat(Character.toString(charArray[i]));
            newS = s;
            s="";
            Thread.sleep(500);
            getDriver().findElement(locator).sendKeys(newS);
        }
    }

    public String slashDate(String hypenDate){
     return hypenDate.replace("-","/");
    }

    public String todayString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yy");
        Date date = new Date();
        String today = sdf.format(date);
        return today;
    }

    public Calendar calendar (){
        Calendar calendar = Calendar.getInstance();
    return calendar;
    }

    public Calendar calendarDate (int year, int month, int datE){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,datE);
        return calendar;
    }

    public Calendar calendarDate (int field, int value){
        Calendar calendar = Calendar.getInstance();
        calendar.set(field,value);
        return calendar;
    }

    public Calendar calendarDate (){
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }
    public String stringDate(Date datE,String pattern){
        datE.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateString = sdf.format(datE);
        return dateString;
    }
    public Date today(){
        Date date = new Date();
        return date;
    }

    public Date date(String string) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yy");
        Date date = sdf.parse(string);
        return date;
    }

    public Date stringToDate(String string) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date = sdf.parse(string);
        return date;
    }

    public String getAttFromList(By locator, String string, String attribute) {
        List<WebElement> list = getDriver().findElements(locator);
        String selected = null;
        for (WebElement element : list) {

            if (element.getText().equals(string)) {
                selected = element.getAttribute(attribute);
                element.click();
                break;
            }
        }
        return selected;
    }



    public boolean selectElemFromList2(By locator, String string) {
        List<WebElement> list = getDriver().findElements(locator);
        boolean selected = false;
        for (WebElement element : list) {
            if (element.isDisplayed()) {
                if (element.getText().equals(string)) {
                    selected = element.isSelected();
                    element.click();
                    break;
                }
            }
        }
        return selected;
    }

    public String selectElemFromList(By locator, String string) {
        List<WebElement> list = getDriver().findElements(locator);
        String selected = null;
        for (WebElement element : list) {
            if (element.getText().equals(string)) {
                selected = element.getText();
                element.click();
                break;
            }
        }
        return selected;
    }

    public WebElement selectWebElemFromList(By locator, String string) {
        List<WebElement> list = getDriver().findElements(locator);
        WebElement selected=null;
        for (WebElement element : list) {
            if (element.getText().equals(string)) {
                selected = element;
                element.click();
                break;
            }
        }
        return selected;
    }

    public static void hoverOver(By locator) {
        WebElement element = getDriver().findElement(locator);
        Actions action = new Actions(getDriver());
        action.moveToElement(element).build().perform();


    }

    public void pickOwnDateFromPicker(String inputDate, By dateInput, By calendarHeader, By nextButton, By dates) throws ParseException {
        SimpleDateFormat simpleDF = new SimpleDateFormat("MM-dd-yyyy");
        Date date = simpleDF.parse(inputDate);

        SimpleDateFormat sdfDay = new SimpleDateFormat("d");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        String day = sdfDay.format(date);
        String month = sdfMonth.format(date);
        String year = sdfYear.format(date);
        String monthAndYear = (month + " " + year);

        clickOn(dateInput);

        while (!getDriver().findElement(calendarHeader).getText().contains(monthAndYear)) {

            getDriver().findElement(nextButton).click();
        }


        List<WebElement> days = getDriver().findElements(dates);

        for (WebElement element : days) {
            String expectedDate = element.getText();
            if (expectedDate.equals("20")) {
                element.click();
                break;
            }
        }
    }

    public void scrollToElement(By locator){
        WebElement element = getDriver().findElement(locator);
        Actions actions = new Actions(getDriver()); actions.moveToElement(element);
        actions.perform();
    }



    public static void switchToFrame(String value) {
        getDriver().switchTo().frame(value);
    }

    public static void alertAccept() {
        getDriver().switchTo().alert().accept();
    }

    public static void alertDismiss() {
        getDriver().switchTo().alert().dismiss();
    }

    public static void alertGetText() {
        getDriver().switchTo().alert().getText();
    }

    public static void alertSendtext(String value) {
        getDriver().switchTo().alert().sendKeys(value);
    }

    public void clickOnBrowserBackArrow() {
        getDriver().navigate().back();
    }

    public void clickOnBrowserForwardArrow() {
        getDriver().navigate().forward();
    }

    public void refreshBrowser() {
        getDriver().navigate().refresh();
    }

    public void navigate(By locator) {
        getDriver().findElement(locator).click();
    }

    public void navigateBackward(By locator) {
        getDriver().findElement(locator).click();
    }
}



