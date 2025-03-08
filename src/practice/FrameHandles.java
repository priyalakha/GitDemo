package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/priyalakha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		// to find how many frames are on single page...
		System.out.println(driver.findElements(By.tagName("iframa")).size());
		// driver.switchTo().frame(0);
		// OR
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		
		driver.findElement(By.id("draggable")).click();
		
		// drag and drop from source to destination
		
		Actions a = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		
		// to come back to default content on the webpage...
		driver.switchTo().defaultContent();
		
		driver.close();
	
	}

}
