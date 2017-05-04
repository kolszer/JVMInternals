public class ListJNI {
   static {
      System.loadLibrary("intlist");
   }

   private long myList;
 
   private native void newList();
   private native void add(int x);
   private native int get(int x);
   private native int size();
   private native void clear();
   private native boolean contains(int x);
   private native int indexOf(int x);
   private native boolean isEmpty();
   private native int lastIndexOf(int x);
   private native void remove(int x);
 
   public static void main(String[] args) {
      	ListJNI obj = new ListJNI();
	obj.newList();
	obj.add(67);
	obj.add(222);
	obj.remove(0);
	obj.add(3333);
	obj.add(444);
	obj.add(4654);
	System.out.println("obj.get(0): "+obj.get(0));
	System.out.println("obj.get(1): "+obj.get(1));
	obj.clear();
	System.out.println("isEmpty(): "+obj.isEmpty());
	obj.add(2242);
	System.out.println("obj.get(0): "+obj.get(0));
	obj.remove(0);
	System.out.println("obj.get(0): "+obj.get(0));
	obj.add(2122);
	obj.add(456);
	obj.add(2242);
	System.out.println("isEmpty(): "+obj.isEmpty());
	System.out.println("size(): "+obj.size());
	System.out.println("obj.get(1): "+obj.get(1));
	System.out.println("obj.contains(456): "+obj.contains(456));
	System.out.println("obj.indexOf(2242): "+obj.indexOf(2242));
   }
}
