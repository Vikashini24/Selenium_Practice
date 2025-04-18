package webTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class StaticTables {
	
	WebDriver driver;
	
	@BeforeSuite
	public void initializeDriver() {
		if(driver==null) {
			driver = new ChromeDriver();
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
		}
	}
	
	@Test
	public void staticWebTable() {
		//find total number of rows in a table
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		int rowSize = tableRows.size();
		System.out.println("Number of rows: " + rowSize + "\n");
		
		//find total number of columns in a table
		List<WebElement> tableColumns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		int columnSize = tableColumns.size();
		System.out.println("Number of columns: " + columnSize + "\n");
		
		//read data from specific row and column --> row-5 column-1
		WebElement rOneCFive = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]"));
		System.out.println("Row-5, Column-1: " + rOneCFive.getText() + "\n");
		
		//read data from all the rows and columns
		for(int r=2; r<=rowSize; r++) {
			for(int c=1; c<=columnSize; c++) {
				WebElement allData = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[ " + c + "]"));
				System.out.print("Data: " + allData.getText() + "\t");
			}
			System.out.println();
		}
		System.out.println("\n");
		
		//print book names whose author is Mukesh
		for(int r=2; r<rowSize; r++) {
			WebElement authors = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[2]"));
			String authorName = authors.getText();
			if(authorName.equals("Mukesh")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[1]")).getText();
				System.out.println("Books name whose author is Mukesh:" +bookName + "\t" + authorName);
			}
		}
		System.out.println("\n");
		
		
		//find total price of all the books
		int total=0;
		for(int r=2; r<=rowSize; r++) {
			WebElement prices = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]"));
			String priceRow = prices.getText();
			System.out.println(priceRow);
			//convert the price to integer and add
			int price = Integer.parseInt(priceRow);
			total = total+price;
		}
		System.out.println("Total price: " + total);
	}
	
	@AfterSuite
	public void quiteDiver() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	
	
}
