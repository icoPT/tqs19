package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

public class Stepdefs {

    private String today;
    private String actualAnswer;


    @Given("^today is Sunday$")
    public void today_is_Sunday() throws Exception {
        today = "Sunday";
    }


    @Given("^today is Friday$")
    public void today_is_Friday() {
        this.today = "Friday";
    }

    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String today) {
        this.today = today;
    }


    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() throws Exception {
        actualAnswer = WeekdayVerifier.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) throws Exception {
        assertEquals(expectedAnswer, actualAnswer);
    }


}

