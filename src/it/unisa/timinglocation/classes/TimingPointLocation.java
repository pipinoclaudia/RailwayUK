package it.unisa.timinglocation.classes;

public class TimingPointLocation {
	private String tiploc_code;
	private String tps_description;
	
	
	public TimingPointLocation() {
	
	}
	/**
	 * @return the tiploc_code
	 */
	public String getTiploc_code() {
		return tiploc_code;
	}


	/**
	 * @param tiploc_code the tiploc_code to set
	 */
	public void setTiploc_code(String tiploc_code) {
		this.tiploc_code = tiploc_code;
	}


	/**
	 * @return the tps_description
	 */
	public String getTps_description() {
		return tps_description;
	}


	/**
	 * @param tps_description the tps_description to set
	 */
	public void setTps_description(String tps_description) {
		this.tps_description = tps_description;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TimingPointLocation [tiploc_code=" + tiploc_code
				+ ", tps_description=" + tps_description + "]";
	}
	

	

}
