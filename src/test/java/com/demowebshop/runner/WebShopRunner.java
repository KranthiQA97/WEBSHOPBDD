package com.demowebshop.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "Features/" }, 
		glue = {"com.demowebshop.definitions" }, 
		dryRun = false, 
		monochrome = true, 
		plugin = { "pretty",
				"html:target/Reports/HTMLReport.html", 
				"junit:target/Reports/XMLReport.xml",
				"json:target/Reports/JSONReport.json"
		},
		tags = "@smoke")
public class WebShopRunner {

}
