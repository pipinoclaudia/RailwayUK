package it.unisa.service.classes;

import java.util.ArrayList;

public class Service {
	
	private String data;
	private ArrayList<String> service;

	public Service() {
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the service
	 */
	public ArrayList<String> getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(ArrayList<String> service) {
		this.service = service;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Service [data=" + data + ", service=" + service + "]";
	}
	
	
	
	
	
	
	
	

}
