package parelleltesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class lumalogin {
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
	public void Registerfunctionality() {
		driver.findElement(By.id("firstname")).sendKeys("Praveen");
		driver.findElement(By.id("lastname")).sendKeys("kumar");
		driver.findElement(By.id("email_address")).sendKeys("Sakethyallanki1008@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Saketh1008@");
		driver.findElement(By.id("password-confirmation")).sendKeys("Saketh1008@");
		driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
	}
	@Test(priority=2)
	public void loginfunctionality() throws InterruptedException {
		driver.findElement(By.xpath("//li[@class='authorization-link']")).click();	
		driver.findElement(By.id("email")).sendKeys("Sakethyallanki1008@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Saketh1008@");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(5000);
		}
	@Test(priority=3)
	public void logoutfunctionality() throws InterruptedException {
		
			driver.findElement(By.xpath("//button[@tabindex='-1']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//li[@data-label='or'][1]")).click();
		
		}
		@Test(priority=4)
		public void reloginfunctionality() {
			driver.findElement(By.xpath("//li[@class='authorization-link']")).click();	
			driver.findElement(By.id("email")).sendKeys("Sakethyallanki1008@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("Saketh1008@");
			driver.findElement(By.id("send2")).click();
			
		}
		@AfterClass
		public void closeApplication() {
			driver.close();
		}
}
