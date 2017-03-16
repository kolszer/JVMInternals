import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		if(args.length != 2)
			System.exit(0);
		int	x = Integer.parseInt(args[0]);
		int	m = Integer.parseInt(args[1]);

		ExecutorService executor = Executors.newFixedThreadPool(x);
		Date date1 = new Date();
		for(int i=0;i<x;i++)
			executor.submit(() -> {
				alloc(m);
			});
		
		executor.shutdown();
		while (!executor.isTerminated()) {}
		Date date2 = new Date();
		System.out.println(date2.getTime()-date1.getTime());
	}

	private static void alloc(int m)
	{
		if(m==0)
			m = new Random().nextInt(1000000);
		String[] x = new String[m];
		for(Integer i=0;i<x.length;i++)
			x[i] = "TEST"+i.toString();
	}

}
