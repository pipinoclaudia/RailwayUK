package it.unisa.route.classes;

import java.util.ArrayList;
import java.util.Set;

import org.json.simple.JSONObject;

import it.unisa.schedule.classes.JsonSchedule;

public class RouteFactory {
	
	

	public RouteFactory() {
	
		
	}
	
	

	public Route createRoute(JSONObject obj){
		Route route = new Route();
		Set<String> keys = obj.keySet();
		
		for (String k : keys) {
			if(k.equals("routeName")){
				route.setRoute((String)obj.get(k));
				route.setRouteList(createRouteList((String)obj.get(k)));
			}
			else if(k.equals("startDate"))
				route.setStartDate((String)obj.get(k));
			else if(k.equals("endDate"))
				route.setEndDate((String)obj.get(k));
		}
		
		return route;
	}
	
	private ArrayList<String> createRouteList(String route){
		ArrayList<String> r = new ArrayList<>();
		String[] parts = route.split("-");
		
		for (int i = 0; i < parts.length; i++) {
			r.add(parts[i]);
		}
		
		return r;
		
		
	}

}
