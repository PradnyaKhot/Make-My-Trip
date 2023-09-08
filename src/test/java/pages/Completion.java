package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Completion 
{
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Valid ft3;
	
	@FindBy(xpath = "//button[text() = 'Yes, Please']") WebElement confirm;
	@FindBy(xpath = "//button[text() = 'CONFIRM']")  WebElement confirmPop;	
	@FindBy(xpath = "//button[text() = 'Continue']") WebElement continueButton;
    @FindBy(xpath = "//button[text() = 'Continue']") WebElement continueClick;
    @FindBy(xpath = "//font[text() = '₹ 900 for 1 Bag']") WebElement baggage;
    @FindBy(xpath = "//button[text() = 'Proceed to pay']") WebElement paymentButton;
    public @FindBy(xpath = "//span[text() = 'Payment options']") WebElement actualResult;
	
	
	public Completion(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver,this);	
	}

//------------------------------------------------  User launches web-site  -------------------------------------------------------------------------
	
	public void launchApp() throws InterruptedException
	{
		driver.get("https://www.makemytrip.com/flights/");
		Thread.sleep(10000);
	}

//-------------------------------------------  User confirms the by-default chosen seat  -------------------------------------------------------------	
	
	public void confirmSeat() throws InterruptedException
	{
		ft3 = new Valid(driver);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)");
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        
		ft3.continueClick();
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(confirmPop));
        
		ft3.popUp();
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(confirm));	
        
		confirm.click();
	}

//----------------------------------------  User clicks on "Continue" button  ----------------------------------------------------------------------------------	
	
	public void continueClick() throws AWTException, InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(continueClick));
        
		continueClick.click();
	}

//---------------------------------------  User chooses baggage free travel  ---------------------------------------------------------------------------------------------	
	
	public void baggageFree() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(baggage));
        
		baggage.click();	
	}

//--------------------------------------  User clicks on "Proceed to pay"  ---------------------------------------------------------------------------------------------	
	
	public void payment() throws InterruptedException
	{		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(paymentButton));		
		paymentButton.click();	
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(actualResult));
		
	}
	
}
