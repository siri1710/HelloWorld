package Stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {

    @Given("^I have (.*?)$")
    public void iHaveURL(String url) throws Throwable {
        url = "hi";
    }

    @When("^I open the home page$")
    public void iOpenTheHomePage() throws Throwable {
        int x = 3;
    }

    @Then("^I can see the (.*?)$")
    public void iCanSeeTheTitle(String title) throws Throwable {
        title = "XYZ";
    }
}
