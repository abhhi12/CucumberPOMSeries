package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By accountSection = By.cssSelector("div #center_column span");
	
	public AccountsPage(WebDriver driver) {
		 this.driver = driver;
	 }
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	public String nextgetAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountsSectionCount() {
		return driver.findElements(accountSection).size();
	}
	
	public List<String> getAccountsSectionList() {
		List<String> headerlist = new ArrayList<>();
		List<WebElement> AccountsHeaderList=driver.findElements(accountSection);
		
		for(WebElement e: AccountsHeaderList) {
			String list=e.getText();
			headerlist.add(list);
		}
		return headerlist;
	}

}
