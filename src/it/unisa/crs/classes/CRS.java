package it.unisa.crs.classes;

public class CRS {
	private String crsCode;
	private String crsDes;

	public CRS() {
	}

	/**
	 * @return the crsCode
	 */
	public String getCrsCode() {
		return crsCode;
	}

	/**
	 * @param crsCode the crsCode to set
	 */
	public void setCrsCode(String crsCode) {
		this.crsCode = crsCode;
	}

	/**
	 * @return the crsDes
	 */
	public String getCrsDes() {
		return crsDes;
	}

	/**
	 * @param crsDes the crsDes to set
	 */
	public void setCrsDes(String crsDes) {
		this.crsDes = crsDes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CRS [crsCode=" + crsCode + ", crsDes=" + crsDes + "]";
	}
	
	

}
