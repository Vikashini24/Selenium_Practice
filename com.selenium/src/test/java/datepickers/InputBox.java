package datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class InputBox {
	
	WebDriver driver;
	
	@BeforeSuite
	public void initializeDriver() {
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	public void sendKeys() {
		//switch to frame
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
	}
	
//	@Test (priority=2)
//	public void methodOne() {
//		driver.findElement(By.id("datepicker")).sendKeys("09/24/1997" + Keys.ENTER);
//	}
	
	@Test (priority=3)
	public void methodTwo() {
		driver.findElement(By.id("datepicker")).click();
		//Select month & year
		while(true) {
			String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			System.out.println(currentMonth);
			String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();
			System.out.println(currentYear);
			
			
		}
	}
	
}
