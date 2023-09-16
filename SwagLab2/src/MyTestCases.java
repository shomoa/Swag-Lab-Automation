import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTestCases {
		String theWebsiteURL="https://www.saucedemo.com/v1/index.html";
		WebDriver driver = new ChromeDriver();
		
		
	 //@ means annotation 
		@BeforeTest  //pascal names
		public void MyBeforeTest() throws InterruptedException { 
			driver.get(theWebsiteURL);
			WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
			emailInput.sendKeys("standard_user");
			WebElement PasswordFeild = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			PasswordFeild.sendKeys("secret_sauce");
			Thread.sleep(3000);
			WebElement login= driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		    login.click();
		
		}
		
		
		@Test
		public void AddToCartTestCase1() throws InterruptedException {
		
			//multiple buttons >> findElenentssss
			List <WebElement> AddToCartButtons = driver.findElements(By.className("btn_primary"));
			for(int i=0;i<AddToCartButtons.size();i++) {
				AddToCartButtons.get(i).click();		
				//Thread.sleep(3000);
			}
			
			//String ExpectedItems="6";
			int ExpectedItems=AddToCartButtons.size();
			//webElement is string
			WebElement ActualItemsinCart= driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
			String ActualValue =ActualItemsinCart.getText();
			
			//No XXX >>if(ExpectedItems==ActualItemsinCart.getText()) {
			//way1 but not used
			/*if(ActualItemsinCart.getText().equals(ExpectedItems)) {
				System.out.println("Pass");}*/
			//MyAssert.assertEquals(ActualValue, ExpectedItems); to compare to strings
			///to compare two int numbers 
			//Convert to int
			int ActualValueInt =Integer.parseInt(ActualValue);	
			Assertion MyAssert= new Assertion();

			MyAssert.assertEquals(ActualValueInt, ExpectedItems);
			
			}
		
		@Test
		public void RemoveAllitemsFromCart() throws InterruptedException{
			Thread.sleep(2000);
			List <WebElement> AddToCartButtons = driver.findElements(By.className("btn_secondary"));
			for(int i=0;i<AddToCartButtons.size();i++) {
				AddToCartButtons.get(i).click();	
			}
		}
		
		
		@AfterTest
		public void AfterMytestFinished() {
			
			
		}
		


	}

