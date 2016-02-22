package exec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.codec.binary.Base64;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		Path path = FileSystems.getDefault().getPath("/home/shao/", "text.txt");
		// Path path2 = Paths.get("/home/shao/tmp/1451465231977.txt");
		Charset charset = Charset.forName("US-ASCII");

		BufferedReader reader = Files.newBufferedReader(path, charset);
		String line = "";
		StringBuffer getReader = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			getReader.append(line);
		}

		
		byte[] pdfContent = Base64.decodeBase64(getReader.toString());
		try (OutputStream out = new FileOutputStream("/home/shao/filename.pdf")) {
			out.write(pdfContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
