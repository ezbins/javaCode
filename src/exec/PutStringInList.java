package exec;

import java.util.ArrayList;
import java.util.List;

public class PutStringInList {

	public static void main(String[] args) {
		String str1 = "String1";
		String str2 = "String2";
		List<String> list = new ArrayList<String>();
		list.add(0, str1);
		list.add(1,str2);
		
		String str3 = list.get(0);
		String str4 = list.get(1);
		System.out.println("Str3 value from Str1 ->"+str3);
		System.out.println("Str4 value from Str2 ->"+str4);

	}

}
