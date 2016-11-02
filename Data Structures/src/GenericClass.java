import java.util.ArrayList;
import java.util.List;

public class GenericClass {

	public static void main(String[] args)
	{
		List <String> l1 = new ArrayList<String>();
		List<Integer> l2 = new ArrayList<Integer>();
		System.out.println(l1.getClass() == l2.getClass());
		
		List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.  
		Object o = lsa;  
		Object[] oa = (Object[]) o;  
		List<Integer> li = new ArrayList<Integer>();  
		li.add(new Integer(3));  
		oa[1] = li; // Correct.  
		int i = (int) lsa[1].get(0); //对于通配符的方式，最后取出数据是要做显式的类型转换的
		String s = (String) lsa[1].get(0); 
	}
}
