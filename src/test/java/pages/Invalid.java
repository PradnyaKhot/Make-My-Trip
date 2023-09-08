package pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Invalid 
{
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Onewaytrip ft;
	Booking ft2;
	
	@FindBy(xpath = "//div[@class = 'insBottomSection']/descendant::span[1]") WebElement insurance;
	@FindBy(xpath = "//*[@id='wrapper_ADULT']/div[3]/div[3]/button") WebElement addButton;
	@FindBy(xpath = "//input[@placeholder = 'Mobile No']") WebElement contact_no;
	@FindBy(xpath = "//input[@placeholder = 'Email']") WebElement mail_id;
	@FindBy(xpath = "//input[@value= 'FEMALE']") WebElement gender;
	public @FindBy(xpath = "//p[text() = 'Please enter a valid Phone Number']") WebElement actualResult1;
	public @FindBy(xpath = "//p[text() = 'Please enter a valid Email ID.']") WebElement actualResult2;

	
	public Invalid(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver,this);	
	}
	
//-----------------------------------------------  User launches the web-site  ------------------------------------------------------------------------------------------
	
	public void launchApp() throws InterruptedException
	{		
	  driver.get("https://www.makemytrip.com/flight/search?itinerary=BOM-DEL-01/12/2023&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
	  Thread.sleep(10000);
	}

//-----------------------------------------------  User chooses insurance  ----------------------------------------------------------------------------------------------	
	
	public void securityOption() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");		
		Thread.sleep(8000);    
		insurance.click();
	}

//----------------------------------------------  User enters contact number  ----------------------------------------------------------------------------------------	
	
	public void contactNo(String contact) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		act.moveToElement(contact_no).click().build().perform();
		contact_no.sendKeys(contact);
	}

//-----------------------------------------------  User enters mail id  -----------------------------------------------------------------------------------------------	
	
	public void mailId(String mail) throws InterruptedException
	{
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		act.moveToElement(mail_id).click().build().perform();		

		mail_id.sendKeys(mail);
		Thread.sleep(4000);
		
		for (String handle : driver.getWindowHandles()) 
		{             
			driver.switchTo().window(handle);         
		}
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(actualResult1)); 
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(actualResult2));
	}
	
}
