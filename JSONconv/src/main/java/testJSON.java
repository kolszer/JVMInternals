import com.google.gson.Gson;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import classForTest.AAAAA;
import classForTest.DDDD;
import classForTest.EEEEE;
import java.util.Random;


public class testJSON {
	private String replStrJSON(String x)
	{
		x = x.replace(",","");
		//x = x.replace("{", "");
		//x = x.replace("}", "");
		//x = x.replace("[","");
		//x = x.replace("]", "");
		x = x.replace("\"", "");
		//x = x.replace("\n", "");
		x = x.replace(" ", "");

		return x;
	}

	@Test
	public void testAAAAA() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException
	{
		Random rnd = new Random();
		AAAAA aa = new AAAAA();
		aa.stringList = new ArrayList<String>();
		aa.stringList.add("a"+rnd.nextInt());
		aa.stringList.add("a"+rnd.nextInt());
		aa.stringList.add("a"+rnd.nextInt());
		aa.stringList.add("a"+rnd.nextInt());
		aa.stringList.add("a"+rnd.nextInt());
		aa.integerList = new ArrayList<Integer>();
		aa.integerList.add(rnd.nextInt());
		aa.integerList.add(rnd.nextInt());
		aa.integerList.add(rnd.nextInt());
		aa.ddddList = new LinkedList<DDDD>();
		DDDD dd = new DDDD();
		dd.x = "ASD";
		dd.ee = EEEEE.III;
		DDDD dd1 = new DDDD();
		dd1.x = "ZXC";
		dd1.ee = EEEEE.KKK;
		aa.ddddList.add(dd);
		aa.ddddList.add(dd1);
		aa.intArray = new int[3];
		aa.stringArray = new String[3];
		aa.ddddArray = new DDDD[3];

		for(int i=0;i<3;i++)
		{
			aa.intArray[i] = rnd.nextInt();
			aa.stringArray[i] = "strArr"+rnd.nextInt();
			if(i%2==0)
				aa.ddddArray[i]=dd;
			else
				aa.ddddArray[i]=dd1;
		}

		JSONConverter conv = new JSONConverter();
		Gson gson = new Gson();

		String jsonConvStr = conv.objToJSON(aa);
		String gsonConvStr = gson.toJson(aa);

		assertEquals(replStrJSON(jsonConvStr),replStrJSON(gsonConvStr));
	}
}
