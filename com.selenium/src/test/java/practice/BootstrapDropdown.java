package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sun.tools.javac.main.Option;

public class BootstrapDropdown {
	
	WebDriver driver;
	
	@BeforeSuite
	public void initializeDriver() {
		if(driver==null) {
			driver = new ChromeDriver();
			driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
			driver.manage().window().maximize();
		}
	}
	
	@Test
	public void bsdropdown() {
		WebElement dropdownOptions = driver.findElement(By.xpath("//button[contains(@class,'multiselect')]"));
		dropdownOptions.click();
		//single select option
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//capture all the options and find out size
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		int optionsSize = options.size();
		System.out.println(optionsSize);
		
		//print options from dropdown
		//using for loop
		 for(int i=0; i<optionsSize; i++) {
			 String getOptions = options.get(i).getText(); 
			 System.out.println(getOptions);
		//select multiple options
			 if(getOptions.equalsIgnoreCase("MySQL") || getOptions.equalsIgnoreCase("Oracle") ) {
				 options.get(i).click();
				 break;
			 }
		 }
		 
		//using enhanced for loop
//		for(WebElement option : options) {
//			String getOptions = option.getText();
//			System.out.println(getOptions);
//		//select multiple options
//			if(getOptions.equalsIgnoreCase("MySQL")) {
//				option.click();
//				break;
//			}
//		}
	}
	
	
//	@AfterSuite
//	public void quitDriver() {
//		if(driver!=null) {
//			driver.quit();
//		}
//	}
	
	
}
