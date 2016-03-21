package exec;

import java.nio.charset.StandardCharsets;

public class StringToASCII {

	public static void main(String[] args) {
		String str = "!";
		byte[] s = str.getBytes(StandardCharsets.US_ASCII);
		for(byte element:s) {
			System.out.println(element);
		}
	}

}
