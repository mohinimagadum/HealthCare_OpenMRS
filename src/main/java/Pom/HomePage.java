 package Pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Pojo.BaseClass;

public class HomePage extends BaseClass
{
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h4[contains(text(),'Logged in as Super User')]") private WebElement heading;
	@FindBy(xpath="//a[contains(text(),'Logout')]") private WebElement logout;
	@FindBy(xpath="//a[contains(@id,'coreapps-activeVisitsHomepageLink-core')]") private WebElement Find_Patient_record;
	@FindBy(xpath="//a[contains(@id,'org-openmrs-module-coreapps')]") private WebElement Active_Visit;
	@FindBy(xpath="//a[contains(@id,'referenceapplication-vitals')]") private WebElement capture_vitals;
	@FindBy(xpath="//a[contains(@id,'referenceapplication-registrationapp-registerPatient')]") private WebElement Register_patient;
	@FindBy(xpath="//a[contains(@id,'appointmentschedulingui')]") private WebElement Appoinment_Sceduling;
	@FindBy(xpath="//a[contains(@id,'reportingui-reports-homepagelink')]") private WebElement Report;
	@FindBy(xpath="//a[contains(@id,'coreapps-datamanagement')]") private WebElement Data_Management;
	@FindBy(xpath="//a[contains(@id,'org-openmrs-module-adminui')]") private WebElement Configure_metadata;
	@FindBy(xpath="//a[contains(@id,'coreapps-systemadministratio')]") private WebElement System_adminstration;
	
	public void Logout()
	{
		logout.click();
	}
	
	public void FindPatientRecord()
	{
		Find_Patient_record.click();
	}
	
	public void ActiveVisit()
	{
		Active_Visit.click();
	}
	
	public void CaptureVitals()
	{
		capture_vitals.click();
	}
	
	public RegisterPatient RegisterPatient()
	{
		Register_patient.click();
		return RegisterPatient();
	}
	
	public void AppoinmentSceduling()
	{
		Appoinment_Sceduling.click();
	}
	
	public void Reports()
	{
		Report.click();
	}
	public void DataManagement()
	{
		Data_Management.click();
	}
	public void ConfigureMetadata()
	{
		Configure_metadata.click();
	}
    public void SystemAdminstration()
    {
    	System_adminstration.click();
    }
}
