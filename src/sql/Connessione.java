package sql;
import java.sql.Connection;
import java.sql.DriverManager;


public class Connessione {
	
	
	
	public Connessione() {
	
	}

	public Connection connessione(){
		Connection con = null;
      try{
          Class.forName("com.mysql.jdbc.Driver").newInstance();

          String url = "jdbc:mysql://127.0.0.1:3306/railuk";
          con = DriverManager.getConnection(url,"root","");
 
      }
      catch(Exception e){
         System.out.println("Connessione Fallita \n");   
		 System.out.println(e);
      }
      return con;
	}

}
