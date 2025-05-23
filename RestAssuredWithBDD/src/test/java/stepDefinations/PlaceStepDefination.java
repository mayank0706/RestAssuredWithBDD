package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import pojoClasses.AddPlaceResponse;
import supportingClasses.GeneralUtils;
import supportingClasses.GlobalConstants;
import supportingClasses.PayloadCreation;
import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PlaceStepDefination {

	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	Response response;

	@Given("add place api payload")
	public void add_place_api_payload() throws Exception {
		try {
			System.out.println("Given Step");
			requestSpec = given().log().all().spec(GeneralUtils.add_place_request_specification())
					.body(PayloadCreation.generate_add_place_payload());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user sends the post request")
	public void user_sends_the_post_request() throws Exception {
		try {
			System.out.println("When Step");
			responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
					.expectHeader("Server", "Apache/2.4.52 (Ubuntu)").build();
			response = requestSpec.when().post(GlobalConstants.postResource).then().log().all().spec(responseSpec)
					.extract().response();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("status code is {int}")
	public void status_code_is(Integer statusCode) throws Exception {
		try {
			System.out.println("First then step");
			int actualCode = response.getStatusCode();
			if (actualCode == statusCode) {
				System.out.println("Status code in response is correct.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) throws Exception {
		try {
			System.out.println("Second then step");
			String resp = response.asString();
			JsonPath js = new JsonPath(resp);
			Assert.assertEquals(value, js.get(key));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
