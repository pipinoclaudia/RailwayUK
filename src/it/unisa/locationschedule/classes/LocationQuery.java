package it.unisa.locationschedule.classes;

import it.unisa.schedule.classes.JsonSchedule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;

import sql.InsertMYSQL;
import sql.SelectMYSQL;

/**
 * @author Claudia
 *
 */
public class LocationQuery {

	private	Connection c;

	public LocationQuery(Connection c) {
		this.c = c;
	}

	protected void insertLocation(int i, String s1, String s2, String s3, String s4){
		InsertMYSQL in = new InsertMYSQL(c);
		in.insert("INSERT INTO schedule_location VALUES('"+i+"', '"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"')");
	}

	/**
	 * Schedule must be saved into the database and must have a valid id.
	 * @param ls
	 * @param js
	 */
	public void insertLocation(LocationSchedule ls, JsonSchedule js) { 

		try {
			if(selectAnnidate(js) <= 0) throw new IllegalArgumentException("Schedule id must be greater than zero.");
		} catch (MySQLDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!(js.getStp_indicator().equals("C")))
			try {
				this.insertLocation(selectAnnidate(js), ls.getTiplocCode(), ls.getPublicArrival(), ls.getPublicDeparture(), ls.getPass());
			} catch (MySQLDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	public String selectScheduleLoc(){
		String result="";
		SelectMYSQL se = new SelectMYSQL(c);
		ResultSet rs = se.select("SELECT id_schedule, tiploc_code, public_arrival, public_departure, pass FROM schedule_location ");
		if(rs == null) return "Seroius Problem with DB connection";
		try {
			while(rs.next()){
				result = result+rs.getInt("id_schedule")+" "+rs.getString("tiploc_code")+" "+rs.getString("public_arrival")+" "+rs.getString("public_departure")+" "+rs.getString("pass")+"\n";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	
	protected int selectAnnidate(JsonSchedule js) throws MySQLDataException{
		SelectMYSQL se = new SelectMYSQL(c);
		int sele = 0;
		ResultSet rs = se.select("SELECT id_schedule FROM jsonschedulev1 WHERE train_uid = '"+ js.getTrainUID()+"'");
		if(rs == null) throw new MySQLDataException( "Seroius Problem with DB connection");
		try {
			rs.next();
			sele = rs.getInt("id_schedule");

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return sele;

	}



	public ArrayList<Integer> selectIdByTiplocDep(String tiploc, String departure){

		SelectMYSQL se = new SelectMYSQL(c);

		ArrayList<Integer> id_schedule = new ArrayList<Integer>();
		String query="SELECT id_schedule FROM schedule_location WHERE tiploc_code = '"+tiploc+"' AND public_departure = '"+departure+"'";
		ResultSet rs = se.select(query);
		if(rs == null) System.out.println( "Seroius Problem with DB connection");

		try {
			rs.next();
			id_schedule.add(rs.getInt("id_schedule"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id_schedule;

	}


	public ArrayList<String> selectTrainByStationTime(String tps_description, String departureTime, String maxTime ){
		SelectMYSQL se = new SelectMYSQL(c);

		ArrayList<String> train_uids = new ArrayList<String>();
		String query="SELECT DISTINCT `jsonschedulev1`.`train_uid`, `tiplocv1`.`tps_description`, `schedule_location`.`public_departure`"
				+ "FROM `tiplocv1` "
				+ "LEFT JOIN `schedule_location` ON `schedule_location`.`tiploc_code` = `tiplocv1`.`tiploc_code`"
				+ "LEFT JOIN `jsonschedulev1` ON `schedule_location`.`id_schedule` = `jsonschedulev1`.`id_schedule`"
				+ "WHERE ((`tiplocv1`.`tps_description` ='"+tps_description+"') AND (`schedule_location`.`public_departure` >='"+departureTime+"'))"
				+ "AND   (`schedule_location`.`public_departure` <='"+maxTime+"')"
				+ "ORDER BY `schedule_location`.`public_departure` ASC";
		ResultSet rs = se.select(query);
		if(rs == null) System.out.println( "Seroius Problem with DB connection");

		try {
			while(rs.next())
				train_uids.add(rs.getString("train_uid"));

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return train_uids;

	}

	public ArrayList<String> selectTrainsByStation(String station) {
		SelectMYSQL se = new SelectMYSQL(c);
		ArrayList<String> train_schedules = new ArrayList<String>();
		String query="SELECT * FROM schedule_location WHERE id_schedule IN ("
				+ "SELECT id_schedule FROM schedule_location WHERE tiploc_code=("
				+ "SELECT tiploc_code FROM tiplocv1 WHERE tps_description='"+station+"'))";
		ResultSet rs = se.select(query);
		if(rs == null) System.out.println( "Seroius Problem with DB connection");

		try {
			while(rs.next())
				train_schedules.add("(id_schedule:"+rs.getString("id_schedule")+" tiploc_code:"+rs.getString("tiploc_code")+
						"public_departure:" +rs.getString("public_departure")+"public_arrival:" +rs.getString("public_arrival")+"pass:" +rs.getString("pass") );

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return train_schedules;

	}
}




