package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AutomationTesting {
	
	WebDriver driver;
	
	@BeforeSuite
	public void initializeDriver() {
		if(driver==null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://testautomationpractice.blogspot.com/");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test (priority=1)
	public void textboxElements() {
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Kanniya");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kanniya.mailinator.com");
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("9876543210");
		WebElement address = driver.findElement(By.id("textarea"));
		address.sendKeys("Coimbatore");
	}
	
	@Test (priority=2)
	public void radioButton() {
		List<WebElement> gender = driver.findElements(By.xpath("//div[@class='form-group']/label[@for='gender']/following-sibling::div"));
		for (WebElement selectGender : gender) {
			String genderName = selectGender.getText();
			if(genderName.equals("Female")) {
				selectGender.click();
				break;
			}
		}
	}
	
	@Test (priority=3)
	public void checkboxes() {
		List<WebElement> days = driver.findElements(By.xpath("//div[@class='form-group']/label[@for='days']/following-sibling::div"));
		for(WebElement day : days) {
			String selectDay = day.getText();
			if(selectDay.equalsIgnoreCase("Wednesday")) {
				day.click();
				break;
			}
		}
	}
	
	@Test (priority=4)
	public void selectDropdown() {
		WebElement country = driver.findElement(By.id("country"));
		Select dropdown = new Select(country);
		dropdown.selectByVisibleText("United Kingdom");
	}
	
	@Test (priority=5)
	public void multiselectDropdown() {
		WebElement colors = driver.findElement(By.id("colors"));
		Select dropdown = new Select(colors);
		if(dropdown.isMultiple()) {
			//Select multiple options
			dropdown.selectByVisibleText("Red");
			dropdown.selectByValue("blue");
			dropdown.selectByValue("white");
			List<WebElement> colorsOption = dropdown.getAllSelectedOptions();
			for(WebElement color : colorsOption) {
				String getColor = color.getText();
				System.out.println("Selected colors: " + getColor);
			}
		}
		else {
			System.out.println("Not a multi-select dropdown");
		}
	}
	
	@Test (priority=6)
	public void datePicker1() {
		WebElement pickDate = driver.findElement(By.id("datepicker"));
		pickDate.sendKeys("09/24/1997" + Keys.ENTER);
		System.out.println("Date: " + pickDate.getAttribute("value"));
	}
	
	
	
	
	
	
	
//	@AfterSuite
//	public void driverDriver() {
//		if(driver!=null) {
//			driver.quit();
//		}
//	}
	
}
