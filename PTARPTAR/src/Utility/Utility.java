package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utility {
	public static StringBuilder readFile(String path) {
		try {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
  		return new StringBuilder(new String(encoded));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
  		}
}
