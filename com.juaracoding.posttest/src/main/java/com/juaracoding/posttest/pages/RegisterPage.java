package com.juaracoding.posttest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.posttest.drivers.DriverSingleton;

public class RegisterPage {
	
	private WebDriver driver;
	
	public RegisterPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")
	private WebElement accountLink;
	
	@FindBy(id = "reg_username")
	private WebElement username;
	
	@FindBy(id = "reg_email")
	private WebElement email;
	
	@FindBy(id = "reg_password")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[4]/button")
	private WebElement btnRegister;
	
	public void register(String username,String email ,String password) {
		this.accountLink.click();
		delay(3);
		this.username.sendKeys(username);
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.btnRegister.click();
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
