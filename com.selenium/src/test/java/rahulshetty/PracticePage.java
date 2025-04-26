package rahulshetty;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticePage {
	
	WebDriver driver;
	
	@BeforeSuite
	public void initializeDriver() {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test (priority=1)
	public void radioButton() {
		WebElement button = driver.findElement(By.xpath("//input[@value='radio2']"));
		button.click();
	}
	
	@Test (priority=2)
	public void suggessionClass() {
		WebElement field = driver.findElement(By.id("autocomplete"));
		field.sendKeys("ind");
		List<WebElement> dropdownList = driver.findElements(By.xpath("//ul/li[@class='ui-menu-item']"));
		for(WebElement dropdown : dropdownList) {
			String text = dropdown.getText();
			if(text.equalsIgnoreCase("India")) {
				dropdown.click();
				break;
			}
		}
		System.out.println(field.getDomProperty("value"));
	}
	
	@Test (priority=3)
	public void staticDropdown() {
		WebElement dropdownField = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(dropdownField);
		dropdown.selectByVisibleText("Option1");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}
	
	@Test (priority=4)
	public void checkboxExample() {
		driver.findElement(By.id("checkBoxOption3")).click();
	}
	
//	@Test (priority=5)
//	public void switchWindowExample() {
//		driver.findElement(By.id("openwindow")).click();
//	}
	
//	@Test (priority=6)
//	public void switchTabExample() {
//		WebElement tab = driver.findElement(By.linkText("Open Tab"));
//		tab.click();
//		//handling windows
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> it = windows.iterator();
//		String parentId = it.next();
//		String childId = it.next();
//		driver.switchTo().window(childId);
//		String text = driver.findElement(By.linkText("Access all our Courses")).getText();
//		System.out.println(text);
//		driver.close();
//		driver.switchTo().window(parentId);
//		System.out.println(driver.findElement(By.className("switch-tab")).getDomProperty("value"));
//	}
	
	@Test (priority=7)
	public void alertExample() {
		driver.findElement(By.name("enter-name")).sendKeys("Kanniya");
		//alert
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();
		//confirm
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
	}
	
	
	
	
	
	
	
}
