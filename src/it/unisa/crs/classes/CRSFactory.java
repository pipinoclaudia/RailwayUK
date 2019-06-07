package it.unisa.crs.classes;

public class CRSFactory {

	public CRSFactory() {
	}

	
	public CRS createCrs(String crsString)throws NullPointerException{
		
		String p[] = crsString.split(",");
		
		CRS crs = new CRS();
		
		crs.setCrsDes(p[0]);
		crs.setCrsCode(p[1]);
		
		if(crs.equals(null)){
			throw new NullPointerException("CRS is Null");
		}
		
		return crs;
	}
	
	

}
