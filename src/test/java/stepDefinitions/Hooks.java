package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.TestBase;
import utils.MyLogger;


public class Hooks{
	TestBase testBase = new TestBase();
	
	@Before
	public void BeforeScenario(Scenario scenario) throws IOException
	{
		String browser = System.getProperty("browser", "Chrome");
		MyLogger.startTestCase(scenario);	
		testBase.InitializeEnvironment(browser);
	}
	
	@After
	public void AfterScenario(Scenario scenario) throws IOException
	{
		if (scenario.isFailed()) {
            MyLogger.error("Test Failed");
            MyLogger.error("Take Screen shot");
            testBase.getDriverActions().takeScreenShot(scenario.getName(),testBase.getDriver());
        } else {
            MyLogger.info("Test Passed");
        }
        MyLogger.endTestCase(scenario);
		testBase.teardown();		
	}	
}
