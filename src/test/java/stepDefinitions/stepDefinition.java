package stepDefinitions;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Onewaytrip;
import pages.Booking;
import pages.Valid;
import pages.Invalid;
import pages.Completion;
import utils.Screenshot;
import utils.Setup;

public class stepDefinition 
{
	
	WebDriver driver = Setup.chromedriver();
	Onewaytrip trip; 
	Booking book;
	Valid valid;
	Invalid invalid;
	Completion complete;
	
	String first_middle_name;
    String last_name;
    Long   number;
    String contact_no;
    String mail_id; 
    
    FileInputStream fis;
    Properties pro;
	
      
//--------------------------------------------------ONE WAY TRIP----------------------------------------------------------------------------------------------
      
	@Given("the user is on the flight booking page")
	public void the_user_is_on_the_flight_booking_page() throws InterruptedException 
	{
		trip = new Onewaytrip(driver);
		trip.launchApp();	
	}
	
	@When("enters the Departure City")
	public void enters_the_departure_city(io.cucumber.datatable.DataTable dataTable) throws InterruptedException 
	{		
        List<String> cells=dataTable.asList(String.class);
        trip.departureCity(cells.get(0)); 
	}
	
	@And("enters the Destination City")
	public void enters_the_destination_city(io.cucumber.datatable.DataTable dataTable) throws InterruptedException 
	{
	    List<String> cells=dataTable.asList(String.class);
        trip.destinationCity(cells.get(0));        
	}
	
	@And("selects the Departure Date")
	public void selects_the_departure_date(io.cucumber.datatable.DataTable dataTable) throws InterruptedException 
	{
	    List<String> cells=dataTable.asList(String.class);
        trip.deptDate(cells.get(0));   
	}
	
	@And("clicks on the Search button")
	public void clicks_on_the_search_button() throws InterruptedException 
	{		
	    trip.searchButton();    
	}
	
	@Then("the user should see a list of available one-way flights")
	public void the_user_should_see_a_list_of_available_one_way_flights() throws IOException, InterruptedException 
	{
		String text = trip.actualResult.getText();
		Assert.assertEquals("OKAY, GOT IT!",text);
	    Screenshot.captureScreen(driver);
	    Thread.sleep(3000);
	    Setup.teardown();
	}
	
//-------------------------------------------------------BOOKING---------------------------------------------------------------------
	
	@Given("user is on flight search result page")
	public void user_is_on_flight_search_result_page() throws InterruptedException 
	{
		book = new Booking(driver);
		book.launchApp();
	}
	
	@When("user chooses flight with fewest stops")
	public void user_chooses_flight_with_fewest_stops() throws InterruptedException 
	{
	    book.flightStop();
	}
	
	@And("chooses airlines type")
	public void chooses_airlines_type() throws InterruptedException 
	{
	    book.flightType();   
	}
	
	@And("clicks on View Prices button")
	public void clicks_on_view_prices_button() throws InterruptedException 
	{
	    book.selectFlight();
	}
	
	@And("clicks on Book Now button")
	public void clicks_on_book_now_button() throws InterruptedException, AWTException 
	{   
	    book.bookNow();
	}
	
	@Then("user is taken to passenger details page")
	public void user_is_taken_to_passenger_details_page() throws IOException, InterruptedException 
	{
		String text = book.actualResult.getText();
		Assert.assertEquals("Complete your booking",text);
		Screenshot.captureScreen(driver);
		Thread.sleep(3000);
		Setup.teardown();
	}
	
//------------------------------------------------- VALID---------------------------------------------------------------------------------
	
	
	
	@Given("the user is on passenger details page")
	public void the_user_is_on_passenger_details_page() throws InterruptedException, AWTException 
	{
		trip = new Onewaytrip(driver);
		book = new Booking(driver);
		valid = new Valid(driver);
		invalid = new Invalid(driver);
		
		valid.launchApp();
		Thread.sleep(5000);
		trip.departureCity("Mumbai");
		trip.destinationCity("Delhi");
		trip.deptDate("2023-December-01");
		trip.searchButton();
		
		
		book.flightStop();
		book.flightType();
		book.selectFlight();
		book.bookNow();
		
	}
	
	@When("user chooses trip security option")
	public void user_chooses_trip_security_option() throws InterruptedException 
	{
	    valid.securityOption();
	}
	
	@And("user opens an excel sheet and read the values")
	public void user_opens_an_excel_sheet_and_read_the_values() throws IOException 
	{
	   File file = new File("C:\\Users\\PMOHANKH\\eclipse-workspace\\MakeMyTrip\\ExcelData\\Book1.xlsx");

       FileInputStream fis = new FileInputStream(file);
       Workbook w = new XSSFWorkbook(fis);
       Sheet  s = w.getSheetAt(0);

       first_middle_name = s.getRow(1).getCell(0).getStringCellValue();
       last_name = s.getRow(1).getCell(1).getStringCellValue();
       number=(long)s.getRow(1).getCell(2).getNumericCellValue();
       contact_no = String.valueOf(number);
       mail_id = s.getRow(1).getCell(3).getStringCellValue();            
	}
	
