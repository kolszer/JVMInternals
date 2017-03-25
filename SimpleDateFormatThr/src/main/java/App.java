import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");;
	public static void main(String[] args)  {
		System.out.println("safeThr(): ");
		safeThr();
		System.out.println("unSafeThr(): ");
		unSafeThr();
	}	
	
	public static void safeThr()
	{
	    ExecutorService executor = Executors.newFixedThreadPool(16);
	    for (int i = 0; i < 16; i++) {
	        executor.submit(new Runnable() {
	            public void run() {
	            	Date date = new Date();
	                try {
	                	synchronized(sdf){
	                		System.out.println(sdf.parse("12/11/2006"));
	                	}
					} catch (ParseException e) {
						e.printStackTrace();
					}
	            }
	        });
	    }
	    executor.shutdown();
        while (!executor.isTerminated()) {}
	}
	
	
	public static void unSafeThr()
	{
	    ExecutorService executor = Executors.newFixedThreadPool(16);
	    for (int i = 0; i < 16; i++) {
	        executor.submit(new Runnable() {
	            public void run() {
	            	Date date = new Date();
	                try {
						System.out.println(sdf.parse("12/11/2006"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
	            }
	        });
	    }
	    executor.shutdown();
        while (!executor.isTerminated()) {}
	}
}
