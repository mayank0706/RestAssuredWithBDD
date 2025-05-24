package supportingClasses;

import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class GeneralUtils {

	public static RequestSpecification reqSpec = null;

	// Function to create request specification for add place request
	public static RequestSpecification add_place_request_specification() throws Exception {
		try {
			if (reqSpec == null) {
				PrintStream log = new PrintStream(new FileOutputStream(".//Reports//logging.txt"));
				reqSpec = new RequestSpecBuilder().setBaseUri(GenericFunctions.getPropertyValue("baseUrl"))
						.addHeader("Content-Type", "application/json").addQueryParam("key", GlobalConstants.keyValue)
						.addFilter(RequestLoggingFilter.logRequestTo(log))
						.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reqSpec;
	}

}
