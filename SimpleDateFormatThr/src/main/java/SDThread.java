import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SDThread implements Runnable {
	private SimpleDateFormat format;
	private int day;
	
    	public void run() {
    		try {
    			String date = "12/"+day+"/2006";
    			System.out.println("day: " + day +", format.parse(date): " + format.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	}
    
    	public SDThread(int day, SimpleDateFormat format)
    	{
    		this.day=day;
    		this.format=format;
    	}
}
