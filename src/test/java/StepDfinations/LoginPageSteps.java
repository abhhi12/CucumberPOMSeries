package StepDfinations;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String pagetitle;
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		pagetitle = loginpage.getLoginPageTitles();
		System.out.println("Title of the page is =" +pagetitle);
		
	   
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(pagetitle.contains(expectedTitleName));
	    
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginpage.isforgotPwdLinkExist());
	    
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginpage.enteruseremail(username);
	  
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginpage.enterpwd(pwd);
	    
	}
	@When("user clicks on login button")
	public void And_user_clicks_on_login_button() {
		loginpage.doclick();
	}

}
