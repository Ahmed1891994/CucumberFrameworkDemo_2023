package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;		
import io.cucumber.java.en.When;
import pages.HoverPage;
import pages.ProfilePage;
import pages.TestBase;	

public class HoverStepDefinition extends TestBase{
	HoverPage hoverpage;
	ProfilePage profilepage;
	
	@When("User Hovers on Image number {int}")
	 public void User_Hovers_on_Image(int index){
		hoverpage = new HoverPage(getDriver());
		hoverpage.HoverImgIndex(index);
	 }
	 @When("User Enters Profile number {int}")
	 public void User_Enters_Profile(int index){	 
		 hoverpage.EnterOnProfile(index);
	 }
	 @Then("Verify message {string} appears")
	 public void Verify_Alert_Message(String message){
		 profilepage = new ProfilePage(getDriver());
	     Assert.assertEquals(profilepage.GetProfileText(), message);
	 }
}
