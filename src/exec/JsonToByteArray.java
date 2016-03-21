package exec;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToByteArray {

	public static void main(String[] args) {
		List<Object> Container = new ArrayList<Object>();
		Container.add("First e");
		Container.add("Second e");
		Container.add(10);
		
		JSONObject jobj = new JSONObject();
		jobj.put("list", Container);
		//System.out.println(jobj);
		
		JSONArray array = jobj.getJSONArray("list");
		JSONArray jarry = new JSONArray(Container);
		
		for (int i=0; i<array.length();i++ ) {
			System.out.println(array.get(i));
		}
		/*for(Object item:jarry) {
			System.out.println(item);
		}*/
		
		
		
		//System.out.println(jobj);
		/*jobj.put("name1", "name1");
		jobj.put("name2", "name2");
		System.out.print(jobj);*/
		
			
		//以下的程式碼可以運作
		/*byte[] data = jobj.toString().getBytes();
		String str = new String();
		
		for (int i=0; i< data.length; i++) {
			str +=((char)(data[i]));
			System.out.print( (char)(data[i]));
		}
		JSONObject obj2 = new JSONObject(str);
		System.out.println(obj2);
		System.out.println(obj2.get("name2"));
		System.out.println(obj2.get("name1"));*/
		
	}

}
