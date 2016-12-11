package br.usp.icmc.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {

	private static WebDriver driver;

	public static WebDriver get() {
		if (driver == null) {

			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}
		return driver;
	}

}
