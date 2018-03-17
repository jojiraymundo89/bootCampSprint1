package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by joselitowilliamraymundo on 3/10/18.
 */
public class DarkSkyHomePage extends BasePage {

    public By eightDay = By.xpath("//*[@data-day='7']");

    public By darkSkyDays = By.className("name");

    public By parentBar = By.xpath("//*/div[@id='week']/a");

    public By timeMachine = By.xpath("//*[@id='timeMachine']/div[2]/a");

    public By month = By.xpath("//select[@class='pika-select pika-select-month']");

    public By year = By.xpath("//select[@class='pika-select pika-select-year']");

    public By forward = By.className("pika-next");

    public By days = By.xpath("//div[@class='pika-lendar']/*/tbody/tr/td");

    public By dateTomorrow = By.xpath("//div[@class='date']");

    public By actualDateDisplay = By.xpath("//*[@id='main']/div[1]/div[1]/div");

    public String expectedDateDisplay = null;

    public By parentMinTemp = By.xpath("//html//a/span[2]/span[1]");

    public By parentMaxTemp = By.xpath("//html//a/span[2]/span[3]");

    public By childMinTemp = By.xpath("//*[@id='week']/div/div[1]/div[2]/div[1]/span[1]/span[1]");

    public By childMaxTemp = By.xpath("//*[@id='week']/div/div[1]/div[2]/div[1]/span[3]/span[1]");




    public List expectedDaysArrangement() {
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        Calendar calendar = Calendar.getInstance();
        int indexNextDay = calendar.get(Calendar.DAY_OF_WEEK);
        List<String> expectedDaysArrangement = new ArrayList<>();
        expectedDaysArrangement.add("Today");
        for (int i = 0; i < days.length; i++) {
            if (indexNextDay == 7) {
                indexNextDay = 0;
            }
            expectedDaysArrangement.add(days[indexNextDay]);
            indexNextDay++;
        }
        System.out.println("Expected " + expectedDaysArrangement);
        return expectedDaysArrangement;
    }

    public List actualDaysArrangement() {
        List<String> actualDaysArrangement = new ArrayList<>();
        List<WebElement> list = getDriver().findElements(darkSkyDays);
        for (WebElement element : list) {
            actualDaysArrangement.add(element.getText());
        }
        System.out.println("Actual " + actualDaysArrangement);
        return actualDaysArrangement;
    }

    public void scrollToDays() {
        scrollToElement(eightDay);
    }

    public void clickOnTodaysBar() throws InterruptedException {
        scrollToElement(eightDay);
        List<WebElement> elements =getDriver().findElements(parentBar);
        for (WebElement element:elements){
            element.click();
        }
    }

    public boolean lowToHighTempDisplayedOnMotherAndChild() {
        List<WebElement> parentMin =getDriver().findElements(parentMinTemp);
        List<WebElement> parentMax =getDriver().findElements(parentMaxTemp);
        List<WebElement> childMin =getDriver().findElements(childMinTemp);
        List<WebElement> childMax =getDriver().findElements(childMaxTemp);
        boolean validated = false;
        List<String> pL = new ArrayList<>();
        List<String> pH = new ArrayList<>();
        List<String> cL = new ArrayList<>();
        List<String> cH = new ArrayList<>();

        for(int i=0;i<parentMin.size();i++){
            if (parentMin.get(i).getText().equals(childMin.get(i).getText()) &&
                     parentMax.get(i).getText().equals(childMax.get(i).getText()) &&
                     Integer.parseInt(parentMin.get(i).getText().replaceAll("[^a-zA-Z0-9]+",""))
                             <=Integer.parseInt(parentMax.get(i).getText().replaceAll("[^a-zA-Z0-9]+",""))){
                     validated = true;
            }
            System.out.println(Integer.parseInt(parentMin.get(i).getText().replaceAll("[^a-zA-Z0-9]+",""))+" <= "+Integer.parseInt(parentMax.get(i).getText().replaceAll("[^a-zA-Z0-9]+","")));
            /*pL.add(parentMin.get(i).getText());
            pH.add(parentMax.get(i).getText());
            cL.add(childMin.get(i).getText());
            cH.add(childMax.get(i).getText());*/
        }
        /*System.out.println(pL);
        System.out.println(cL);
        System.out.println(pH);
        System.out.println(cH);
        if (validated){
            System.out.println("true");
        };*/
        return validated;
    }

    public void clickOnTimeMachine() {
        scrollToElement(timeMachine);
        clickOn(timeMachine);
    }

    public void selectTomorrowsDate() throws InterruptedException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,1);
        Date tomorrow = calendar.getTime();
        String stringTomorrow = stringDate(tomorrow,"d-MMMM yyyy");
        String[] dateArray = stringTomorrow.split("-");
        String day = dateArray[0];
        String monthYear = dateArray[1];
        String MMMMyyyy = getSelectedOption(month, "text") + " " + getSelectedOption(year, "text");

        while (!monthYear.equals(MMMMyyyy)) {
            navigate(forward);
            MMMMyyyy = getSelectedOption(month, "text") + " " + getSelectedOption(year, "text");
        }
        selectElemFromList(days, day);
        Thread.sleep(1500);

        String ordinalSuffix = getOrdinalSuffix(Integer.parseInt(day));
        DateFormat dateFormat = new SimpleDateFormat("EEEE, MMM d'" + ordinalSuffix + "', yyyy");
        expectedDateDisplay = dateFormat.format(tomorrow);
    }

    public boolean selectedDateNotClickable() {
        String beforeClick = getDriver().getPageSource(); //PAGE SOURCE has to be compared   //
        boolean clickable = isClickable(dateTomorrow);    //before and after a click in order//
        String afterClick = getDriver().getPageSource(); //to know if its clickable or not  //
        if (beforeClick.equals(afterClick)) {
            System.out.println("");
            System.out.println("If what it meant by 'NOT CLICKABLE' is that there will be NO CHANGE in the UI after the click,");
            System.out.println("then the 'SELECTED DATE IS NOT CLICKABLE' but in order to compare if the UI changes after a 'click',");
            System.out.println("then the DATE has to be clicked, and has yielded a value of 'TRUE' hence the 'DATE IS CLICKABLE' but no action was made");
            System.out.println("and the UI remained exactly as it was before the click. The test was done by comparing the PAGE SOURCE before and after the click.");
        }
        return clickable;
    }

    public String actualDateDisplay() {
        return getTextFromElement(actualDateDisplay);
    }

    public String getOrdinalSuffix(int number) {
        if (number >= 11 && number <= 13) {
            return "th";
        }
        switch (number % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }

    }

}
