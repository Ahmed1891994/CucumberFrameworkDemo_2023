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
	
	@Given("^User Clicks on link \"(.*)\"$")
	 public void User_Clicks_On_Link(String link){
		homepage = new HomePage(getDriver());
		homepage.EnterToLinkByText(link);
		loginpage = new LoginPage(getDriver());
	 }
	 @When("^User Enters username \"(.*)\"$")
	 public void User_Enters_Username(String username){	 
		 loginpage.EnterUsername(username);
	 }
	 @When("^User Enters password \"(.*)\"$")
	 public void User_Enters_Password(String password){
		 loginpage.EnterPassword(password);
	 }
	 @When("^User Clicks on Login$")
	 public void User_Clicks_on_Login(){
		 loginpage.ClickOnLogin();
	 }
	 @When("^User Clicks logout button$")
	 public void User_Clicks_logout_button(){
		 secureareapage = new SecureAreaPage(getDriver());
		 secureareapage.Logout();
	 }
	 @Then("^Verify alert message \"(.*)\" appears$")
	 public void Verify_Alert_Message(String message){
		 secureareapage = new SecureAreaPage(getDriver());
		 assertTrue(secureareapage.GetAlertText().contains(message));
	 }
}
