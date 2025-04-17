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

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class Flightbooking {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeSuite
	public void initializeDriver() {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	public void travelCities() throws InterruptedException {
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
		
		Thread.sleep(3000);
		List<WebElement> arrivalCityLists = driver.findElements(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//li/a"));
		for(WebElement arrivalCityList : arrivalCityLists) {
			String arrivalCity = arrivalCityList.getText();
			if(arrivalCity.equalsIgnoreCase("Coimbatore (CJB)")) {
				arrivalCityList.click();
				break;
			}
		}
	}
	
	@Test (priority=3)
	public void calender() {
		List<WebElement> months = driver.findElements(By.xpath("//div/span[@class='ui-datepicker-month']"));
			for(WebElement month : months) {
				String monthText = month.getText();
				if(monthText.equalsIgnoreCase("June")) {
					List<WebElement> days = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//td/a"));
					for(WebElement day : days) {
						if(day.getText().equals("24")) {
							day.click();
							break;
						}
					}
				}
			}
	}
	
	@Test (priority=4)
	public void passengers() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("divpaxinfo"));
		dropdown.click();
		int i;
		for(i=1; i<2; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			for(i=0; i<=2; i++) {
				driver.findElement(By.id("hrefIncChd")).click();
				for(i=0; i<=1; i++) {
					driver.findElement(By.id("hrefIncInf")).click();
				}
			}
		}
	}
	
	
	
	
	
}
