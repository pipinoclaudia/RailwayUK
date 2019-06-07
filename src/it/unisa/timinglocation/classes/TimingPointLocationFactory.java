package it.unisa.timinglocation.classes;

import java.util.Set;

import org.json.simple.JSONObject;

public class TimingPointLocationFactory {
	
	public TimingPointLocation createTimingPointLocation(JSONObject obj ){
		
		TimingPointLocation tpl = new TimingPointLocation();
		Set<String> keys = obj.keySet();
		
		for (String k : keys) {
			if(k.equals("tiploc_code"))
				tpl.setTiploc_code((String) obj.get(k));
			else if (k.equals("tps_description"))
				tpl.setTps_description((String) obj.get(k));
		}
		
		return tpl;
	}

}
