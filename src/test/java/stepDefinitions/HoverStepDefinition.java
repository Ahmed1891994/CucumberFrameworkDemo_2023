package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;		
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.HoverPage;
import pages.ProfilePage;
import pages.TestBase;	

public class HoverStepDefinition extends TestBase{
	
	HomePage homepage;
	HoverPage hoverpage;
	ProfilePage profilepage;
	
	@When("^User Hovers on Image number \"(.*)\"$")
	 public void User_Hovers_on_Image(int index){
		hoverpage = new HoverPage(getDriver());
		hoverpage.HoverImgIndex(index);
	 }
	 @When("^User Enters Profile number \"(.*)\"$")
	 public void User_Enters_Profile(int index){	 
		 hoverpage.EnterOnProfile(index);
	 }
	 @Then("^Verify message \"(.*)\" appears$")
	 public void Verify_Alert_Message(String message){
		 profilepage = new ProfilePage(getDriver());
	     Assert.assertEquals(profilepage.GetProfileText(), "Not Found");
	 }
}
