package homeproject;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProjectForHome {

	  WebDriver driver;
	  POMforProject obj;

	  @BeforeTest
	  public void preRequisite() throws InterruptedException//Loading WEBSITE
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\Webdriver\\Chrome Driver\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://www.galaxy.pk/");
	    PropertyConfigurator.configure("log4j.properties");
	    Thread.sleep(5000);
	    driver.manage().window().maximize();
	  }

	  @Test(priority = 1)//Hover and clicking LAPTOPS
	  public void HoverAndClick() throws InterruptedException
	  {
	    obj = new POMforProject(driver);
	    obj.hoverAndCLick();
	  }

	  @Test(priority = 2)//Extracting Information
	  public void ExtractingInfo() throws InterruptedException
	  {
	    obj = new POMforProject(driver);
	    obj.extractingInfromation();
	  }
	  @Test(priority = 3)//Extracting Pictures
	  public void Pictures() throws InterruptedException, IOException
	  {
	    obj = new POMforProject(driver);
	    obj.pictures();
	  }
	  @AfterTest
	  public void ClosingTabs() throws InterruptedException
	  {
	    driver.close();
	  }
}
