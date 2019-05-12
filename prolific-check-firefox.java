package com.blog.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloWorldFirefox {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "'path to gecko driver'");
		
		//Create a new instance for the class FirefoxDriver
		WebDriver driver = new FirefoxDriver();
		
		//Assign the URL to be invoked to a string variable
		String baseURL = "https://app.prolific.ac";
		String pageTitle = "";
		String expectedTitle = "Prolific";
		
		//Open baseURL in Firefox browser window
		driver.get(baseURL);
		//driver.navigate().to(baseURL); //does the same as the above
		
		//Log in to the website
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement button = driver.findElement(By.className("button"));
		email.sendKeys("your.email.@email.com");
		password.sendKeys("*********");
		button.click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.textToBePresentInElement(By.className("list-item"), "text");
		
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
			
		//Close the Firefox browser
		//driver.quit();
	    
	}
	
}
