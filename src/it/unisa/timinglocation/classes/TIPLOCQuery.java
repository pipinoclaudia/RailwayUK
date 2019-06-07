package it.unisa.timinglocation.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import sql.InsertMYSQL;
import sql.SelectMYSQL;


public class TIPLOCQuery {

	private Connection c;

	public TIPLOCQuery(Connection c) {

		this.c = c;

	}



	protected void insert(String s1, String s2){
		InsertMYSQL in = new InsertMYSQL(c);
		in.insert("INSERT INTO tiplocv1 VALUES('"+s1+"', '"+s2+"')");
	}

	public void insertTIPLOC(TimingPointLocation tpl) {
		String s = tpl.getTps_description();

		String s1 = "'";
		char l = s1.charAt(0);
		String r =  s.replace(l, ' ' );

		this.insert(tpl.getTiploc_code(), r);

	}

	public String selectStation(){
		SelectMYSQL se = new SelectMYSQL(c);
		String result = "";
		ResultSet rs = se.select("SELECT tps_description FROM tiplocv1 ");
		try {
			while(rs.next()){
				result = result+rs.getString("tps_description")+"\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	public String selectTIPLOC(String location){
		SelectMYSQL se = new SelectMYSQL(c);
		String result = "";
		ResultSet rs = se.select("SELECT tiploc_code FROM tiplocv1 WHERE tps_description = '"+location+"'");
		try {
			rs.next();
			result = rs.getString("tiploc_code");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
