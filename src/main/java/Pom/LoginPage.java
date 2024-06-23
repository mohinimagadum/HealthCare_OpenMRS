package Pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pojo.BaseClass;

public class LoginPage extends BaseClass
{

	public LoginPage()	
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username") private WebElement user;
	@FindBy(id="password") private WebElement Pass;
	@FindBy(xpath="//ul[@id='sessionLocation']//li") private List<WebElement> location;
	@FindBy(xpath="//input[@class='btn confirm']") private WebElement login;
	@FindBy(xpath="//div[@class='logo']/a/img") private WebElement logo;
	@FindBy(xpath="//div[contains(text(),'Invalid username/password. Please try again.')]") private WebElement errormsg;
	
	public String GetTitle()
	{
		return driver.getTitle();
	}
	public String ErrorMsg()
	{
		return errormsg.getText();
	}
	public void username(String name)
	{
		user.sendKeys(name);
	}
	public void password(String pass)
	{
		Pass.sendKeys(pass);
	}
	public int Checkoption_count()
	{
		int size= location.size();
		return size;
	}
	public ArrayList<String> Check_optiondata()
	{
		ArrayList<String> opt=new ArrayList<String>();
		for(WebElement Loc:location)
		{
			opt.add(Loc.getText());
		}
		return opt;
	}
	
	public void sessionLocation(String option)
	{
		for(WebElement Loc:location)
		{
			if(Loc.getText().equals(option))
			{
				Loc.click();
			}
		}
	}
	public void Login()
	{
		login.click();
	}
	public HomePage Home_Page()
	{
		user.sendKeys("admin");
		Pass.sendKeys("Admin123");
		for(WebElement Loc:location)
		{
			if(Loc.getText().equals("Registration Desk"))
			{
				Loc.click();
			}
		}
		login.click();
	    return new HomePage();
	}
	
	

}
