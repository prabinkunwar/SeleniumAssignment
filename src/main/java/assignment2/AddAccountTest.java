package assignment2;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddAccountTest {

	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void addAccountTest() {
		
		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@name='login' and @type='submit']"));
		
		USERNAME_ELEMENT.clear();
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();
		
		driver.findElement(By.xpath("/html/body/section/div/nav/div/ul/li[10]/a/span[1]")).click();
		driver.findElement(By.xpath("//a[text()='New Account']")).click();
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Tony Stark");
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("This is a saving account");
		driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("100000");
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("864221159687452");
		driver.findElement(By.xpath("//input[@id='contact_person']")).sendKeys("Happy Hogan");
		driver.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("8174058214");
		driver.findElement(By.xpath("//input[@id='ib_url']")).sendKeys("https://www.bankofamerica.com/");
		driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/button")).click();
	}
}
