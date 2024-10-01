package dependsmethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OrangeHrm {
	WebDriver driver;
	@BeforeSuite
	public void openApplicationMethod() {
		driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	@Test
	public void loginFunctionality() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods= {"loginFunctionality"})
	public void logoutFunctionality () throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(5000);

	}
	@Test(dependsOnMethods= {"logoutFunctionality"})
	public void Forgetpassword() throws InterruptedException {
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("praveenkumar");
		driver.navigate().back();
		Thread.sleep(5000);

	}
	
	@AfterSuite
	public void closeApplication() {
		driver.close();
	}
}
