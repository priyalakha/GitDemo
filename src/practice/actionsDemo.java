package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/priyalakha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
	//	driver.get("https://www.amazon.com/");
		driver.get("https://www.amazon.com/gp/css/homepage.html/ref=nav_bb_ya");
		
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		
		// when we want to put HELLO in input by using Actions class's methods.
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		a.moveToElement(move).contextClick().build().perform();
		
		driver.close();
	}

}
