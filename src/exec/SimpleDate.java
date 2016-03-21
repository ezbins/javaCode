package exec;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long nowDate = System.currentTimeMillis();
		//choice long type nowDate or Date type nowDate.
		//Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(sdf.format(nowDate));
	}

}
