package com.demowebshop.hooks;

import com.webshop.drivermanager.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	


		@Before
		public void Before(Scenario scenario) {
			System.out.println("****************** Scenario "+scenario.getName()+"  is Started *******************");
		}

		@After
		public void After(Scenario scenario) {

			BaseClass.tearDriver();
			System.out.println("****************** Scenario "+scenario.getName()+"  is Ended *******************");
		}

	

}
