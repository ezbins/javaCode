package exec;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Random;
import java.util.Set;

public class RandomText {

	public static void main(String[] args) throws IOException {

		String randText = generateText();

		// Checking directory exist or not.
		Path path = FileSystems.getDefault().getPath("/tmp/pdfdoc/");
		if (!(Files.isDirectory(path))) {
			Files.createDirectory(path);
		}
		// Creating File
		Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw-");
		FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
		
		Path file = FileSystems.getDefault().getPath(
				"/tmp/pdfdoc/" + randText + ".pdf");
		if (!(Files.exists(file))) {
			Files.createFile(file,attr);
			System.out.println("File created down");
		}

	}

	public static String generateText() {
		char[] words = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 6; i++) {
			char c = words[random.nextInt(words.length)];
			sb.append(c);
		}

		return sb.toString();
	}
}