$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darkSky.feature");
formatter.feature({
  "line": 2,
  "name": "Verify different display on DarkSky",
  "description": "",
  "id": "verify-different-display-on-darksky",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@darkSky"
    }
  ]
});
formatter.before({
  "duration": 4507945428,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on homepage of DarkSky",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.iAmOnDarkSkyHomePage()"
});
formatter.result({
  "duration": 553835256,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Verify days of the week are displayed correctly",
  "description": "",
  "id": "verify-different-display-on-darksky;verify-days-of-the-week-are-displayed-correctly",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@darkSky-1"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I scroll to days of the week",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify days of the week is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.scrollToDaysOfWeek()"
});
formatter.result({
  "duration": 210425353,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyCorrectOrderOfDays()"
});
formatter.result({
  "duration": 281461603,
  "status": "passed"
});
formatter.after({
  "duration": 114449410,
  "status": "passed"
});
formatter.before({
  "duration": 2681319049,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on homepage of DarkSky",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.iAmOnDarkSkyHomePage()"
});
formatter.result({
  "duration": 12788116,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verify low and high temp displayed correctly on parent bar",
  "description": "",
  "id": "verify-different-display-on-darksky;verify-low-and-high-temp-displayed-correctly-on-parent-bar",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@darkSky-2"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "I click on todays bar",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I verify low and high temp displayed correctly on parent bar",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.clickOnTdaysBar()"
});
formatter.result({
  "duration": 474340615,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyLowHighTemp()"
});
formatter.result({
  "duration": 408941553,
  "status": "passed"
});
formatter.after({
  "duration": 110124748,
  "status": "passed"
});
formatter.before({
  "duration": 2724539127,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on homepage of DarkSky",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.iAmOnDarkSkyHomePage()"
});
formatter.result({
  "duration": 18599537,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Verify selected tomorrow\u0027s date not clickable",
  "description": "",
  "id": "verify-different-display-on-darksky;verify-selected-tomorrow\u0027s-date-not-clickable",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@darkSky-3"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "I click on Time Machine",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I select tomorrow\u0027s date",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I verify selected date is not clickable",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "I verify date is displayed in correct format",
  "keyword": "And "
});
formatter.match({
  "location": "DarkSkySD.clickOnTimeMachine()"
});
formatter.result({
  "duration": 261394836,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.selectTomorrowsDate()"
});
formatter.result({
  "duration": 2768127511,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyDateNotClickable()"
});
formatter.result({
  "duration": 164459885,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyCorrectDisplay()"
});
formatter.result({
  "duration": 50531033,
  "status": "passed"
});
formatter.after({
  "duration": 108973283,
  "status": "passed"
});
});