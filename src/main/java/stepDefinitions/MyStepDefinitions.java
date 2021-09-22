package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefinitions {
	
	WebDriver driver;
	private static Logger log = Logger.getLogger(MyStepDefinitions.class);
	Properties properties = new Properties();

	@Before
	public void setUp() throws IOException {
		
		 System.setProperty("webdriver.chrome.driver", "//Users//adekoyaadeeko//Downloads//chromedriver");
	        
			// create an object of the chrome browser
			driver = new ChromeDriver();
			log.info("chrome browser object created");
			// maximize chrome browser page
			driver.manage().window().maximize();
			
			// implicit wait for page to load
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.info("implicit wait for 10 seconds");
			
	         // create a file input stream
	        FileInputStream inputStream = new FileInputStream("/Users/adekoyaadeeko/Documents/workspace-spring-tool-suite-4-4.8.1.RELEASE"
	        		+ "/Aspiration-cucumber-demo/src/main/resources/testData.properties");
			// read the file
	        properties.load(inputStream);
	       
	}
	
	 @Given("^Open the chrome browser and visit the homepage$")
	    public void open_the_chrome_browser_and_visit_the_homepage() throws Throwable {
		 
		// get the value of the property using its key 'url'
	        String url = properties.getProperty("url");
	        
	    // get website url
			driver.get(url);
			log.info("opened website");
	    }

	    @When("^User click to accept cookie$")
	    public void user_click_to_accept_cookie() throws Throwable {
	    	
	    	log.info("about to accept cookie");
	    	driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	    	log.info("accepted cookie");
	    	Thread.sleep(4000);
	    	log.info("i slept for 4000ms");
	    }
	    
	    @And("^User navigates to the Spend and Save link and click$")
	    public void user_navigates_to_the_spend_and_save_link_and_click() throws Throwable {
	       
	    	log.info("about to click spend and save");
	      	driver.findElement(By.linkText("Spend & Save")).click();
	      	log.info("clicked spend and save");
	    }

	    @Then("^User should be able to view Products and prices$")
	    public void user_should_be_able_to_view_products_and_prices() throws Throwable {
	      
	    	List<WebElement> element = new ArrayList<>();
	    	element = driver.findElements(By.xpath("//div[@class='plan-content']/h2"));
	    	
	    	// get the product display text
	    	String product1 = element.get(0).getText();
	    	String product2 = element.get(1).getText();
	    	String actualProduct = "Aspiration";
	    	String actualProduct1 = "Aspiration Plus";
	    	log.info(product1);
	    	log.info(product2);
	    	// verify the 2 products using assertEquals 
	    	Assert.assertEquals(actualProduct, product1);
	    	Assert.assertEquals(actualProduct1, product2);
	    }
	    

	    @After
	    public void closePage() {
	    	driver.quit();
	    }

}
