package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AutoSuggestiveDropdown {
	
	WebDriver driver;
	
	@BeforeSuite
	public void initializeDriver() {
		if(driver==null) {
			driver = new ChromeDriver();
			driver.get("https://www.google.co.in/");
			driver.manage().window().maximize();
			
		}
		else {
			System.out.println("The driver is already initialized");
		}
	}
	
	@Test
	public void autoSuggetion() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium" + Keys.ENTER);
		
//		
//		List<WebElement> searchLists = driver.findElements(By.xpath("//div[@id='Alh6id']//ul/li"));
//		for(WebElement searchList : searchLists) {
//			String text = searchList.getText();
//			if(text.equalsIgnoreCase("Selenium")) {
//				System.out.println(text + Keys.ENTER);
//				break;
//			}
//		}
		
	}
	
	
	
	
	
}
