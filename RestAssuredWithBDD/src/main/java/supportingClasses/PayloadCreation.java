package supportingClasses;

import java.util.ArrayList;
import java.util.List;

import pojoClasses.AddPlace;
import pojoClasses.LocationAttributes;

public class PayloadCreation {
	
	public static AddPlace generate_add_place_payload(String name, String address, String website, String language) throws Exception{
		AddPlace ap = new AddPlace();
		try {
			// Serialization
			ap.setAccuracy(50);
			ap.setName(name);
			ap.setPhoneNum("(+91) 9654228311");
			ap.setAddress(address);
			ap.setWebsite(website);
			ap.setLanguage(language);
			List<String> types = new ArrayList<String>();
			types.add("App Store");
			types.add("Court");
			types.add("Mansion");
			ap.setTypes(types);
			LocationAttributes la = new LocationAttributes();
			la.setLat(-40.234576);
			la.setLng(33.427632);
			ap.setLocation(la);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ap;
	}

}
