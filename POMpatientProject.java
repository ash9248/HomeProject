package patientProject;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class POMpatientProject {
	Logger log1 = Logger.getLogger("POMpatientProject");
	WebDriver driver;
	//POM Web Elements
@FindBy(xpath = "//input[@id='vchLogin_Name']") WebElement username;
@FindBy(xpath = "//input[@id='vchPassword']") WebElement password;
@FindBy(xpath = "//button[@type='button']") WebElement loginbutton;
@FindBy(id = "fra_Menu_CureMD") WebElement patientframe;
@FindBy(xpath = "//i[@class='icon icon-patient']") WebElement patienticon;
@FindBy(xpath = "//iframe[@id='fraCureMD_Body']") WebElement addpatientframe;
@FindBy(xpath = "//td[@title='Add Patient']") WebElement addpatientbutton;
@FindBy(id = "cmbVTitle") WebElement titlelist;
@FindBy(id = "txtVFNAME") WebElement firstname;
@FindBy(id = "txtVLNAME") WebElement lastname;
@FindBy(xpath = "//select[@tabindex='5']") WebElement genderlist;
@FindBy(xpath = "//input[@tabindex='7']") WebElement dob;
@FindBy(xpath = "//select[@name='cmbILOCID']") WebElement location;
@FindBy(xpath = "//input[@tabindex='17']") WebElement zip;
@FindBy(xpath = "//input[@tabindex='14']") WebElement city;
@FindBy(xpath = "//input[@tabindex='15']") WebElement state;
@FindBy(xpath = "//input[@tabindex='23']") WebElement email;
@FindBy(id = "imgpInsurance") WebElement expandforprimary;
@FindBy(xpath = "//select[@tabindex='71']") WebElement planlist;
@FindBy(xpath = "//select[@tabindex='75']") WebElement addresslist;
@FindBy(xpath = "//select[@tabindex='83']") WebElement dateicon;
@FindBy(xpath = "(//td[@colspan='3' and text()='Today'])[2]") WebElement todaysdate;
@FindBy(xpath = "//input[@id='txtSecDSIGNONFILE']") WebElement dateforsec;
@FindBy(xpath = "//img[@id='imgSInsurance']") WebElement expandforsecondary;
@FindBy(xpath = "//select[@tabindex='129']") WebElement planlistforsec;
@FindBy(id="cmbSecPlanAdd") WebElement addresslistforsec;
@FindBy(id="tdsave") WebElement savebutton;
@FindBy(id="DynamicBHdialogbox") WebElement framenew;
@FindBy(id="saveAsNewButton")WebElement saveasnewbutton;
@FindBy(xpath = "//iframe[@id='fraCureMD_Patient_Menu']") WebElement profileframe;
@FindBy(id = "Provider_Notes_anchor") WebElement providernotes;
@FindBy(id = "Provider_Notes_New_Case_anchor") WebElement newcase;
@FindBy(id = "txtVCNAME") WebElement newcasename;
@FindBy(xpath = "//input[@id='txtDSTART']") WebElement dateforcase;
@FindBy(xpath="//td[@id='cmdSubmit']")WebElement savecasebutton;
@FindBy(xpath="//a[@id='Provider_Notes_Provider_Notes_anchor']")WebElement providernotesoption;
@FindBy(xpath="//td[@id='SpAdd1']")WebElement providernotesbutton;
@FindBy(xpath = "//input[@id='Sdate']") WebElement dateforprovidernote;
@FindBy(id = "cmbProvider") WebElement providerlist;
@FindBy(id = "cmbRTemplate") WebElement notetemplate;
@FindBy(xpath="//select[@id='txtVREASON']") WebElement visitreason;
@FindBy(xpath="//select[@id='cmbLocation']") WebElement locationforprovidernotes;
@FindBy(xpath="//select[@id='cmbReportType']")WebElement notetype;
@FindBy(xpath="//td[@id='btnSave']")WebElement createbutton;
@FindBy(xpath="(//a[@style='cursor:pointer;color:green;font-size:10px;font-family:arial'])[8]") WebElement adddiagnosisbutton;
@FindBy(xpath = "//iframe[@id='DynamicBHdialogbox']") WebElement searchframe;
@FindBy(xpath="//input[@id='txtKeyword']")WebElement searchbydiagnosis;
@FindBy(xpath="//iframe[@id='fraCureMD_Patient_Menu']") WebElement diagnosisframe;
@FindBy(id = "imgMaster") WebElement searchicon;
@FindBy(xpath = "//a[@id='0']") WebElement searchresult;
@FindBy(xpath= "//td[@id='tdSaveDiagnosis']") WebElement savebuttondiagnosis;
@FindBy(xpath= "//td[@id='tdSoapAccept']") WebElement acceptbuttondiagnosis;
@FindBy(xpath= "//iframe[@id='fraCureMD_Patient_Menu']") WebElement ordersframe;
@FindBy(xpath= "//a[@id='Clinical_Lab_Order_7_anchor']") WebElement ordersoption;
@FindBy(xpath= "(//a[@style='cursor:pointer;color:green;font-size:10px;font-family:arial'])[10]") WebElement addprocedure;
@FindBy(xpath= "//iframe[@id='DynamicBHdialogbox']") WebElement procedureframe;
@FindBy(xpath= "//input[@id='txtSearch']") WebElement proceduresearch;
@FindBy(xpath= "//img[@id='SearchImg']") WebElement proceduresearchbutton;
@FindBy(xpath= "(//a[@title='99211 - Office or other outpatient visit for the evaluation and management of an established patient, that may not require the presence of a physician or other qualified health care professional. Usually, the'])[2]") WebElement proceduresearchresult;
@FindBy(xpath= "//td[@id='tdSaveDiagnosis']") WebElement proceduresaveandacceptbutton;
@FindBy(xpath= "//td[@id='sp_eSuperbill']") WebElement createsuperbillbutton;
@FindBy(xpath= "//select[@id='cmdPatType']") WebElement patienttype;
@FindBy(xpath= "//td[@onclick='javascript:SubmitForm()']") WebElement createesuperbill;
@FindBy(xpath= "//select[@id='ddleandm']") WebElement patientselection;
@FindBy(xpath= "//iframe[@id='DynamicBHdialogbox']") WebElement esuperbillframe;
@FindBy(id = "gvSuperBill_ctl02_txtDxPointer") WebElement dxprinter;
@FindBy(id = "chkDxPointer_1") WebElement option1;
@FindBy(xpath= "//input[@id='gvSuperBill_ctl02_txtAmount']") WebElement amount;
@FindBy(id = "imgSave") WebElement save;

public POMpatientProject(WebDriver driver)//Constructor
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void logIn () throws InterruptedException, AWTException {//logging in with given credentials
	username.sendKeys("ChargeDates");
	Thread.sleep(2000);
	password.sendKeys("SuPPort.2014");
	Thread.sleep(2000);
	loginbutton.click();
	Thread.sleep(5000);
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	    Thread.sleep(1000);
	}
	Thread.sleep(3000);
	driver.manage().window().maximize();
	log1.info("Patient Logged in");
	Assert.assertEquals("Personal: Dashboard", driver.getTitle());
}
public void addingPatient() throws InterruptedException, AWTException {//adding patient
	driver.switchTo().frame(patientframe);
	Thread.sleep(3000);
	patienticon.click();
	Thread.sleep(2000);
	log1.info("Navigated to Patient Button");
	driver.switchTo().defaultContent();
	driver.switchTo().frame(addpatientframe);
	Thread.sleep(2000);
	addpatientbutton.click();
	Thread.sleep(3000);
	Select drp= new Select(titlelist);
	drp.selectByVisibleText("Mr");
	Thread.sleep(2000);
	firstname.sendKeys("Ash");
	lastname.sendKeys("Ley");
	Thread.sleep(2000);
	Select drp2= new Select(genderlist);
	drp2.selectByVisibleText("Male");
	Thread.sleep(2000);
	dob.sendKeys("12/20/2000");
	Select drp3= new Select(location);
	Thread.sleep(2000);
	drp3.selectByVisibleText("Clinic One1");
	Thread.sleep(2000);
	zip.sendKeys("02301");
	city.sendKeys("Boston");
	state.sendKeys("MA");
	email.sendKeys("shemar_hilpert@hotmail.com");
	Thread.sleep(3000);
	expandforprimary.click();
	Thread.sleep(3000);
	Select drp4= new Select(planlist);
	drp4.selectByVisibleText("AARP");
	Select drp5= new Select(addresslist);
	Thread.sleep(2000);
	drp5.selectByVisibleText("P O BOX 1017");
	expandforsecondary.click();
	Thread.sleep(2000);
	Actions act = new Actions(driver);
	act.sendKeys(Keys.PAGE_DOWN).build().perform();
	act.sendKeys(Keys.PAGE_DOWN).build().perform();
	Select drp6= new Select(planlistforsec);
	Thread.sleep(2000);
	drp6.selectByVisibleText("AETNA");
	Thread.sleep(2000);
	Select drp7= new Select(addresslistforsec);
	Thread.sleep(2000);
	drp7.selectByIndex(1);
	dateforsec.click();
	Thread.sleep(2000);
	act.sendKeys(Keys.PAGE_UP).build().perform();
	act.sendKeys(Keys.PAGE_UP).build().perform();
	Thread.sleep(2000);
	savebutton.click();
	Thread.sleep(2000);
	driver.switchTo().frame(framenew);
	saveasnewbutton.click();
	log1.info("Patient Added");
	Thread.sleep(3000);
	driver.switchTo().frame(profileframe);
	Thread.sleep(3000);
	Assert.assertTrue(providernotes.isDisplayed());
}
public void creatingCase() throws InterruptedException, AWTException {//Creating Case
	providernotes.click();
	Thread.sleep(2000);
	newcase.click();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame(addpatientframe);
	newcasename.sendKeys("Accident");
	dateforcase.click();
	Thread.sleep(2000);
	savecasebutton.click();
	log1.info("Case Created");
	driver.switchTo().defaultContent();
	driver.switchTo().frame(profileframe);
	Thread.sleep(2000);
	Assert.assertTrue(providernotesoption.isDisplayed());
}
public void creatingProviderNote() throws InterruptedException, AWTException {//Creating Provider Notes
	providernotesoption.click();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame(addpatientframe);
	providernotesbutton.click();
	Thread.sleep(2000);
	dateforprovidernote.click();
	Thread.sleep(2000);
	Select drp= new Select(providerlist);
	drp.selectByIndex(3);
	Select drp2= new Select(notetemplate);
	drp2.selectByIndex(3);
	Select drp3= new Select(visitreason);
	drp3.selectByIndex(3);
	Select drp4= new Select(locationforprovidernotes);
	drp4.selectByIndex(3);
	Select drp5= new Select(notetype);
	drp5.selectByIndex(3);
	Thread.sleep(2000);
	createbutton.click();
	log1.info("Provider Note Created");
	driver.switchTo().defaultContent();
	driver.switchTo().frame(diagnosisframe);
	Thread.sleep(3000);
	Assert.assertTrue(adddiagnosisbutton.isDisplayed());
}
public void addingDiagnosis() throws InterruptedException, AWTException {//Adding diagnosis
	adddiagnosisbutton.click();
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame(searchframe);
	searchbydiagnosis.sendKeys("A00.0");
	searchicon.click();
	Thread.sleep(3000);
	searchresult.click();
	Thread.sleep(2000);
	savebuttondiagnosis.click();
	Thread.sleep(2000);
	acceptbuttondiagnosis.click();
	log1.info("Diagnosis Added");
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame(ordersframe);
	Assert.assertTrue(ordersoption.isDisplayed());

}
public void addingProcedure() throws InterruptedException, AWTException {//Adding Procedure
	
	ordersoption.click();
	Thread.sleep(2000);
	addprocedure.click();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame(procedureframe);
	proceduresearch.sendKeys("99211");
	proceduresearchbutton.click();
	Thread.sleep(2000);
	proceduresearchresult.click();
	Thread.sleep(2000);
	proceduresaveandacceptbutton.click();
	log1.info("Procedure Added");
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame(addpatientframe);
	Assert.assertTrue(createsuperbillbutton.isDisplayed());
}
public void creatingeSuperbill() throws InterruptedException, AWTException {//Creating eSuperbill
	
	createsuperbillbutton.click();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame(esuperbillframe);
	Select drp= new Select(patienttype);
	drp.selectByVisibleText("New Patient");
	createesuperbill.click();
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame(addpatientframe);
	Select drp2= new Select(patientselection);
	drp2.selectByVisibleText("99211-99215: Established Patient Office Visit");
	Thread.sleep(3000);
	dxprinter.click();
	Thread.sleep(3000);
	option1.click();
	Thread.sleep(3000);
	amount.click();
	amount.clear();
	Thread.sleep(3000);
	amount.sendKeys("10");
	Thread.sleep(3000);
	save.click();
	log1.info("Esuperbill Generated");
	Assert.assertEquals("Patient: Provider Notes: eSuperbill", driver.getTitle());
}
}
