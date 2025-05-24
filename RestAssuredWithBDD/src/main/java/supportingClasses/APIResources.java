package supportingClasses;

public enum APIResources {

	AddPlaceResource("maps/api/place/add/json"), UpdatePlaceResource("maps/api/place/update/json");

	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
