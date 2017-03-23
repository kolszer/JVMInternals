import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	public static void main(String[] args)  {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		//SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        	for (int i = 0; i < 4; i++) {
        		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            		Runnable worker = new SDThread(i+1,format);
            		executorService.execute(worker);
        	}
		executorService.shutdown();
	}
}
