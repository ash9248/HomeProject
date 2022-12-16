package patientProject;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ProjectPatient {
	WebDriver driver;
	POMpatientProject obj;
	Logger log1 = Logger.getLogger("ProjectPatient");
@BeforeTest 
	public void Prerequisite() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Webdriver\\Chrome Driver\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver(); 
	PropertyConfigurator.configure("log4j.properties");
	driver.get("http://release01.curemd.com/curemdy/datlogin.asp");
	driver.manage().window().maximize();
	Thread.sleep(5000);
}
@Test(priority=0)
public void Login() throws InterruptedException, AWTException {//Logging in with given Credentials
	obj =new POMpatientProject(driver);
	obj.logIn();
}
@Test(priority=1)
public void AddingPatient() throws InterruptedException, AWTException {//Adding Patient
	obj =new POMpatientProject(driver);
	obj.addingPatient();
}
@Test(priority=2)
public void CreatingCase() throws InterruptedException, AWTException {//Creating Case
	obj =new POMpatientProject(driver);
	obj.creatingCase();
}
@Test(priority=3)
public void CreatingProviderNote() throws InterruptedException, AWTException {//Creating Provider Notes
	obj =new POMpatientProject(driver);
	obj.creatingProviderNote();
}
@Test(priority=4)
public void AddingDiagnosis() throws InterruptedException, AWTException {//Adding Diagnosis
	obj =new POMpatientProject(driver);
	obj.addingDiagnosis();
}
@Test(priority=5)
public void AddingProcedure() throws InterruptedException, AWTException {//Adding Procedure
	obj =new POMpatientProject(driver);
	obj.addingProcedure();
}
@Test(priority=6)
public void CreatingeSuperbill() throws InterruptedException, AWTException {//Generating Esuperbill
	obj =new POMpatientProject(driver);
	obj.creatingeSuperbill();
}
@AfterTest
public void ClosingTabs() throws InterruptedException
{
  driver.close();
}
}
