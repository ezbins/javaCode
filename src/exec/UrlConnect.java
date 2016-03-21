package exec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class UrlConnect {

	public static void main(String[] args) {
		 String link =
				  "http://192.168.1.158:8080/QueueWebService/QueueDeliver";
				   
				  URL url;
				try {
					url = new URL(link);
					 HttpURLConnection http = (HttpURLConnection) url.openConnection(); 
					  http.setRequestMethod("POST");
					  http.setRequestProperty("User-Agent","Mozilla/5.0");
					  http.setRequestProperty("Content-Type","application/octet-stream;charset=utf-8"); 
					  http.setDoOutput(true);
					  DataOutputStream wr = new DataOutputStream(http.getOutputStream());
					  //wr.writeBytes(jobj.toString()); 
					  wr.flush(); 
					  wr.close();
					  String line=""; 
					  StringBuffer getReader = new StringBuffer(); 
					 
					  if( http.getResponseCode() == 200 &&  http.getResponseMessage().equals("OK")) { 
						  BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
					  while ( (line = reader.readLine() ) !=null) {
						  getReader.append(line); }
					  }
					  Charset charset = Charset.forName("US-ASCII");
						Path path = FileSystems.getDefault().getPath(
								"/home/linaro/QueueManagementMachine",
								"response.log");
						try (BufferedWriter bufwriter = Files
								.newBufferedWriter(path, charset,
										StandardOpenOption.CREATE,
										StandardOpenOption.WRITE,
										StandardOpenOption.APPEND)) {
							bufwriter.write(getReader.toString(), 0, getReader.toString().length());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	}

}
