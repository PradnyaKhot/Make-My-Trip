package pages;

import java.awt.AWTException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Booking 
{
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
		
	@FindBy(xpath = "//span[@class = 'bgProperties icon20 overlayCrossIcon']") WebElement close;
	@FindBy(xpath = "//p[text() ='Non Stop First']") WebElement nonStop;
	@FindBy(xpath = "//div[contains(., 'Airlines')]/div/div[1]/label/span") WebElement type;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span[1]") WebElement viewButton;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div[2]/div/div/div[2]/button") WebElement bookButton;
	public @FindBy(xpath = "//h2[@class = 'fontSize20 blackFont whiteText headerTitle']") WebElement actualResult;
	
	public Booking(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver,this);	
	}
	
//---------------------------------------------------  User launches web-site  -----------------------------------------------------------------------	
	
	public void launchApp() throws InterruptedException
	{
		driver.get("https://www.makemytrip.com/flight/search?itinerary=BOM-DEL-01/12/2023&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
		Thread.sleep(10000);
	}

//-----------------------------------------------  User chooses non-stop flight 	----------------------------------------------------------------------
	public void flightStop()
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(close));
        
		close.click();
		nonStop.click();
	}

//-----------------------------------------------  User chooses airline  ----------------------------------------------------------	
	public void flightType() throws InterruptedException
	{
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(type));
        
		type.click();
	}

//--------------------------------------------  User selects the desired flight  ---------------------------------------------------------	
	
	public void selectFlight() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,400)");
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(viewButton));
        
		viewButton.click();		
	}

//-------------------------------------------  User clicks on "Book" button  ------------------------------------------------------------	
	
	public void bookNow() throws InterruptedException, AWTException
	{		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(bookButton));
        
		bookButton.click();
		
		for (String handle : driver.getWindowHandles()) 
		{             
			driver.switchTo().window(handle);         
		}
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(actualResult)); 
	}
	
//
//	public void assertMethod() 
//	{
//	        wait= new WebDriverWait(driver,Duration.ofSeconds(60));
//	        wait.until(ExpectedConditions.elementToBeClickable(actualResult));
//
//	        String text = actualResult.getText();
//	        Assert.assertEquals("Complete your booking",text);
//    }

}
