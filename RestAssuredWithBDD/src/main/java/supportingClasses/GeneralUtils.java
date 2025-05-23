package supportingClasses;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class GeneralUtils {

	public static RequestSpecification add_place_request_specification() throws Exception {
		RequestSpecification reqSpec = null;
		try {
			reqSpec = new RequestSpecBuilder().setBaseUri(GlobalConstants.baseURI)
					.addHeader("Content-Type", "application/json").addQueryParam("key", GlobalConstants.keyValue)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reqSpec;
	}

}
