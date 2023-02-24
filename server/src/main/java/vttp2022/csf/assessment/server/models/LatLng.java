package vttp2022.csf.assessment.server.models;

import org.bson.Document;

// Do not modify this class
public class LatLng {
	private float latitude;
	private float longitude;

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLatitude() {
		return this.latitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLongitude() {
		return this.longitude;
	}

	public static LatLng create(Document doc) {
		LatLng ll = new LatLng();
		ll.setLatitude(doc.getLong("address.coord.0"));
		ll.setLongitude(doc.getLong("address.coord.1"));
		return ll;
	}
}
