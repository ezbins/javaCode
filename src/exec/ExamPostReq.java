package exec;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONObject;

public class ExamPostReq {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ExamPostReq http = new ExamPostReq();
		http.sendPost();
	}
	
	private void sendPost() throws Exception {
		String link = "http://124.219.72.74/test/ReceiveServlet";
		//String link = "http://192.168.1.63/test/ReceiveServlet";
		//String link = "http://192.168.1.130:8080/test/ReceiveServlet";
		URL url = new URL(link);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent","Mozilla/5.0");
		con.setRequestProperty("Content-Type",
					"application/json;charset=utf-8");
		
		String pdfContent = readFile();
		JSONObject json = new JSONObject();
		try {
			
			json.put("Status", "1");
			json.put("Id", "123");
			json.put("Name", "Mary");
			json.put("MeasureDate","2016/01/26 20:40:04");
			json.put("Sdnn","0");
			json.put("Lf", "0");
			json.put("Hf", "0");
			json.put("RrSpread", "0");
			json.put("HrvAge", "50");
			json.put("SdnnStandard", "0");
			json.put("LfStandard", "0");
			json.put("HfStandard", "0");
			json.put("Message", "no more messages");
			json.put("ReportDate", "2016/02/19 19:40:04");
			json.put("Pdf", pdfContent);
			
		} catch (Exception ex) {
			ex.toString();
		}
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(json.toString());
		wr.flush();
		wr.close();
		
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line="";
		StringBuffer getReader = new StringBuffer();
		while ( (line = reader.readLine() ) !=null) {
			getReader.append(line);
		}
		JSONObject jsonObj = new JSONObject(getReader.toString());
		System.out.println("回傳的訊息 "+jsonObj.getString("message"));
		
	}
	
	protected String readFile() throws IOException {
		Path path = FileSystems.getDefault().getPath("/home/shao/", "text.txt");
		Charset charset = Charset.forName("US-ASCII");
		BufferedReader reader = Files.newBufferedReader(path, charset);
		String line = null;
		StringBuffer readfromfile = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			readfromfile.append(line);

		}

		return readfromfile.toString();
	}
}
