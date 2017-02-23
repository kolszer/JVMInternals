import java.util.ArrayList;
import java.util.List;

//Aplikacja konczy sie wyjatkiem OutOfMemory

public class App 
{
    public static void main(String[] args)
    {
    		//Tworzymy liste intow
		List<Integer> intList = new ArrayList<Integer>();

		//Nieskonczona petla
		for(;;)
		{
			//Dodajemy do listy liczbe ((2^32)/2)-1, w pewnym momencie
			//lista jest tak duza, ze aplikacja konczy sie wyjatkiem OutOfMemory
			intList.add(Integer.MAX_VALUE);
		}
    }
}
