package assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Softassertion {
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
	public void  VerificationOfLogout() throws InterruptedException {
		
		String act_tittle=driver.getTitle();
		String exp_tittle="OrangeHRM";
		SoftAssert sa=new SoftAssert(); //soft assertion
		
		if(act_tittle.equals(exp_tittle)) {
			
			sa.assertTrue(true);
			System.out.println("Testcase is pass");
		}
		else {
			
			sa.assertTrue(false);
			System.out.println("Testcase is fail"); 
		}
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	@AfterSuite
	public void close() {
		driver.close();
	}


}
