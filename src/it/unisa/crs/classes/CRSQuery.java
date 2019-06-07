package it.unisa.crs.classes;

import java.sql.Connection;

import sql.InsertMYSQL;

public class CRSQuery {
	
	private	Connection c;

	public CRSQuery(Connection c) {

		this.c = c;
	}
	
	
	public void insertCRS(CRS crs){
		String s = crs.getCrsDes();

		String s1 = "'";
		char l = s1.charAt(0);
		s =  s.replace(l, ' ' );
		
		this.insertCRS(crs.getCrsCode(), s);
	}
	
	protected void insertCRS(String code, String des){
		InsertMYSQL in = new InsertMYSQL(c);
		in.insert("INSERT INTO crs_code VALUES('"+code+"', '"+des+"')");
		
		
		
	}
	
}
