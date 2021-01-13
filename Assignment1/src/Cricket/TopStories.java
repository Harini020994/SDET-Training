package Cricket;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


	
	public class TopStories extends Capability {
		AndroidDriver<AndroidElement> driver;
		
		
		@BeforeTest
		public void bt() throws MalformedURLException {
			driver=capabilities();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
		}
		
		
		@Test
		public void testcase1() throws MalformedURLException, InterruptedException {
			
			driver.get("http://m.cricbuzz.com");
			//driver.navigate().to("http://www.google.com");
			driver.findElement(By.xpath("//a[@href='#menu']")).sendKeys(Keys.ENTER);;
			driver.findElement(By.xpath("//*[contains(text(),'Home')]")).sendKeys(Keys.ENTER);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement ele=driver.findElement(By.xpath("//*[contains(text(),'Top Stories')]"));
			js.executeScript("arguments[0].scrollIntoView()",ele);
			assertEquals(ele.getText(),"Top Stories");
			
		}

}
