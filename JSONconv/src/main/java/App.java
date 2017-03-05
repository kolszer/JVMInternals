import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class App {

		public static boolean isPri(Field f)
		{
			String[] types = {"byte","short","int","long","float","double","char","boolean","java.lang.String","java.lang.Integer"};
			for(int i=0;i<types.length;i++)
				if(f.getType().getName().equals(types[i]))
					return true;
			return false;
		}

		//TODO: enum, listy, tablice, JSON syntax
		public static String objToString(Object o) throws IllegalArgumentException, IllegalAccessException
		{
			String res ="";
			Class cls = o.getClass();

			res += cls.getName()+"\n";
			for(Field fld : cls.getDeclaredFields())
			{
				fld.setAccessible(true);
				res += fld.getName()+" "+isPri(fld)+"\n";

				//Pole nie jest obiektem
				if(isPri(fld)){
					res += fld.getName()+": "+fld.get(o)+"\n";
				}
				//Pole jest nullem
				else if(fld.get(o) == null){
					res += "null\n";
				}

				else
				{
					res += fld.getName()+": \n";
					res += objToString(fld.get(o))+": \n";
				}
			}
			return res;
		}

		public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
			AAAA aa = new AAAA();
			aa.x=3;
			aa.z="aa";
			BBBB bb = new BBBB();
			aa.y=bb;
			bb.g="bb";
			CCCC cc = new CCCC();
			DDDD dd = new DDDD();
			bb.f=cc;
			bb.h=dd;
			cc.a=null;
			cc.x=4;
			dd.x="dd";
			System.out.println(objToString(aa));




			/*AAA aa = new AAA();
			aa.setAsd(5);
			aa.setZxc("ZXC-aa");


			List<BBB> bb = new ArrayList<BBB>();

			BBB bba = new BBB();
			bba.setXxx("XXX-bba");
			bba.setYyy(6);

			CCC cca = new CCC();
			cca.setDdd(new Date());
			cca.setFff(true);
			bba.setZzz(cca);

			bb.add(bba);

			BBB bbaa = new BBB();
			bbaa.setXxx("XXX-bbaa");
			bbaa.setYyy(6);

			CCC ccaa = new CCC();
			ccaa.setDdd(new Date());
			ccaa.setFff(true);
			bbaa.setZzz(ccaa);

			bb.add(bbaa);

			BBB bbaaa = new BBB();
			bbaaa.setXxx("XXX-bbaaa");
			bbaaa.setYyy(6);
			bbaa.setZzz(ccaa);

			bb.add(bbaaa);

			aa.setBbbs(bb);


			System.out.println(convToJSON(aa));*/
	}

}
