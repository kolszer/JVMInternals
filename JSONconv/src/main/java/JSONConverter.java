import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

public class JSONConverter {
	private static boolean isPri(Field f)
	{
		String[] types = {"byte","short","int","long","float","double","char","boolean","java.lang.Integer"};
		for(int i=0;i<types.length;i++)
			if(f.getType().getName().equals(types[i]))
				return true;
		return false;
	}
	
	public static String objToJSON(Object o) throws IllegalArgumentException, IllegalAccessException
	{
		StringBuilder res = new StringBuilder();
		res.append("{\n");
		for(Field fld : o.getClass().getDeclaredFields())
		{
			fld.setAccessible(true);
			res.append("\""+fld.getName()+"\": ");
			if(fld.get(o).getClass().getName()=="java.lang.String")
				res.append("\""+fld.get(o)+"\"");
			if(isPri(fld) || fld.get(o).getClass().isEnum())
				res.append(fld.get(o));
			else if(fld.get(o) == null)
				res.append("null");	
			else if(fld.get(o).getClass().getName()=="java.util.ArrayList" || fld.get(o).getClass().getName()=="java.util.LinkedList")
			{			
				res.append("[");
				for(Object i : (List)fld.get(o))
				{
					if(i.getClass().getName()=="java.lang.Integer")
						res.append(i.toString());
					else if (i.getClass().getName()=="java.lang.String")
						res.append("\""+i.toString()+"\"");
					else
						res.append(objToJSON(i));
					res.append(",");
				}
				res.setLength(res.length() - 1);
				res.append("]");
			}
			else if(fld.get(o).getClass().isArray())
			{
				res.append("{");
				for(int i=0;i<Array.getLength(fld.get(o));i++)
				{
					if(Array.get(fld.get(o),i).getClass().getName()=="java.lang.Integer")
						res.append(Array.get(fld.get(o), i));
					else if (Array.get(fld.get(o),i).getClass().getName()=="java.lang.String")
						res.append("\""+Array.get(fld.get(o), i)+"\"");
					else
						res.append(objToJSON(Array.get(fld.get(o), i)));
						res.append(",");
				}
				res.setLength(res.length() - 1);
				res.append("}");
			}				
			res.append(",\n");
		}
		res.append("}");
		return res.toString();
	}
}
