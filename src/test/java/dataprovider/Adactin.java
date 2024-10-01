package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Adactin {
public static WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void openApplication(String br,String URL) {
		
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
	
	@Test(dataProvider="data")
	public void loginFunctionality(String user, String pwd) {
		
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login")).click();
	}
	
	
	@DataProvider(name="data", indices= {0,1,2,3})
	  
	String [][]  logindata(){
		
		String data[][]=
				
			{
					{"saketh","123644"},
					{"kijicc","yallanki"},
					{"15464","u16312623"},
					{"Saketh1008","Saketh1008@"}
					
			};
		return data;		
	}

}
