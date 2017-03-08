import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class App {
		
		public static boolean isPri(Field f)
		{
			String[] types = {"byte","short","int","long","float","double","char","boolean","java.lang.String","java.lang.Integer"};
			for(int i=0;i<types.length;i++)
				if(f.getType().getName().equals(types[i]))
					return true;
			return false;
		}
		
		public static String ListToString(Field o)
		{
			String res ="";
			
			return res;
		}
		
		//TODO: JSON syntax, tests
		public static String objToString(Object o) throws IllegalArgumentException, IllegalAccessException
		{
			String res ="";
			Class cls = o.getClass();
			
			for(Field fld : cls.getDeclaredFields())
			{
				res +=fld.getName()+": ";
				fld.setAccessible(true);

				if(isPri(fld)){//Pole nie jest obiektem
					res += fld.get(o)+"\n";
				}
				else if(fld.get(o) == null){//Pole jest nullem
					res += "null\n";
				}			
				else if(fld.get(o).getClass().isEnum())
				{
					res += fld.get(o);
				}
				//Pole jest lista
				else if(fld.get(o).getClass().getName()=="java.util.ArrayList" || fld.get(o).getClass().getName()=="java.util.LinkedList")
				{			
					
					for(Object i : (List)fld.get(o))
					{
						if(i.getClass().getName()=="java.lang.Integer" || i.getClass().getName()=="java.lang.String")
						{
						res += i.toString()+"\n";
						}
						else{
							res += objToString(i);
						}
					}
				}
				//Pole jest tablica
				else if(fld.get(o).getClass().isArray())
				{
					for(int i=0;i<Array.getLength(fld.get(o));i++)
					{
						if(Array.get(fld.get(o),i).getClass().getName()=="java.lang.Integer" || Array.get(fld.get(o),i).getClass().getName()=="java.lang.String")
							res += Array.get(fld.get(o), i)+"\n";
						else
							res += objToString(Array.get(fld.get(o), i))+"\n";
					}
				}

			}
			return res;
		}
		
		public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
			AAAAA aa = new AAAAA();
			aa.stringList = new ArrayList<String>();
			aa.stringList.add("a1");
			aa.stringList.add("a2");
			aa.stringList.add("a3");
			aa.stringList.add("a4");
			aa.stringList.add("a5");
			aa.integerList = new ArrayList<Integer>();
			aa.integerList.add(11);
			aa.integerList.add(22);
			aa.integerList.add(33);
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
				aa.intArray[i] = i+5;
				aa.stringArray[i] = "strArr"+i;
				if(i%2==0)
					aa.ddddArray[i]=dd;
				else
					aa.ddddArray[i]=dd1;
			}
			
			System.out.println(objToString(aa));
			
			
			
			
			
			
			/*AAAA aa = new AAAA();
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
			
			
			System.out.println(objToString(aa));*/

			
			
			
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
