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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class commentsOnPosts {

        private static ResponseOptions<Response> response;

        @Given("A valid user performs POST operation for creating social media comments posts")
        public void validUserCreatesCommentsOnPosts() throws Throwable {
            System.out.println("Database Seeded: You can now start running your tests for /comments API.");

        }
        @When("I perform POST operation to write a comment on particular post")
        public void iPerformPostOperationForCreatingSocialMediaComments() throws Throwable {
            JSONObject requestParams = new JSONObject();
            requestParams.put("postId", 1);
            requestParams.put("id", 1);
            requestParams.put("name", 1);
            requestParams.put("email", 1);
            requestParams.put("body", "In in turpis vulputate, ullamcorper nisi vitae, lacinia enim.");
            String url = "/comments?postId=1";
            response = RestAssuredExtension.PostOps(String.format(url), requestParams.toJSONString());

        }

        @Then("I should receive {int} status code for successful creation of comment")
        public void iShouldReceiveStatusCodeForSuccess(int statusCode) throws Throwable {
            assertThat(response.statusCode(), equalTo(201));
        }

        @And("I should receive an id for successful comment creation as {int}")
        public void iShouldReceiveIdForCreatedComment(int id) throws Throwable {
            int commentId = 501;
            assert response != null;
            assertThat(response.getBody().jsonPath().get("id"), Matchers.<Object>equalTo(commentId));
        }

         @And("I should get the same body as posted in the comment")
         public void iShouldverifybodyForCreatedCommentPost() throws Throwable {
             String commentBody = "In in turpis vulputate, ullamcorper nisi vitae, lacinia enim.";
             assertThat(response.getBody().jsonPath().get("body"), Matchers.<Object>equalTo(commentBody));

         }
    }


