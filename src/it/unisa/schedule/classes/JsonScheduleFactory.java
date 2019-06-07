package it.unisa.schedule.classes;

import it.unisa.locationschedule.classes.ScheduleLocationFactory;

import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonScheduleFactory {
	
	private ScheduleLocationFactory locationFactory ;
	
	
	
	public JsonScheduleFactory() {
		locationFactory = new ScheduleLocationFactory();
	}


	public JsonSchedule createSchedule(JSONObject obj){
		JsonSchedule js = new JsonSchedule();
		Set<String> keys = obj.keySet();

		for (String k : keys) {
			if(k.equals("CIF_train_uid"))
				js.setTrainUID((String) obj.get(k));
			
			else if (k.equals("schedule_start_date"))
				js.setStart_date((String) obj.get(k));
			
			else if (k.equals("schedule_end_date"))
				js.setEnd_date((String) obj.get(k));
			
			else if(k.equals("CIF_stp_indicator"))
				js.setStp_indicator((String) obj.get(k));
			
			else if(k.equals("schedule_segment")){
				JSONObject nj = (JSONObject) obj.get(k);
				Set<String> nkeys = nj.keySet();
				for(String key : nkeys){
					if(key.equals("schedule_location")){
						JSONArray jsonArray = (JSONArray) nj.get(key);
						js.setLocations(locationFactory.createLocationSchedule(jsonArray));
					}

				}

			}


		}
		return js;

	}
}