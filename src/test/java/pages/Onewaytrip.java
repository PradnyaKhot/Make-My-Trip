package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Onewaytrip 
{
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//label[@for = 'fromCity']") WebElement fromClick;
	@FindBy(xpath = "//input[@placeholder = 'From']") WebElement departure;
	@FindBy(xpath = "//div[text()='BOM']") WebElement selectDept;
	@FindBy(xpath = "//label[@for = 'toCity']") WebElement toClick;
	@FindBy(xpath = "//input[@placeholder = 'To']") WebElement destination;
	@FindBy(xpath = "//div[text() = 'DEL']") WebElement selectDest;
	@FindBy(xpath = "//label[@for = 'departure']") WebElement dateClick;
	@FindBy(xpath = "//span[@aria-label = 'Next Month']") WebElement arrowButton;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div") WebElement currentDate;
	@FindBy(xpath = "//div[@aria-label= 'Fri Dec 01 2023']") WebElement dayClick;
	@FindBy(xpath = "//a[text() = 'Search']") WebElement search;
    public	@FindBy(xpath = "//button[text() = 'OKAY, GOT IT!']") WebElement actualResult;
	
	public Onewaytrip(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver,this);		
	}
	
//----------------------------------------------  User launches the web-site  --------------------------------------------------------
	
	public void launchApp() throws InterruptedException
	{
		driver.get("https://www.makemytrip.com/flights/");
		Thread.sleep(10000);
	}

//---------------------------------------------  User selects departure city  ------------------------------------------------------------
	
	public void departureCity(String dept) 
	{	
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(fromClick));
        
		fromClick.click();
		departure.sendKeys(dept);
		selectDept.click();
	}

//---------------------------------------------  User selects destination city  --------------------------------------------------------------	
	
	public void destinationCity(String dest)
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(toClick));
             
		toClick.click();
		destination.sendKeys(dest);
		selectDest.click();
	}

//--------------------------------------------   User selects departure date  ---------------------------------------------------------------	
	public void deptDate(String date) throws InterruptedException
	{
		
		String deptDate[] = date.split("-");
		
		String y = deptDate[0];
		String m = deptDate[1];
		String d = deptDate[2];
				
		while(true)
	    {
		  Thread.sleep(5000);
		  String dt = currentDate.getText();
		
		  String arr[] = dt.split(" ");

		  String month = arr[0];
		  String year = arr[1];
		  
		  if(month.equalsIgnoreCase(m) && year.equals(y)) 
		  {
			 break; 
		  }
		  else
		  {	  	 
			 arrowButton.click();				 
		  }		
	    }  

		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(dayClick));
		dayClick.click();		
	}

//---------------------------------------------  User clicks on "Search" button  ----------------------------------------------------------	
	
	public void searchButton() throws InterruptedException
	{
		search.click();
		Thread.sleep(4000);
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(actualResult));    
	}
	
}
