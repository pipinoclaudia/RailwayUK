package it.unisa.schedule.classes;

import it.unisa.locationschedule.classes.LocationSchedule;

import java.util.ArrayList;

public class JsonSchedule {

	
	private int idSchedule;
	private String trainUID;
	private String start_date;
	private String end_date;
	private String stp_indicator;
	private ArrayList<LocationSchedule> locations;
	
	public JsonSchedule() {

	}
	
	public void reset(){
		trainUID="";
		idSchedule=0;
		start_date="";
		end_date="";
		start_date="";
		locations=null;
	}

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	/**
	 * @return the trainUID
	 */
	public String getTrainUID() {
		return trainUID;
	}

	/**
	 * @param trainUID the trainUID to set
	 */
	public void setTrainUID(String trainUID) {
		this.trainUID = trainUID;
	}

	/**
	 * @return the start_date
	 */
	public String getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date the start_date to set
	 */
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return the end_date
	 */
	public String getEnd_date() {
		return end_date;
	}

	/**
	 * @param end_date the end_date to set
	 */
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getStp_indicator() {
		return stp_indicator;
	}

	public void setStp_indicator(String stp_indicator) {
		this.stp_indicator = stp_indicator;
	}

	public ArrayList<LocationSchedule> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<LocationSchedule> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "JsonSchedule [idSchedule=" + idSchedule + ", trainUID="
				+ trainUID + ", start_date=" + start_date + ", end_date="
				+ end_date + ", stp_indicator=" + stp_indicator
				+ ", locations=" + locations + "]";
	}

	
	
	


	
	
	

}
