package com.valtechassessment.stepdefinitions;

import base.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pageobjects.Homepage;

/**
 * Created by Sachin on 25/06/2017.
 */
public class ValtechAssesmentTest extends TestBase {

    private WebDriver driver;
    private Homepage homepage;
    private String acutalTextOfNewsSection;




    @Given("^I have launched valtech portal$")
    public void i_have_launched_valtech_portal() throws Throwable {

     driver = getDriver();

    }

    @Then("^I verify latest news section is displayed$")
    public void i_verify_latest_news_section_is_displayed() throws Throwable {
        homepage = new Homepage(driver);
        acutalTextOfNewsSection =homepage.locateLatestNewsHeaderText();
        SoftAssert softAssert  = new SoftAssert();
        softAssert.assertEquals(acutalTextOfNewsSection, "Latest News", "Expected and Actual do not match for latest news section");
    }

    @And("^I output different locations$")
    public void i_output_different_locations() throws Throwable {
        String locations = homepage.outputLocations();
        System.out.println("Locations text contains"+locations);
        String [] locationsArr = locations.split(":");
        String [] justLocs = locationsArr[1].split(",") ;
        for (int i =0; i<justLocs.length; i++)  {
            System.out.println("Locatin is "+justLocs[i]);
        }
    }
}
