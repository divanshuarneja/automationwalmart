

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class automateWalmart {
	
	WebDriver webDriver;
	
	@Before
	public void openBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		webDriver = new ChromeDriver();
		webDriver.get("http://www.walmart.com/");
		webDriver.findElement(By.className("Modal-closeButton")).click();
		webDriver.manage().window().maximize();
	}
	
	@Test
	public void signIn() throws Exception {
		//click sign in button
		WebElement signIn = webDriver.findElement(By.xpath("//*[@id=\"top\"]/div[3]/div/div/div/div/div[4]/div/div[1]/div[1]/p/span[2]/a"));
		signIn.click();
		sleep(1000);
		
		//type user-name and password, then click login.
		WebElement userName = webDriver.findElement(By.xpath("//input[@id=\"login-username\"]"));
		WebElement passWord = webDriver.findElement(By.xpath("//input[@id=\"login-password\"]"));
		WebElement logIn  = webDriver.findElement(By.xpath("/html/body/div[1]/section/section[4]/div/div/div/div/div/div/div/form/div/button"));
		userName.sendKeys("walmartautomate@gmail.com");
		passWord.sendKeys("walmart@123");
		logIn.click();
		sleep(1000);
		
		WebElement myAccount = webDriver.findElement(By.xpath("/html/body/div[1]/section/section[4]/div/div/div/div/div[1]/div/div/h3/a"));
		assertEquals("Recent Orders",myAccount.getText());
		
		//go to homePage
		WebElement walmartlogo = webDriver.findElement(By.xpath("//*[@id=\"top\"]/div[3]/div/div/div/div/div[2]/a[1]"));
		walmartlogo.click();
		sleep(1000);
		
		//test the shopping functionality
		letsShop();  
		
	}
	
	public void letsShop() throws Exception {
		    
			//search the item
			WebElement searchbox = webDriver.findElement(By.xpath("//*[@id=\"top\"]/div[3]/div/div/div/div/div[3]/form/div/div[2]/span/input"));
			//enter your item to be searched here
			String searchitem = "dvd";
			
			searchbox.sendKeys(searchitem);	
			
			//select a item
			WebElement searchButton   = webDriver.findElement(By.xpath("//*[@id=\"top\"]/div[3]/div/div/div/div/div[3]/form/div/div[3]/button"));
			searchButton.click();
			sleep(1000);
		
			WebElement item = null;
			String itemxpath = null;
			switch(searchitem){
			//socks, dvd, tv, toys, iPhone
			case "socks":
				itemxpath ="//*[@id='tile-container']/div[1]/div/div/h4/a";
				break;
			case "dvd":
				itemxpath= "//*[@id='tile-container']/div[1]/div/div/h4/a";
				break;
			case "tv":
				itemxpath= "//*[@id='tile-container']/div[1]/div/div/h4/a";
				break;
			case "toys":
				Actions builder = new Actions(webDriver);
				WebElement category = webDriver.findElement(By.xpath("html/body/div[1]/section/section[4]/div/div/div[3]/div[2]/div[1]/div[1]/div/div/div/ul/li[8]/a/span"));
				builder.moveToElement(category).perform();
				WebElement subcategory = webDriver.findElement(By.xpath("/html/body/div[1]/section/section[4]/div/div/div[3]/div[2]/div[1]/div[1]/div/div/div/ul/li[8]/div/div/ul[2]/li[3]/a"));
				builder.moveToElement(subcategory).click().build().perform();
				itemxpath= "//*[@id='tile-container']/ul/li[2]/div/a[2]/h3/div";
				break;
			case "iPhone":
				itemxpath= "//*[@id='tile-container']/div[6]/div/div/h4/a";
				break;
			default:
				break;

			}
			item = webDriver.findElement(By.xpath(itemxpath));
			String itemTitle = item.getText();
			item.click();
			sleep(2000);
			
			//add the item in cart
			WebElement addToCart = webDriver.findElement(By.xpath("//*[@id=\"WMItemAddToCartBtn\"]"));
			addToCart.click();
			sleep(2000);
			
			//navigate to/view cart
			WebElement viewItem = webDriver.findElement(By.xpath("//*[@id=\"PACViewCartBtn\"]"));
			viewItem.click();
			sleep(1000);
		
			//test quantity
			WebElement quantity = webDriver.findElement(By.xpath("/html/body/div[1]/section/section[4]/div/div/div[1]/div/div/div[1]/div/h3/span"));
			assertEquals("1 item.", quantity.getText());
			
			//confirm if same item is present in cart
			WebElement itemTitle1 = webDriver.findElement(By.xpath("/html/body/div[1]/section/section[4]/div/div/div[1]/div/div/div[1]/div/div[4]/div[2]/div/div/div[3]/div[1]/a/span"));
			assertEquals(itemTitle, itemTitle1.getText());		
		
	}
	
	@After
	public void quitbrowser() throws Exception {
		sleep(2000);
		webDriver.quit();
	}
	
	private void sleep(int x) {
		try {
			Thread.sleep(x);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}





