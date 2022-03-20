package echo;

//import java.net.*; 
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.snmp4j.PDU;
import org.snmp4j.smi.OID;


public class Main {

	static {
        System.setProperty("log4j.xml", "log4j-alternate.xml");
    }
	 private static final Logger logger = LogManager.getLogger(Main.class);
	 
	 
	 public static void main(String[] args) throws IOException 
	   { 
		 
		 ThreadPooledServer server = new ThreadPooledServer(4444);
		 
		 // starting server thread
		 new Thread(server).start();
	     //System.out.println("Server started successfully..");
	     logger.trace("server just started!");
	     
	     
	     // Only monitor thread as of now. Pool open to start any other threads.
	     ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	     MonitorTasks monitor= new MonitorTasks("MONITOR");
	     executor.execute(monitor);

	   } 
} 
