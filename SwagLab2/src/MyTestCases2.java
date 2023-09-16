import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases2 {
	String theWebsiteURL="https://www.saucedemo.com/v1/index.html";
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void PreTest() throws InterruptedException{
	driver.get(theWebsiteURL);
String UserName = "standard_user";
String Password ="secret_sauce";
		
WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
emailInput.sendKeys(UserName);
WebElement PasswordFeild = driver.findElement(By.xpath("//*[@id=\"password\"]"));
PasswordFeild.sendKeys(Password);
Thread.sleep(3000);
WebElement login= driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
login.click();


	}
	//the execution of test code run alphabetical order so if I want to run one by one add priority number in brackets.
	@Test(priority = 1)
	public void AddToCart() throws InterruptedException{
		List <WebElement> AddToCartButtons = driver.findElements(By.className("btn_inventory"));
		for(int i = 0; i < AddToCartButtons.size();i++) {
			AddToCartButtons.get(i).click();
		}
		Thread.sleep(3000);
		WebElement CartItems = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
		String CartIte = CartItems.getText();
		String ExpectedItems =Integer.toString(AddToCartButtons.size());
		Assert.assertEquals(CartIte, ExpectedItems, "the acutaual items # equal the expected");
		
	}
	@Test(priority = 2)
	public void RemovefromCart() {
		//btn inventory shared between add to cart button and remove button
				List <WebElement> RemovefromCartButtons = driver.findElements(By.className("btn_inventory"));
				for(int i = 0; i < RemovefromCartButtons.size();i++) {
					RemovefromCartButtons.get(i).click();
				}
	}
	
	@Test()
		public void TestTheTitle() {
			String Expectedtitle="Swag Labs";
			String ActualTitle = driver.getTitle();
			Assert.assertEquals(ActualTitle, Expectedtitle,"The expected title equal the actual");
	}
	}
	
	



