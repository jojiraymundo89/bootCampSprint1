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
  "duration": 5152420283,
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
  "duration": 858855971,
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
  "duration": 1905138990,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyLowHighTemp()"
});
formatter.result({
  "duration": 2313406219,
  "status": "passed"
});
formatter.after({
  "duration": 60583574,
  "status": "passed"
});
});