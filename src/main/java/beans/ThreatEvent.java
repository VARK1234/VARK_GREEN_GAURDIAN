package beans;

public class ThreatEvent {

	private Location currentLocation;
	private String threatLevel;
	private String id;
	private ForestAuthority assignee;
	private String status;
	public Location getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getThreatLevel() {
		return threatLevel;
	}
	public void setThreatLevel(String threatLevel) {
		this.threatLevel = threatLevel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ForestAuthority getAssignee() {
		return assignee;
	}
	public void setAssignee(ForestAuthority assignee) {
		this.assignee = assignee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
