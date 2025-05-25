package supportingClasses;

public enum APIResources {

	AddPlaceResource("maps/api/place/add/json"), UpdatePlaceResource("maps/api/place/update/json"), GetPlaceResource("maps/api/place/get/json"),
	DeletePlaceResource("maps/api/place/delete/json");

	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
