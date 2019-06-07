package it.unisa.locationschedule.classes;



public class LocationSchedule {

	private String tiplocCode;
	private String publicArrival;
	private String publicDeparture;
	private String pass;
	
	public LocationSchedule() {
		
	}


	public String getTiplocCode() {
		return tiplocCode;
	}


	public void setTiplocCode(String tiplocCode) {
		this.tiplocCode = tiplocCode;
	}


	public String getPublicArrival() {
		return publicArrival;
	}


	public void setPublicArrival(String publicArrival) {
		this.publicArrival = publicArrival;
	}


	public String getPublicDeparture() {
		return publicDeparture;
	}


	public void setPublicDeparture(String publicDeparture) {
		this.publicDeparture = publicDeparture;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public String toString() {
		return "LocationSchedule [tiplocCode=" + tiplocCode
				+ ", publicArrival=" + publicArrival + ", publicDeparture="
				+ publicDeparture + ", pass=" + pass + "]"+"\n";
	}
	
	




}
