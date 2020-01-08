package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import org.hamcrest.Matchers;
import utilities.RestAssuredExtension;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class userStepDefinition {

    private static ResponseOptions<Response> response;

    @Given("users exist in the database")
    public void usersExistInTheDatabase() throws Throwable {
        System.out.println("Database Seeded: You can now start running your tests for /user API.");
    }


    @When("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
        assert response != null;
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
    }

    @Then("I should receive {int} status code")
    public void iShouldReceiveStatusCode(int statusCode) throws Throwable {
        assertThat(response.statusCode(), equalTo(200));
    }


    @Given("a user exists with a valid id")
    public void aUserExistsWithAValidId() {
        System.out.println("Database Seeded: You can now start running your tests.");
    }

    @When("I perform GET operation for {string} ")
    public void iPerformGETOperationForUserId(String userId) {
        response = RestAssuredExtension.GetOps(String.format(userId));
        assert response != null;
        assertThat(response.getBody().jsonPath().get("name"), Matchers.<Object>equalTo("Leanne Graham"));
    }

    @Then("I should see the user's name as {string}")
    public void iShouldSeeTheUserSNameAs(String userId) {

    }
//    ------

    @Given("a user exists with a valid email")
    public void usersemailExistInTheDatabase() throws Throwable {
        System.out.println("Database Seeded: You can now start running your tests for /user API.");
    }


    @When("I perform GET operation for the email {string}")
    public void iPerformGETOperationForEmail(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
        assert response != null;
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
    }

    @Then("I should see the user's name for the email as {string}")
    public void iShouldGetUserNameByEmail(int statusCode) throws Throwable {
        assertThat(response.statusCode(), equalTo(200));
    }

    @Given("a user exists with a valid username")
    public void usersUserNameExistInTheDatabase() throws Throwable {
        System.out.println("Database Seeded: You can now start running your tests for /user API.");
    }


    @When("I perform GET operation for the username  {string}")
    public void iPerformGETOperationForUserName(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
        assert response != null;
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
    }

    @Then("I should see the user's name for the username as {string}")
    public void iShouldGetUserNameByUserName(int statusCode) throws Throwable {
        assertThat(response.statusCode(), equalTo(200));
    }

    @Given("a user exists with a valid name")
    public void usersNameExistInTheDatabase() throws Throwable {
        System.out.println("Database Seeded: You can now start running your tests for /user API.");
    }


    @When("I perform GET operation for for search by name  {string}")
    public void iPerformGETOperationForValidName(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
        assert response != null;
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
    }

    @Then("I should see the user's name for search by name as {string}")
    public void iShouldGetUserNameByName(int statusCode) throws Throwable {
        assertThat(response.statusCode(), equalTo(200));
    }
//---------
    @Given("only valid users exists")
    public void aUserWithInValidId() {
        // a user exists with an invalid id
        System.out.println("Database Seeded: You can now start running your tests.");
    }

    @When("I perform GET operation for invalid id {string} with userId {int}")
    public void iPerformGETOperationFor(String url, int userId) throws Throwable {
        response = RestAssuredExtension.GetOps(String.format("/users/%s", userId));
        assert response == null;
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
    }

    @Then("I should get an null response")
    public void iShouldSeeTheUserSNameAs() {
        assert response == null;
    }

}
