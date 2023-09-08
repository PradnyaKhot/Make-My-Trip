package pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Valid 
{
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
		
	@FindBy(xpath = "//div[@class = 'insBottomSection']/descendant::span[1]") WebElement insurance;
	@FindBy(xpath = "//button[@class = 'addTravellerBtn'] ") WebElement addButton;
	@FindBy(xpath = "//input[@placeholder = 'First & Middle Name']") WebElement first_middle_name;
	@FindBy(xpath = "//input[@placeholder = 'Last Name']") WebElement last_name;
	@FindBy(xpath = "//input[@placeholder = 'Mobile No']") WebElement contact_no;
	@FindBy(xpath = "//input[@placeholder = 'Email']") WebElement mail_id;
	@FindBy(xpath = "//input[@value= 'FEMALE']") WebElement gender;
	@FindBy(xpath = "//p[text()='Confirm and save billing details to your profile']") WebElement confirm;
	@FindBy(xpath = "//button[text() = 'Continue']") WebElement continueButton;
	@FindBy(xpath = "//button[text() = 'CONFIRM']")  WebElement confirmPop;
	public @FindBy(xpath = "//p[text() = 'We have picked a great-value aisle seat for you!']") WebElement actualResult;
	
	
	public Valid(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver,this);	
	}

//------------------------------------------------  User launches the web-site  ----------------------------------------------------------------	
	
	public void launchApp() throws InterruptedException
	{
		driver.get("https://www.makemytrip.com/flights/");
		Thread.sleep(10000);
	}
	
//----------------------------------------------  User chooses insurance  ----------------------------------------------------------------------
	
	public void securityOption() throws InterruptedException
	{
	    Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(8000);      
		insurance.click();
	}

//-------------------------------------------  User adds traveller's details  ------------------------------------------------------------------	
	
	public void addTraveller() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		Thread.sleep(8000);
        
		addButton.click();
	}
	
//------------------------------------------  User enters first name  --------------------------------------------------------------------------
	
	public void firstMiddleName(String fmName) throws InterruptedException
	{
		Thread.sleep(5000);   
		
		Actions act=new Actions(driver);
		act.moveToElement(first_middle_name).click().build().perform();		
		
		first_middle_name.sendKeys(fmName);
	}
	
//------------------------------------------  User enters last name  -----------------------------------------------------------------------------------------	
	
	public void lastName(String lName) throws InterruptedException
	{
		Thread.sleep(4000);
		
		Actions act=new Actions(driver);
		act.moveToElement(last_name).click().build().perform();

		last_name.sendKeys(lName);

	}
	
//------------------------------------------  User selects gender  -------------------------------------------------------------------------------------------
	
	public void selectGender() throws InterruptedException
	{
		Thread.sleep(6000);
		
		Actions act=new Actions(driver);
		act.moveToElement(gender).click().build().perform();		
	}
	
//------------------------------------------  User enters contact number  --------------------------------------------------------------------------------------------
	
	public void contactNo(String contact) throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	
		Thread.sleep(5000);
		
		Actions act=new Actions(driver);
		act.moveToElement(contact_no).click().build().perform();

		contact_no.sendKeys(contact);
	}

//------------------------------------------  User enters mail id  ----------------------------------------------------------------------------------------------------
	
	public void mailId(String mail) throws InterruptedException
	{
		Thread.sleep(5000);
        
		Actions act=new Actions(driver);
		act.moveToElement(mail_id).click().build().perform();

		mail_id.sendKeys(mail);
	}
	
//----------------------------------------  User confirms all the details  ----------------------------------------------------------------------------------------------
	
	public void confirmDetails() throws InterruptedException
	{
		Thread.sleep(7000);
		
		Actions act=new Actions(driver);
		act.moveToElement(confirm).click().build().perform();
		
		Thread.sleep(10000);
	}
	
//---------------------------------------  User clicks on "Continue" button  --------------------------------------------------------------------------------------------------------
	
	public void continueClick() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		
		Thread.sleep(5000);
		
		continueButton.click();		
	}
	
//---------------------------------------  User confirms details in pop-up  ----------------------------------------------------------------------------------------------
	
	public void popUp() throws InterruptedException
	{
		Thread.sleep(7000);
		confirmPop.click();
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(actualResult)); 
	}
	
}
