package it.unisa.test;

import it.unisa.crs.classes.CRS;
import it.unisa.crs.classes.CRSFactory;
import it.unisa.service.classes.Service;
import it.unisa.worker.Creator;
import it.unisa.worker.QueryFactory;
import it.unisa.worker.Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Boot {

	/**
	 * @param args
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {


//		BufferedReader buf = new BufferedReader(new FileReader((Boot.class.getResource("dataset.json")).getPath()));
//		Reader reader = new Reader(buf);
//		Creator factory = new Creator();

//		BufferedReader buf = new BufferedReader(new FileReader((Boot.class.getResource("provaroute.json")).getPath()));
//		Reader reader = new Reader(buf);
//		Creator factory = new Creator();
//
		QueryFactory qf = new QueryFactory();
		
//		JSONObject jsonObject = null; 
//		while ((jsonObject = reader.readNextRoute()) != null) {
//			Object object = factory.create(jsonObject);
//			qf.createInsertQuery(object);
//
//		}
//		BufferedReader buf = new BufferedReader(new FileReader((Boot.class.getResource("station_codes.csv")).getPath()));
//		Reader crsReader = new Reader(buf);
//		String string_crs ; 
//		CRSFactory crsFactory = new CRSFactory();
//		int i = 0;
//		while((string_crs = crsReader.readCRS()) != null){
//			Object crs = crsFactory.createCrs(string_crs);
//			i++;
//			qf.createInsertQuery(crs);
//			System.out.println(crs.toString() + ""+i);
//		}
		
//		GregorianCalendar g= new GregorianCalendar();
//		JSONObject jsonObject = null; 
//		while ((jsonObject = reader.readNext()) != null) {
//			Object object = factory.create(jsonObject);
//			qf.createInsertQuery(object);
//
//		}
//		GregorianCalendar d= new GregorianCalendar();
//
//		System.out.println("Start:"+g.getTime().toString());
//		System.out.println("Stop:"+d.getTime().toString());
		
//		long inizio = System.currentTimeMillis();
//
//		 ArrayList<String> result=qf.selectTrainByHour("1000", "FAVERSHAM","1200");
//
//		long fine = System.currentTimeMillis();
//		System.out.println("Query executed in "+(fine-inizio)+" milliseconds");
//		System.out.println(result.toString());
//		long inizio1 = System.currentTimeMillis();
//
//		 ArrayList<String> result2=qf.selectTrainsByStation("FAVERSHAM");
//
//		long fine2 = System.currentTimeMillis();
//		System.out.println("Query executed in "+(fine2-inizio1)+" milliseconds");
//		System.out.println(result2.toString());
		
//		ArrayList<Service> sr = qf.findServiceAvailable("Monday", "London Victoria", "Faversham");
//		System.out.println(sr);
//		for(Service s : sr){
//			System.out.println(s.toString());
//		}
	}


	

}

