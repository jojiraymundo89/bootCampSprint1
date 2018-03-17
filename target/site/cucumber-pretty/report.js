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
  "duration": 8969087290,
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
  "duration": 1396691210,
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
  "duration": 918311492,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyCorrectOrderOfDays()"
});
formatter.result({
  "duration": 800144413,
  "status": "passed"
});
formatter.after({
  "duration": 155951868,
  "status": "passed"
});
formatter.before({
  "duration": 8264878735,
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
  "duration": 112045181,
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
  "duration": 4723028469,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyLowHighTemp()"
});
formatter.result({
  "duration": 6264305438,
  "status": "passed"
});
formatter.after({
  "duration": 121293566,
  "status": "passed"
});
formatter.before({
  "duration": 10170738581,
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
  "duration": 178996901,
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
  "duration": 2192001062,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.selectTomorrowsDate()"
});
formatter.result({
  "duration": 9154809590,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyDateNotClickable()"
});
formatter.result({
  "duration": 481262990,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyCorrectDisplay()"
});
formatter.result({
  "duration": 188872240,
  "status": "passed"
});
formatter.after({
  "duration": 676757155,
  "status": "passed"
});
});