package it.unisa.worker;

import java.sql.Connection;
import java.util.ArrayList;

import sql.Connessione;
import it.unisa.crs.classes.CRS;
import it.unisa.crs.classes.CRSQuery;
import it.unisa.locationschedule.classes.LocationQuery;
import it.unisa.route.classes.Route;
import it.unisa.route.classes.RouteQuery;
import it.unisa.schedule.classes.JsonSchedule;
import it.unisa.schedule.classes.ScheduleQuery;
import it.unisa.service.classes.Service;
import it.unisa.service.classes.ServiceQuery;
import it.unisa.timinglocation.classes.TIPLOCQuery;
import it.unisa.timinglocation.classes.TimingPointLocation;

public class QueryFactory {

	private Connessione conn ;
	protected	Connection c;
	

	public QueryFactory() {
		conn = new Connessione();
		c = conn.connessione();
		
	}

	public void createInsertQuery(Object obj){

		if(obj instanceof JsonSchedule){
			ScheduleQuery sq = new ScheduleQuery(c);
			sq.insertSchedule((JsonSchedule) obj);
		} else if(obj instanceof TimingPointLocation ){
			TIPLOCQuery tp = new TIPLOCQuery(c);
			tp.insertTIPLOC((TimingPointLocation)obj);
		} else if(obj instanceof Route){
			RouteQuery rq = new RouteQuery(c);
			rq.insertRouteSchedule((Route)obj);
		} else if(obj instanceof CRS){
			CRSQuery cq = new CRSQuery(c);
			cq.insertCRS((CRS)obj);
		}

		

	}
/*   
	public void createSelectAll(){


		ScheduleQuery sq = new ScheduleQuery(c);
		sq.selectTrain();

		TIPLOCQuery tp = new TIPLOCQuery(c);
		tp.selectStation();

		LocationQuery lq  = new LocationQuery(c);
		lq.selectScheduleLoc();
	}*/
	
	public ArrayList<String> selectTrainsByStation(String station){
		LocationQuery lc= new LocationQuery(c);
		return lc.selectTrainsByStation(station);
	}
	public ArrayList<String> selectTrainByHour(String startHour, String station, String endHour){

		LocationQuery lc= new LocationQuery(c);
		return lc.selectTrainByStationTime(station, startHour, endHour);

	}
	
	public ArrayList<Service> findServiceAvailable(String dayOfWeek, String departureStation, String arrivalStation){
		
		ServiceQuery sw = new ServiceQuery(c);
		try {
			return sw.findService(dayOfWeek, departureStation, arrivalStation);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public void matchingSchedule(){
		
	}
	
	
	
	


}
