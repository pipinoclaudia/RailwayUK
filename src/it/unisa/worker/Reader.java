package it.unisa.worker;


import java.io.BufferedReader;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Reader {

	private BufferedReader buf;

	public Reader(BufferedReader buffer) {
		this.buf = buffer;
	}

	public JSONObject readNext() throws IOException, ParseException {
		String s = buf.readLine();
		while(s != null) {	
			if(!(s.indexOf("}}")>-1)){
				String s1 = buf.readLine();
				s = s+s1;
			}else{

				return (JSONObject) new JSONParser().parse(s);
			}
		}

		return null;
	}

	public JSONObject readNextRoute() throws IOException, ParseException {
		String s = null;;
		while((s = buf.readLine())!= null) {	
			//			if(s.equals(null)){
			//				break;
			//			}
			return (JSONObject) new JSONParser().parse(s);

		}

		return null;
	}

	public String readCRS() throws IOException{
		String s = buf.readLine();
		while((s = buf.readLine())!= null) {	
			return s;
		}

		return null;

	}


}
