package assertions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgAnnations {
	@BeforeSuite
	public void openApplicaton() {
		System.out.println("hai i  am from open application");
		
		
	}

	@BeforeClass
	public void method2() {
		System.out.println("methos2");
		
		
	}
	@AfterClass
	public void method3() {
		System.out.println("methos2");
		
	}
	@BeforeMethod
	public void method4() {
		System.out.println("methos2");
	}
	@AfterMethod
	public void method5() {
		System.out.println("methos2");
	}
		
	@AfterSuite
	public void method6() {
		System.out.println("methos2");
		
	}
}
