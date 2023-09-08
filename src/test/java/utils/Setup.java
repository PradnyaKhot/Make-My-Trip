package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup 
{
	public static WebDriver driver;
	public static ChromeOptions options;
	
public static WebDriver chromedriver()
{
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
//	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver();
	driver.manage().window().maximize();
	options = new ChromeOptions();
	options.addArguments("--start-maximized--");
	options.addArguments("--disable-popup-blocking--");
	options.addArguments("--disable-notifications--");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	return driver;	
}

public static void teardown()
{
	driver.close();
}

}
