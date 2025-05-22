package mouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class rightClick {
	
	WebDriver driver;
	
	@BeforeSuite
	public void initializeDriver() {
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void rightClickExample() {
		WebElement rightClickMe = driver.findElement(By.xpath("//p/span[contains(@class, 'btn btn-neutral')]"));
		Actions action = new Actions(driver);
		//action.moveToElement(rightClickMe).contextClick().build().perform();
		//action.contextClick(rightClickMe).build().perform();
		action.contextClick(rightClickMe).perform();
		
		WebElement copy = driver.findElement(By.xpath("//span[text()='Copy']"));
		copy.click();
		driver.switchTo().alert().accept();
	}
	
	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}
	
}
