package mouseEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DoubleClick {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	@BeforeSuite
	public void initializeDriver() {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		action = new Actions(driver);
	}
	
	@Test (priority=1)
	public void doubleClickExample1() {
		WebElement frame = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame);
		
		WebElement copyTextButton = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		//wait.until(ExpectedConditions.visibilityOf(copyTextButton));
		action.doubleClick(copyTextButton).build().perform();
		
		String field1Value = driver.findElement(By.id("field1")).getDomAttribute("value");
		System.out.println(field1Value);
		String field2Value = driver.findElement(By.id("field2")).getDomProperty("value");
		System.out.println(field2Value);
		
		if(field1Value.equalsIgnoreCase(field2Value)) {
			System.out.println("The copy text button is working");
		}
		else {
			System.out.println("The copy text button is not working");
		}
		
		driver.switchTo().defaultContent();
	}
	
	@Test (priority=2)
	public void doubleClickExample2() {
		driver.navigate().to("https://www.w3schools.com/TAgs/tryit.asp?filename=tryhtml5_ev_ondblclick");
		
		WebElement frame = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame);
		
		WebElement clickMeButton = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		WebElement text = driver.findElement(By.id("demo"));
		System.out.println(text.getText());
		action.doubleClick(clickMeButton).perform();
		
		driver.switchTo().defaultContent();
	}
	
	
}
