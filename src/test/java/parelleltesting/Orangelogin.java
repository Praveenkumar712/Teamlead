package parelleltesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Orangelogin {
	public static WebDriver driver;
	public Select sc;

	@BeforeClass
	@Parameters({"browser","url"})
	public void openApplication(String br, String URL) {

		if(br.equals("chrome")) {

			driver=new ChromeDriver();	
		}
		else if(br.equals("edge")) {

			driver=new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority=1)
	public void loginFunctionality() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void logoutFunctionality () throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(5000);

	}
	@Test(priority=3)
	public void Forgetpassword() throws InterruptedException {
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("praveenkumar");
		
		Thread.sleep(5000);
		driver.navigate().back();
	}
	@AfterClass
	public void closeApplication() {
		driver.close();
	}

}
