package echo;


import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.sql.Timestamp;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class checkhealth extends TimerTask {
    private String name;
	private Timer timer;

	public checkhealth(String name,Timer timer) {
		   this.name = name;
		   this.timer = timer;
	}

	public void run() {
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		float memoryUsed=(float)(( Runtime.getRuntime().totalMemory()) - Runtime.getRuntime().freeMemory() )/ ( Runtime.getRuntime().totalMemory()) * 100 ;
		System.out.println("| " + new Timestamp(new Date().getTime()) + " | " + name +" | % memory used: " + memoryUsed + " | " + "% load " + operatingSystemMXBean.getSystemLoadAverage() + " |");
	}
}


public class MonitorTasks implements Runnable {
    private String name;
 
    public MonitorTasks(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void run() {
        try {
            Timer timer = new Timer();
            timer.schedule(new checkhealth(name,timer), 0, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}