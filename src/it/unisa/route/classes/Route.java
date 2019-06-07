package it.unisa.route.classes;

import java.util.ArrayList;

public class Route {

	private ArrayList<String> routeList;
	private String route;
	private String startDate;
	private String endDate;
	private int id_route;
	
	


	public Route() {

	}

	


	/**
	 * @return the id_route
	 */
	public int getId_route() {
		return id_route;
	}




	/**
	 * @param id_route the id_route to set
	 */
	public void setId_route(int id_route) {
		this.id_route = id_route;
	}




	/**
	 * @return the routeList
	 */
	public ArrayList<String> getRouteList() {
		return routeList;
	}



	/**
	 * @param routeList the routeList to set
	 */
	public void setRouteList(ArrayList<String> routeList) {
		this.routeList = routeList;
	}



	/**
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}



	/**
	 * @param route the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
	}



	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Route [routeList=" + routeList + ", route=" + route + ", startDate=" + startDate + ", endDate="
				+ endDate + ", id_route=" + id_route + "]";
	}








}
