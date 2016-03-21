package exec;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class RmFile {

	public static void main(String[] args) throws IOException {
		Path rmfile = FileSystems.getDefault().getPath("/home/shao", "a.file");
		boolean result=false;
		result=Files.deleteIfExists(rmfile)? true:false;
		
		if(result) {
			System.out.println("the file was removed.");
		}else {
			System.out.println("the file did not exsit");
		}
	}

}
