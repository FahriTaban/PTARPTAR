package Utility;

import java.io.File;
import java.io.FileWriter;
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

	public static String createFile(String filePath) {
		int i = 1;
		try {
			File file = new File(filePath);
		    while (!file.createNewFile()) {
		    	i++;
		    	file = new File(filePath+Integer.toString(i));
		    }
		    System.out.println("Created File " + file.getName());
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return filePath + Integer.toString(i);
	}
	
	public static void writeToFile(String path, String content) {
		File file = new File(path);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file,false);
            fr.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
