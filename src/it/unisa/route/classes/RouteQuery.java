package it.unisa.route.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;

import sql.InsertMYSQL;
import sql.SelectMYSQL;

public class RouteQuery {
	
	private	Connection c;

	public RouteQuery(Connection c) {
		this.c = c;
	}
	
	public void insertRouteSchedule(Route route){
		
		this.insertRouteSchedule(route.getId_route(), route.getRoute(), route.getStartDate(), route.getEndDate());
		this.insertRoute(route);
		
	}
	
	protected void insertRouteSchedule(int i, String r, String s, String e){
		InsertMYSQL in = new InsertMYSQL(c);
		in.insert("INSERT INTO route_schedule VALUES('"+i+"', '"+r+"', '"+s+"', '"+e+"')");
	}
	
	protected void insertRoute(int i, String code){
		InsertMYSQL in = new InsertMYSQL(c);
		in.insert("INSERT INTO route VALUES('"+i+"', '"+code+"')");
	}
	
	public void insertRoute(Route r){
		try {
			int id_route = selectAnnidate(r);
			if(id_route <= 0) throw new IllegalArgumentException("Schedule id must be greater than zero.");
			for(String s : r.getRouteList()){
				this.insertRoute(id_route, s);
				
			}
		} catch (MySQLDataException e) {
			
			e.printStackTrace();
		}
	}
	
	protected int selectAnnidate(Route r) throws MySQLDataException{
		SelectMYSQL se = new SelectMYSQL(c);
		int sele = 0;
		String sql = "SELECT id_route FROM route_schedule WHERE route_des = '"+ r.getRoute()+"' AND start_date ='"+r.getStartDate()+"' AND end_date = '"+r.getEndDate()+"'";
		ResultSet rs = se.select(sql);
		
		if(rs == null) throw new MySQLDataException( "Seroius Problem with DB connection");
		try {
			rs.next();
			sele = rs.getInt("id_route");

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return sele;

	}

}
