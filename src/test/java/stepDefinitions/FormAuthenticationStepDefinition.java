package stepDefinitions;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;		
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import pages.TestBase;	

public class FormAuthenticationStepDefinition extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	SecureAreaPage secureareapage;

	@Given("User in {string} page")
	public void userClicksOnLink(String link) {
		homepage = new HomePage(getDriver());
		homepage.EnterToLinkByText(link);
		loginpage = new LoginPage(getDriver());
	}
	 @When("User Login with {string} and {string}")
	 public void User_Login(String username,String password){
		 loginpage.EnterUsername(username);
		 loginpage.EnterPassword(password);
		 loginpage.ClickOnLogin();
	 }
	 @When("User Clicks logout button")
	 public void User_Clicks_logout_button(){
		 secureareapage = new SecureAreaPage(getDriver());
		 secureareapage.Logout();
	 }
	 @Then("Verify alert message {string} appears")
	 public void Verify_Alert_Message(String message){
		 secureareapage = new SecureAreaPage(getDriver());
		 assertTrue(secureareapage.GetAlertText().contains(message));
	 }
}
