package com.valtechassessment.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Created by s.mylavarapu on 24/11/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        format = { "pretty", "html:target/CucumberHTMLReport", "json:target/Cucumber.json" },
        features={"src/test/resources/features/ValtechAssessment.feature"},
        glue = "com.valtechassessment.stepdefinitions"
)
public class GenericRunner {
}
