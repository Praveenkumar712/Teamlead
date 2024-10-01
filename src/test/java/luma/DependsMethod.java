package luma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DependsMethod {
	WebDriver driver;
	@BeforeSuite
	public void openApplicationMethod() {
		driver=new ChromeDriver();
		
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	@Test 
	public void Registerfunctionality() {
		driver.findElement(By.id("firstname")).sendKeys("saketh");
		driver.findElement(By.id("lastname")).sendKeys("yallanki");
		driver.findElement(By.id("email_address")).sendKeys("sakethyallanki1008@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Saketh1008@");
		driver.findElement(By.id("password-confirmation")).sendKeys("Saketh1008");
		driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
	}
	@Test
	public void loginfunctionality() {
		driver.findElement(By.xpath("//li[@class='authorization-link']")).click();	
		driver.findElement(By.id("email")).sendKeys("sakethyallanki1008@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Saketh1008@");
		driver.findElement(By.id("send2")).click();
		
		}
	@Test(dependsOnMethods= {"loginfunctionality"})
	public void logoutfunctionality() throws InterruptedException {
		driver.findElement(By.xpath("//button[@tabindex='-1']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@data-label='or'][1]")).click();
	
	}
	@Test(dependsOnMethods= {"logoutfunctionality"})
	public void reloginfunctionality() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sakethyallanki1008@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Saketh1008@");
		driver.findElement(By.id("send2")).click();
	}
	public void closeApplication() {
		driver.close();
	}
	
}

