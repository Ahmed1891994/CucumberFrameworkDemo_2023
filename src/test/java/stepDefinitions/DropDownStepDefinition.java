package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DropDownPage;
import pages.HomePage;
import pages.TestBase;	

public class DropDownStepDefinition extends TestBase{
	
	HomePage homepage;
	DropDownPage dropdownpage;
	
	@When("^User Chooses Item by index \"(.*)\"$")
	 public void User_Chooses_Item_by_index(int index){
		dropdownpage = new DropDownPage(getDriver());
		dropdownpage.ChooseItem(index);
	 }
	
	@When("^User Chooses Item by txt \"(.*)\"$")
	 public void User_Chooses_Item_by_txt(String text){
		dropdownpage = new DropDownPage(getDriver());
		dropdownpage.ChooseItem(text);
	 }
	 @When("^Verify Item chosen is the right choice for index \"(.*)\"$")
	 public void Verify_Item_chosen_by_index_is_the_right_choice(int index){	 
		 Assert.assertEquals(dropdownpage.GetSelectedItem(), dropdownpage.GetComparableText(index));
	 }
	 
	 @Then("^Verify Item chosen is the right choice for txt \"(.*)\"$")
	 public void Verify_Item_chosen_by_txt_is_the_right_choice(String text){	 
		 Assert.assertEquals(dropdownpage.GetSelectedItem(), dropdownpage.GetComparableText(text));
	 }
	 
	 @When("^User Refreshes Page$")
	 public void User_Refreshes_Page(){	 
		 dropdownpage.reloadPage();
	 }
	 
	 @Then("^Verify No Item is chosen$")
	 public void Verify_No_Item_is_chosen(){	 
		 Assert.assertEquals(dropdownpage.GetSelectedItem(), "Please select an option");
	 }
}
