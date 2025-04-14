package rahulshetty;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Flightbooking {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeSuite
	public void initializeDriver() {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}
	
	@Test (priority=1)
	public void country() throws InterruptedException {
		WebElement textbox = driver.findElement(By.id("autosuggest"));
		textbox.sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> countryLists = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for(WebElement countryList : countryLists) {
			String text = countryList.getText();
			if(text.equalsIgnoreCase("India")) {
				countryList.click();
				String value = textbox.getDomProperty("value");
				if(value.equals(text)) {
					System.out.println("Travel within India");
				}
				else {
					System.out.println("The flight is delayed");
				}
				break;
			}
		}
	}
	
	@Test (priority=2)
	public void trip() {
		WebElement roundTrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		roundTrip.click();
		System.out.println("It's a round trip");
	}
	
	@Test (priority=3)
	public void travelCities() {
		WebElement departureCityField = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		departureCityField.click();
		List<WebElement> departureCityLists = driver.findElements(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//li/a"));
		for(WebElement departureCityList : departureCityLists) {
			String departureCity = departureCityList.getText();
			if(departureCity.equalsIgnoreCase("Bengaluru (BLR)")) {
				departureCityList.click();
				break;
			}
		}
		
		List<WebElement> arrivalCityLists = driver.findElements(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//li/a"));
		for(WebElement arrivalCityList : arrivalCityLists) {
			String arrivalCity = arrivalCityList.getText();
			System.out.println(arrivalCity);
			if(arrivalCity.equalsIgnoreCase("Coimbatore (CJB)")) {
				arrivalCityList.click();
				break;
			}
		}
	}
	
}
