package stepDefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import org.hamcrest.Matchers;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import utilities.RestAssuredExtension;

public class makepostsStepDefinition {

    private static ResponseOptions<Response> response;

    @Given("A valid user performs POST operation for creating social media posts")
    public void validUserCreatesPosts() throws Throwable {
        System.out.println("Database Seeded: You can now start running your tests for /post API.");

    }
    @When("I perform POST operation using {string}, for the specific user with the following data")
    public void iPerformPostOperationForCreatingSocialMediaPosts(String url) throws Throwable {
        JSONObject requestParams = new JSONObject();
        requestParams.put("userId", 1);
        requestParams.put("Title", "Pinata");
        requestParams.put("body", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed lobortis urna erat, " +
                "ut accumsan quam consectetur sit amet.");
        response = RestAssuredExtension.PostOps(String.format(url), requestParams.toJSONString());

    }

    @Then("I should receive {int} status code for successful creation")
    public void iShouldReceiveStatusCodeForPost(int statusCode) throws Throwable {
        assertThat(response.statusCode(), equalTo(201));
    }

    @And("I should receive an id for successful creation as {int}")
    public void iShouldReceiveIdForCreatedPost(int id) throws Throwable {
        System.out.println( response.body());
        int postId = 101;
        assert response != null;
        assertThat(response.getBody().jsonPath().get("id"), Matchers.<Object>equalTo(postId));
    }
    @And("I should get the same body as posted")
    public void iShouldverifybodyForCreatedPost() throws Throwable {
        String postBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed lobortis urna erat, \" +\n" +
                "                \"ut accumsan quam consectetur sit amet.";
        assertThat(response.getBody().jsonPath().get("body"), Matchers.<Object>equalTo(postBody));

    }
    }
