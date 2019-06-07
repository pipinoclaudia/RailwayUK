package it.unisa.locationschedule.classes;


import java.util.ArrayList;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ScheduleLocationFactory {


	public ArrayList<LocationSchedule> createLocationSchedule(JSONArray arrObj){
		

		ArrayList<LocationSchedule> locs = new ArrayList<LocationSchedule>();
		for(Object jo : arrObj){
			LocationSchedule ls = new LocationSchedule();
			locs.add(createLocationSchedule((JSONObject)jo, ls));

		}
		return locs;

	}

	protected LocationSchedule createLocationSchedule(JSONObject obj, LocationSchedule ls){

		Set<String> keys = obj.keySet();

		for (String k : keys) {
			if(k.equals("tiploc_code"))
				ls.setTiplocCode((String) obj.get(k));
			else if (k.equals("public_arrival"))
				ls.setPublicArrival((String) obj.get(k));
			else if (k.equals("public_departure"))
				ls.setPublicDeparture((String) obj.get(k));
			else if(k.equals("pass") &&((String) obj.get(k) !=null) )
				ls.setPass((String) obj.get(k));

		}

		return ls;
	}
}
