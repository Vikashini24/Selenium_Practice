package mouseEvents;

import java.time.Duration;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MouseHover {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeSuite
	public void initializeDriver() {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	@Test
	public void mouseHoverExample() {
		Actions action = new Actions(driver);
		//WebElement fashion = driver.findElement(By.xpath("//span[text()='Fashion' or contains(text(),'Fash')]"));
		WebElement fashion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Fashion' or contains(text(),'Fash')]")));
		action.moveToElement(fashion).build().perform();
		WebElement womenEthnic = driver.findElement(By.xpath("//a[text()='Women Ethnic']"));
		//womenEthnic.click();
		action.moveToElement(womenEthnic).click().build().perform();
	}
	
	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}
	
}
