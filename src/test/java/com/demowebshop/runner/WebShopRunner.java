package com.demowebshop.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"Features/"},
		glue = {"com.demowebshop.definitions"},
		dryRun = false,
		monochrome = true,
		plugin = {
				"pretty",
				"html:target/Reports/HTMLReport.html",
				"junit:target/Reports/XMLReport.xml",
				"json:target/Reports/JSONReport.json",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		tags = "@smoke"
		)
public class WebShopRunner {

	
	@AfterClass
	public static void writeExtentReport() {
		
		Reporter.loadXMLConfig(new File("src/test/resources/Configurations/extent-config.xml"));
		//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		Reporter.setSystemInfo("User Name", "AJ");
		Reporter.setSystemInfo("Application Name", "Test App ");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
	
	
}
