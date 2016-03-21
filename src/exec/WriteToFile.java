package exec;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteToFile {

	
	public static void main(String[] args) {
		Charset charset = Charset.forName("UTF-8");
		Path path = FileSystems.getDefault().getPath("/home/shao", "response.log");
		String str="test writing\t";
		String str1="new line\n";
		try(BufferedWriter bufwriter = Files.newBufferedWriter(path, charset,StandardOpenOption.WRITE,StandardOpenOption.APPEND)) {
			bufwriter.write(str, 0, str.length());
			bufwriter.write(str1,0,str1.length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
