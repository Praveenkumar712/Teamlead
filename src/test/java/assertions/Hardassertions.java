package assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Hardassertions {
	public static WebDriver driver;
	@Test(priority=1)
	@Parameters({"browser","url"})
	public void openApplication(String br, String URL) {

		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("Edge")) {

			driver=new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	}
	@Test(priority=2)
	public void fogot(){
		driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
	}
	@Test(priority=3)
	public void LoginFunctionality() {

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Test(priority=4)
	public void Verificationoflogout() throws InterruptedException{
		String act_result = driver.getTitle();
		System.out.println(act_result);

		String exp_result= "OrangeHR";

		if(act_result.equals(exp_result)) {

			Assert.assertTrue(true);
			System.out.println("Testcase is passed");
		}
		else {
			System.out.println("Test case is failed");
			Assert.assertTrue(false);		
		}

		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	@AfterSuite
	public void close() {
		driver.close();
	}
	

}