	@And("user clicks on add adult")
	public void user_clicks_on_add_adult() throws InterruptedException 
	{
		valid.addTraveller();
	}
	
	@And("user enters first name")
	public void user_enters_first_name() throws InterruptedException 
	{
		valid.firstMiddleName(first_middle_name);
	}
	
	@And("user enters last name")
	public void user_enters_last_name() throws InterruptedException 
	{
		valid.lastName(last_name);
	}
	
	@And("user selects gender")
	public void user_selects_gender() throws InterruptedException 
	{
	   valid.selectGender();
	}
	
	@And("user enters contact number")
	public void user_enters_contact_number() throws InterruptedException 
	{
		valid.contactNo(contact_no);
	}
	
	@And("user enters mail id")
	public void user_enters_mail_id() throws InterruptedException 
	{
	    valid.mailId(mail_id);
	}
	
	@And("user confirms all details")
	public void user_confirms_all_details() throws InterruptedException 
	{
		Thread.sleep(5000);

		valid.confirmDetails();
		valid.continueClick();
		valid.popUp();
	}
	
	@Then("user is taken to continue booking page")
	public void user_is_taken_to_continue_booking_page() throws IOException, InterruptedException 
	{
		String text = valid.actualResult.getText();
		Assert.assertEquals("We have picked a great-value aisle seat for you!",text);
		Screenshot.captureScreen(driver);
		Thread.sleep(3000);
		Setup.teardown();
	}
	
//----------------------------------------------------------INVALID------------------------------------------------------------------------
	
	@Given("the user is on passenger detail page")
	public void the_user_is_on_passenger_detail_page() throws InterruptedException, AWTException
	{
		book = new Booking(driver);
		invalid = new Invalid(driver);
		
		invalid.launchApp();
		
		book.flightStop();
		book.flightType();
		book.selectFlight();
		book.bookNow();
	}
	
	@When("user chooses trip insurance")
	public void user_chooses_trip_insurance() throws InterruptedException 
	{
	    invalid.securityOption();
	}
	
	@And("^user enters contact number as (.*)$")
	public void user_enters_contact_number_as(String contact) throws InterruptedException
	{
		invalid.contactNo(contact);
	}
	
	@And("^user enters mail id as (.*)$")
	public void user_enters_mail_id_as(String mail) throws InterruptedException
	{
	    invalid.mailId(mail);
	}
	
	@Then("error message should be displayed")
	public void error_message_should_be_displayed() throws IOException, InterruptedException 
	{
		String text = invalid.actualResult1.getText();
		Assert.assertEquals("Please enter a valid Phone Number",text);
		Screenshot.captureScreen(driver);
		String text1 = invalid.actualResult2.getText();
		Assert.assertEquals("Please enter a valid Email ID.",text1);		
		Screenshot.captureScreen(driver);
		Assert.assertFalse(false);
		Thread.sleep(3000);
		Setup.teardown();
	}

//------------------------------------------------------ COMPLETION-----------------------------------------------------------------------
	

	@Given("User is on seat booking page")
	public void user_is_on_seat_booking_page() throws InterruptedException, AWTException, IOException 
	{	
		trip = new Onewaytrip(driver);
		book = new Booking(driver);
		valid = new Valid(driver);
		invalid = new Invalid(driver);
		complete = new Completion(driver);
		
		complete.launchApp();
		
		trip.departureCity("Mumbai");
		trip.destinationCity("Delhi");
		trip.deptDate("2023-December-01");
		trip.searchButton();
		
		
		book.flightStop();
		book.flightType();
		book.selectFlight();
		book.bookNow();
		
		Thread.sleep(4000);
		
		valid.securityOption();
		valid.addTraveller();
		
		fis=new FileInputStream("C:\\Users\\PMOHANKH\\eclipse-workspace\\MakeMyTrip\\Object.properties");
		pro=new Properties();
		pro.load(fis);

		Thread.sleep(5000);

		valid.firstMiddleName(pro.getProperty("firstname"));
		valid.lastName(pro.getProperty("lastname"));
		valid.selectGender();
		valid.contactNo(pro.getProperty("contact"));
		valid.mailId(pro.getProperty("mailid"));		
	}
	
	@When("Confirms the seat number")
	public void confirms_the_seat_number() throws InterruptedException 
	{
		
	   try
	   {
		complete = new Completion(driver);
	   } 
	   catch (Exception e) 
	   {	
		e.printStackTrace();
	   }
	   complete.confirmSeat();
	}
	
	@And("Clicks on cotinue button")
	public void clicks_on_cotinue_button() throws AWTException, InterruptedException 
	{
	   complete.continueClick();
	}
	
	@And("Selects baggage free travelling")
	public void selects_baggage_free_travelling() throws InterruptedException 
	{
	    complete.baggageFree();
	}

	@And("Proceeds to pay")
	public void proceeds_to_pay() throws InterruptedException 
	{
	    complete.payment();
	}
	
	@Then("User is taken to payment page")
	public void user_is_taken_to_payment_page() throws IOException, InterruptedException 
	{
		String text = complete.actualResult.getText();
		Assert.assertEquals("Payment options",text);
		Screenshot.captureScreen(driver);
		Thread.sleep(3000);
		Setup.teardown();
	}
}
