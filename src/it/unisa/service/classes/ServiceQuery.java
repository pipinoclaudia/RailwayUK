package it.unisa.service.classes;

import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Set;

import sql.SelectMYSQL;


public class ServiceQuery {

	private Connection c;
	
	

	public ServiceQuery(Connection c) {
		this.c = c;
	}
	
	
	public ArrayList<Service> findService(String dayOfWeek, String departureStation, String arrivalStation) throws Exception{
		SelectMYSQL se = new SelectMYSQL(c);

		String depStaCode= "SELECT tiploc_code FROM tiplocv1 WHERE tps_description='"+departureStation+"'";
		
		ArrayList<String> depCodes=new ArrayList<String>();
		ResultSet rs = se.select(depStaCode);
		
		while(rs.next()){
			depCodes.add(rs.getString(1));
		}
		
		String arrStaCode= "SELECT tiploc_code FROM tiplocv1 WHERE tps_description='"+arrivalStation+"'";
		ArrayList<String> arrCodes=new ArrayList<String>();
		rs = se.select(arrStaCode);
		
		while(rs.next()){
			arrCodes.add(rs.getString(1));
		}
	
		CheckSchedule(se,depCodes);
		CheckSchedule(se,arrCodes);
		ArrayList<String> str = new ArrayList<String>();
		for(String s : depCodes){
			for(String a : arrCodes){
				String scheduleQuery="SELECT DISTINCT * FROM (SELECT DISTINCT id_schedule FROM schedule_location where tiploc_code='"+s+"') as a1 " +
						"JOIN (select DISTINCT id_schedule from schedule_location where tiploc_code= '"+a+"' ) as a2" +
						" ON  a1.id_schedule = a2.id_schedule";
				rs = se.select(scheduleQuery);
				while(rs.next()){
					str.add(rs.getString(1));
				}
			}
		}
		HashMap<String, ArrayList<String>> values= new HashMap<>();
		
		
			
		String train_uid;
		GregorianCalendar startDate;
		GregorianCalendar endDate;
		String stp;


		for(String s: str){
			String scheduleQuery="SELECT * FROM `jsonschedulev1` WHERE `id_schedule`='"+s+"'";
			rs = se.select(scheduleQuery);
			GregorianCalendar actualDate;
			while(rs.next()){
				train_uid= rs.getString("train_uid");
				startDate=makeDate(rs.getString("start_date"));
				endDate=makeDate(rs.getString("end_date"));
				stp=rs.getString("stp_inidicator");
				actualDate=(GregorianCalendar)startDate.clone();
				firstDayOccurence(actualDate, dayOfWeek);
				while(actualDate.before(endDate)&&actualDate.after(startDate)){
					String data="train: "+train_uid+" Start:"+dateToString(startDate)+" End: "+dateToString(endDate)+" STP : "+stp;
					if(!values.containsKey(dateToString(actualDate))){
						ArrayList<String> list=new ArrayList<String>();
						list.add(data);
						values.put(dateToString(actualDate),list);
					} else{
						values.get(dateToString(actualDate)).add(data);
					}
					nextWeekDay(actualDate);
				}

			}
		}

		return makeArrayService(values);

	}
	
	private ArrayList<Service> makeArrayService(HashMap<String, ArrayList<String>> values){
		
		ArrayList<Service> services = new ArrayList<>();
		Set<String> keys = values.keySet();
		
		for(String k : keys){
			Service ser = new Service();
			ser.setData(k);
			ser.setService(values.get(k));
			services.add(ser);
			
		}
		
		return services;
		
	}
	
	
	private String dateToString(GregorianCalendar data){
		return ""+data.get(Calendar.YEAR)+"/"+(data.get(Calendar.MONTH)+1)+"/"+data.get(Calendar.DAY_OF_MONTH);
	}

	private void nextWeekDay(GregorianCalendar date){
		date.add(Calendar.DAY_OF_MONTH, 7);
	}
	private void firstDayOccurence(GregorianCalendar start, String day) throws Exception {
		int dayOfWeek=0;
		switch (day.toUpperCase()) {
		case "MONDAY": dayOfWeek=2; break;
		case "TUESDAY": dayOfWeek=3; break;
		case "WEDNESDAY": dayOfWeek=4; break;
		case "THURSDAY": dayOfWeek=5; break;
		case "FRIDAY": dayOfWeek=6; break;
		case "SATURDAY": dayOfWeek=7; break;
		case "SUNDAY": dayOfWeek=1; break;
		default: throw new Exception("Unable to understand day inserted");
		}
		while(start.get(Calendar.DAY_OF_WEEK)!=dayOfWeek){
			start.add(Calendar.DATE, 1);
		}
	}

	private void CheckSchedule(SelectMYSQL se, ArrayList<String> list){
		ResultSet result;
		int size= list.size();
		for(int i=0;i<size;i++){
			String e=list.remove(0);
			result=se.select("SELECT DISTINCT id_schedule FROM schedule_location where tiploc_code='"+e+"'");
			try{
				result.last();
				if(result.getRow()!=0)
					list.add(e);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public GregorianCalendar makeDate(String data){

		String[] a = data.split("-");

		GregorianCalendar date = new GregorianCalendar(Integer.parseInt(a[0]), Integer.parseInt(a[1])-1, Integer.parseInt(a[2]));

		return date;
	}
}
