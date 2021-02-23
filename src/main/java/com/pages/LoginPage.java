package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	
	//1. By locator
	private By email = By.id("email");
	private By password = By.id("passwd");
	private By signin = By.id("SubmitLogin");
	private By forgotpwdlink = By.linkText("Forgot your password?");
	
	//2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//eleutil = new ElementUtil(driver);
	}
	
	//3. page actions: features(hehaviour) of the page the form of the method
	
	public String getLoginPageTitles() {
		return driver.getTitle();
	}
	
	public boolean isforgotPwdLinkExist() {
		return driver.findElement(forgotpwdlink).isDisplayed();
	}
	
	public void enteruseremail(String useremail) {
		driver.findElement(email).sendKeys(useremail);
	}
	
	public void enterpwd(String Pwd) {
		driver.findElement(password).sendKeys(Pwd);
	}
	
	public void doclick() {
		driver.findElement(signin).click();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("Usrer name :"+un+ "and pawd :"+pwd);
		driver.findElement(email).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signin).click();
		return new AccountsPage(driver);
	}

}
