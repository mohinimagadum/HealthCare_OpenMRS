package Pojo;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop ;
	public static ChromeOptions option; //it is class used to disable notifications
	public static String Projectpath=System.getProperty("user.dir"); //project path
	
	public static void Initialization(String Browsername) throws IOException 
	{
		FileInputStream file=new FileInputStream(Projectpath+".\\src\\main\\resources\\Config.properties");
		prop=new Properties();
		prop.load(file);
		
		//String browser=prop.getProperty("browser");
		if(Browsername.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup(); //instead of Sysytem.setProperty();
			option=new ChromeOptions();
			option.addArguments("--disable-notifications"); //it will disable the notification
			driver = new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(Browsername.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // it wait for page loading before throwing exception
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}

	
	
}
