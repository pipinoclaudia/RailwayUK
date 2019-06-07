package it.unisa.schedule.classes;


import it.unisa.locationschedule.classes.LocationQuery;
import it.unisa.locationschedule.classes.LocationSchedule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import sql.InsertMYSQL;
import sql.SelectMYSQL;

public class ScheduleQuery {

	private LocationQuery lq;
	private	Connection c;
	public ScheduleQuery(Connection c) {

		this.c = c;
		lq = new LocationQuery(c);
	}

	protected void insert(int i, String s1, String s2, String s3, String s4){
		InsertMYSQL in = new InsertMYSQL(c);
		in.insert("INSERT INTO jsonschedulev1 VALUES('"+i+"', '"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"')");

	}

	public void insertSchedule(JsonSchedule js) {

		this.insert(js.getIdSchedule(), js.getTrainUID(), js.getStart_date(), js.getEnd_date(), js.getStp_indicator());
		if(!(js.getStp_indicator().equals("C")))
			for(LocationSchedule ls : js.getLocations())
				lq.insertLocation(ls, js);

	}

	public String selectTrain(){
		SelectMYSQL se = new SelectMYSQL(c);
		String result = "";
		ResultSet rs = se.select("SELECT train_uid FROM jsonschedulev1 ");
		try {
			while(rs.next()){
				result = result+rs.getString("train_uid");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	public String selectTrainByID(int id, String station){

		SelectMYSQL se = new SelectMYSQL(c);
		String result = "";
		ResultSet rs = se.select("SELECT train_uid FROM jsonschedulev1 WHERE id_schedule = '"+id+"'");
		try {
			rs.next();
			result = rs.getString("train_uid");

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;

	}

	public ArrayList<String> selectAllTrainByUID(String train_uid, String station){

		SelectMYSQL se = new SelectMYSQL(c);
		ArrayList<String> result = new ArrayList<String>();
		ResultSet rs = se.select("SELECT train_uid FROM jsonschedulev1 WHERE train_uid = '"+train_uid+"'");
		try {
			while(rs.next()){
				result.add(rs.getString("train_uid"));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return result;
	}

}
