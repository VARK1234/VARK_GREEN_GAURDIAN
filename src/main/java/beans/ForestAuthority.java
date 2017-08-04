package beans;

import java.util.ArrayList;
import java.util.List;

public class ForestAuthority {
	
	private String id;
	private Location location;
	private List<String> type = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<String> getType() {
		return type;
	}
	public void setType(List<String> type) {
		this.type = type;
	}

}
