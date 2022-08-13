package com.juaracoding.posttest.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.juaracoding.posttest.drivers.DriverSingleton;
import com.juaracoding.posttest.pages.LoginPage;
import com.juaracoding.posttest.pages.RegisterPage;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
		
		delay(10);
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		LoginPage loginPage = new LoginPage();
		RegisterPage registerPage = new RegisterPage();
		
		registerPage.register("username99","test1@mail.com" ,"SssOoo*01");
		loginPage.login("username99", "SssOoo*01");
		
		delay(3);
		driver.quit();
		
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
