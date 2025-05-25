package stepDefinations;

import io.cucumber.java.Before;

public class Hooks {

	
	@Before("@DeletePlace")
	public void generate_place_id_for_delete_api() throws Exception{
		try {
			PlaceStepDefination psd = new PlaceStepDefination();
			if(PlaceStepDefination.place_id == null) {
				String name = "Masion Retreat";
				psd.add_place_api_payload(name, "74B Church Street", "www.gmail.com", "German de_DE");
				psd.user_sends_the_request("AddPlaceResource", "POST");
				psd.in_response_body_is("status", "OK");
				psd.verify_placeId_maps_to_the_name_using_httpRequest(name, "GetPlaceResource", "GET");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
