package stepDefinitions;


import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PageSteps {
	
	
	
	private static Logger log = Logger.getLogger(PageSteps.class);
	String message = "I'm here";
	
	
		@Given("^Products page after clicking spend and save link$")
	    public void products_page_after_clicking_spend_and_save_link() throws Throwable {
	    
		 log.info(message);
	    }

	    @When("^User click on Get Aspiration$")
	    public void user_click_on_get_aspiration() throws Throwable {
	    	System.out.println(message);
	    }

	    @Then("^A modal containing an input field for email address to sign up appears$")
	    public void a_modal_containing_an_input_field_for_email_address_to_sign_up_appears() throws Throwable {
	    	 log.info(message);
	    }

	   
}
