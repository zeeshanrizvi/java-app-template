package echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**

 */
public class ExecutorTasks implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public ExecutorTasks(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
    	
        //ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
         
        //Task task = new Task(serverText);
        //executor.execute(task);         
    	
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            /*output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +
this.serverText + " - " +
time +
"").getBytes());*/
            output.write(("from WorkerRunnable: " +
            		this.serverText + " - " +
            		time +
            		"").getBytes());
            output.close();
            input.close();
            System.out.println("| " + new Timestamp(new Date().getTime()) + " | EXECUTOR | Request from " + clientSocket + " Processed |");
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}