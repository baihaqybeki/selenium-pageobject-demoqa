package com.juaracoding.posttest.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.juaracoding.posttest.drivers.strategies.DriverStategyImplementer;
import com.juaracoding.posttest.drivers.strategies.DriverStrategy;



public class DriverSingleton {
	private static DriverSingleton instance = null;
	private static WebDriver driver;
	
	private DriverSingleton(String driver) {
		instantiante(driver);
	}
	
	private WebDriver instantiante(String strategy) {
		DriverStrategy driverStrategy = DriverStategyImplementer.chooseStrategy(strategy);
		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static DriverSingleton getInstance(String driver) {
		if (instance==null) {
			instance = new DriverSingleton(driver);
		}
		
		return instance;
	}
	
	public static WebDriver getDriver() {
		return driver;

	}
}


