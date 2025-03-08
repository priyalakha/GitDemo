package practice;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart_project {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/priyalakha/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		int j = 0; // adding to check how many times code enters the loop, so when its run 3 times 
		//then break out from loops we only have 3 items
		
		// Array of String elements
		String[] itemsNeeded = {"Cucumber", "Brocolli", "BeetRoot"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size(); i++) {
			
			// split method to split from - so on 0th index vegetable name will come and 1st index
			// String name = products.get(i).getText();
			
			String[] name = products.get(i).getText().split("-");// returns an array
			// use trim method to remove extra space after vegetable name
			String formattedName = name[0].trim();// returns string here
			// check whether name you extracted is present in arrayList or not.
			// convert array into array List for easy search
			
			List itemsNeededList = Arrays.asList(itemsNeeded); 
			
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				//click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action/button']")).get(i).click();
				if(j==itemsNeeded.length) {
					break;
				}
			}
		}
		driver.close();
	}

}
