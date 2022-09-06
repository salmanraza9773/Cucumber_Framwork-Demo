package com.telus.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		         
		         features = ".\\src\\test\\java\\com\\telus\\featurefile",
		         glue = "com.telus.stepdefinition",
		         stepNotifications = true,
		         dryRun = false,
		         plugin = {"pretty","html:target/cucumberreport.html"},
		         monochrome = true
		         
		         )

public class RunnerClass {

	
}
