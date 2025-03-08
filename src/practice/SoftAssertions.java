package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/priyalakha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();
		
		for(WebElement link:links)
		{
			
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			
			// Assert.assertTrue(respCode<400, "The link with Text "+link.getText()+"is broken with code" +respCode);// hard assertions
			
			a.assertTrue(respCode<400, "The link with Text "+link.getText()+"is broken with code" +respCode);
		}
		a.assertAll();// fail the script if there is any failure in the steps with soft assert
	}

}
