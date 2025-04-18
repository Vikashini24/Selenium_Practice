package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BlazeDemo {
	
	WebDriver driver;
	Select dropdown;
	
	@BeforeSuite
	public void initializeDriver() {
		if(driver==null) {
			driver = new ChromeDriver();
			driver.get("https://blazedemo.com/");
			driver.manage().window().maximize();
		}
	}
	
	@Test (priority=1)
	public void chooseDepartureCity() {
		WebElement departureCity = driver.findElement(By.name("fromPort"));
		dropdown = new Select(departureCity);
		dropdown.selectByValue("Boston");
		System.out.println("Departure city: " + dropdown.getFirstSelectedOption().getText());
	}
	
	@Test (priority=2)
	public void chooseDestinationCity() {
		WebElement destinationCity = driver.findElement(By.name("toPort"));
		dropdown = new Select(destinationCity);
		dropdown.selectByValue("London");
		System.out.println("Destination city: " + dropdown.getFirstSelectedOption().getText());
	}
	
	@Test (priority=3)
	public void findFlights() {
		WebElement findFlight = driver.findElement(By.xpath("//input[@value='Find Flights']"));
		findFlight.click();
	}
	
	public void prices() {
		int rowSize = driver.findElements(By.xpath("//table[@class='table']//tr/td")).size();
		 System.out.println(rowSize);
		 for(int r=2; r<=rowSize; r++) {
			  driver.findElement(By.xpath("//table[@class='table']//tr/td[6]"));
		 }
	}
	
	
}
