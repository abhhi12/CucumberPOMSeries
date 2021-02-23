package StepDfinations;

import java.util.List;
import java.util.Map;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class AccountsPageStepDefinition {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountspage;
	
	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credtable) {
		List<Map<String,String>> credList=credtable.asMaps();
	    String un=credList.get(0).get("username");
	    String pwd=credList.get(0).get("password");
	    
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    accountspage = loginpage.doLogin(un, pwd);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title=accountspage.getAccountsPageTitle();
		System.out.println("Accounts Page Title is :" +title);
	}

	@Given("user is on nextAccounts Page")
	public void user_is_on_nextaccounts_page() {
	    String titles=accountspage.nextgetAccountsPageTitle();
	System.out.println("Accounts Page Title is :" +titles);
	}

	@Then("user gets account section")
	public void user_gets_account_section(io.cucumber.datatable.DataTable sectionsTable) {
		List<String> expectAccountSectionList=sectionsTable.asList();
		System.out.println("Expected Account Section List :" +expectAccountSectionList);
		
		List<String> AcctualAccountSectionList=accountspage.getAccountsSectionList();
		System.out.println("Acctual Account Section List :" +AcctualAccountSectionList);
		Assert.assertTrue(expectAccountSectionList.containsAll(AcctualAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer ExpectedAccountSectionCount) {
		Assert.assertTrue(accountspage.getAccountsSectionCount()==ExpectedAccountSectionCount);
	}

	
	
}