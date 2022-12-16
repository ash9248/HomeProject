package homeproject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class POMforProject {
	 @FindBy(xpath="(//a[@title='Laptops'])[2]") WebElement laptopbutton;
	  @FindBy(xpath="//div[@class='product-loop-body product-item__body']/span/following-sibling::a/h2") List<WebElement> laptops;
	  @FindBy(xpath="//span[@class='price']") List<WebElement> Prices;
	  @FindBy(xpath="//div[@class='product-short-description']") List<WebElement> Description;
	  @FindBy(xpath="//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail jetpack-lazy-image jetpack-lazy-image--handled']") WebElement pictures;
	  WebDriver driver;
	  Logger log1 = Logger.getLogger("POMforProject");
	  public POMforProject(WebDriver driver)
	  {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	  }
	  
	  
	  public void hoverAndCLick() throws InterruptedException
	  {
	    Actions act = new Actions(driver);
	    act.moveToElement(laptopbutton).perform();
	    Thread.sleep(3000);
	    laptopbutton.click();
	    Thread.sleep(3000);
	    log1.info("Site Loaded and clicked on Laptops");
		Assert.assertEquals("Laptops – Galaxy.pk", driver.getTitle());
	  }
	  
	  public void extractingInfromation() throws InterruptedException
	  {
	    List <WebElement> Products;
	    List<String> laptopnames = new ArrayList<String>();

	    System.out.println("Laptops' Names ");
	    Products=laptops;

	    for(WebElement Names : Products)
	    {
	      laptopnames.add(Names.getText());
	    }

	    for(String NameText: laptopnames)
	    {
	      System.out.println(NameText);
	    }
	    String Names = laptopnames.toString();
	    laptopnames.get(1).charAt(1);

	    List <WebElement> PriceofLaptops;
	    List<String> laptopprices = new ArrayList<String>();

	    System.out.println("Laptops' Prices: ");
	    PriceofLaptops = Prices;

	    for(WebElement GetPrice : PriceofLaptops)
	    {
	      laptopprices.add(GetPrice.getText());
	    }

	    for(String PriceText: laptopprices)
	    {
	      System.out.println(PriceText);

	    }
	    String Prices = laptopprices.toString();

	    List <WebElement> DescriptionOfLaptops;
	    List<String> laptopsdescription = new ArrayList<String>();
	    System.out.println("Laptops' Description: ");
	    DescriptionOfLaptops= Description;
	    for(WebElement Des : DescriptionOfLaptops)
	    {
	      laptopsdescription.add(Des.getText());
	    }

	    for(String DesText: laptopsdescription)
	    {
	      System.out.println(DesText);
	      System.out.println(" ");

	    }
	    String Description = laptopsdescription.toString();


	    File file = new File("C:\\Users\\4389\\Downloads\\Laptops Infromation.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Laptop Information");

	    Map<String, Object[]> data = new TreeMap<String, Object[]>();
	    
	    for(int i=0;i<=29;i++)
	    {
	      String lapnumber=Integer.toString(i);
	      String lapnames = laptopnames.get(i);
	      String lapprices = laptopprices.get(i);
	      String lapdescription = laptopsdescription.get(i);
	      data.put(lapnumber, new Object[] {lapnames,lapprices,lapdescription});
	    }

	    Set<String> keyset = data.keySet();
	    int rownum = 0;
	    for (String key : keyset)
	    {

	      Row row = sheet.createRow(rownum++);
	      Object[] objArr = data.get(key);

	      int cellnum = 0;

	      for (Object obj : objArr)
	      {
	        Cell cell = row.createCell(cellnum++);
	        if (obj instanceof String)
	        {
	          cell.setCellValue((String) obj);
	        }
	        else if (obj instanceof Integer)
	        {
	          cell.setCellValue((Integer) obj);
	        }
	      }
	    }
	    try
	    {
	      FileOutputStream fos = new FileOutputStream(file);
	      workbook.write(fos);
	      fos.close();
	      System.out.println("Data Printed!");
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	  }
	  
	  public void pictures() throws InterruptedException, IOException
	  {
		    List <WebElement> Products;
		    List<String> laptopnames = new ArrayList<String>();

		    Products=laptops;

		    for(WebElement Names : Products)
		    {
		      laptopnames.add(Names.getText());
		    }

		    for(String NameText: laptopnames)
		    {
		      System.out.println(NameText);
		    }
		    String Names = laptopnames.toString();
		    String images = pictures.getAttribute("src");
		    URL imageURL = new URL(images);
		    File directory = new File(System.getProperty("user.dir") 
		            + System.getProperty("file.separator")+ "Images");

		   for(File file: directory.listFiles()) {
		        BufferedImage image = ImageIO.read(file);
			    ImageIO.write(image, "png", new File(Names+".png"));
		   }
//		    BufferedImage image = ImageIO.read(imageURL);
//		    ImageIO.write(image, "png", new File(Names+".png"));
	  }
}
