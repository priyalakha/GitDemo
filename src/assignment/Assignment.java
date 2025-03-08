package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/priyalakha/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Assert.assertFalse(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());

		List<WebElement> options = driver.findElements(By.cssSelector("input[type='checkbox']"));

		for (WebElement option : options) {
			option.click();
		}

		Assert.assertFalse(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());

		int size = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(size);
		driver.close();
	}

}
