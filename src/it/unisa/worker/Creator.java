package it.unisa.worker;

import it.unisa.route.classes.RouteFactory;
import it.unisa.schedule.classes.JsonScheduleFactory;
import it.unisa.timinglocation.classes.TimingPointLocationFactory;

import java.util.Set;


import org.json.simple.JSONObject;


public class Creator {

	private TimingPointLocationFactory timingFactory = new TimingPointLocationFactory();
	private JsonScheduleFactory scheduleFactory = new JsonScheduleFactory();
	private RouteFactory routeFactory = new RouteFactory();


	public Object create(JSONObject j) {
		Set<String> keys = j.keySet();
		
		for(String key : keys){

			if(key.equals("TiplocV1")) {
				JSONObject nj= (JSONObject) j.get(key);
				return timingFactory.createTimingPointLocation(nj);

			}else if(key.equals("JsonScheduleV1")){
				JSONObject nj = (JSONObject) j.get(key);
				return scheduleFactory.createSchedule(nj);

			} else if(key.equals("routeName")){
				return routeFactory.createRoute(j);
			}

		}

		return null;
	}








}
