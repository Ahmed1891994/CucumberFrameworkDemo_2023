package cucumberOptions;

import java.util.Objects;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ConfigReader;

@CucumberOptions(features={"src/test/resources/features"},glue ={"stepDefinitions"}
,monochrome=true,
plugin= {"pretty", "html:target/cucumber.html", "json:target/cucumber-report.json"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	@BeforeTest
	@Parameters("browser")
	public void defineBrowser(@Optional String browser)
	{
		ConfigReader.setBrowserType(browser);
		if(Objects.isNull(ConfigReader.getBrowserType()))
			ConfigReader.setBrowserType("Chrome");
	}
	
	
}
