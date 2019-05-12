package com.blog.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class HeadlessTest {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "'path to gecko driver'");
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		
		WebDriver driver = new ChromeDriver(options);
		
		String baseURL = "https://app.prolific.ac";
		String pageTitle = "";
		String expectedTitle = "Prolific";
		
		driver.get(baseURL);
		
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement button = driver.findElement(By.className("button"));
		email.sendKeys("your.email.@email.com");
		password.sendKeys("*********");
		button.click();
		
		//Get the page title and assign to string variable
		pageTitle = driver.getTitle();
		
		/* Check if obtained page title matches with the expected
		 * title and print the console output accordingly
		 */
		if (pageTitle.equals(expectedTitle)) {
			System.out.println("Hello World! Result is as expected.");
		} else {
			System.out.println("Hello World! Assertion failed!");
		}
		
		//Check to see if there's a list item or not
	    try {
	        while (true) {
	        	Boolean isPresent = driver.findElements(By.className("list")).size() > 0;
	    		if (isPresent == true) {
	    			System.out.println("there's a survey");
	    			String surveyTitle = "";
	    			//surveyTitle = driver.findElement(By.xpath(""));
	    		} else {
	    			System.out.println("it's empty");
	    		}
	            Thread.sleep(10 * 1000);
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

		driver.quit();
	}
}
