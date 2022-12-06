package Unused;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.json.*;
import Utility.Main;

public class ExtractJSONfromResult {

	public static void parseRes(File file) {
		String jsonString = findJSON(file);
		Main.pr(jsonString);
		extractJsonInfo(jsonString);
	}
	
	public static String findParameters(File file) {
		return "";
	}
	
	/**
	 * Extracts the concrete run JSON from .res file
	 * @param file
	 * @return
	 */
	public static String findJSON(File file) {
		String subString = "Run nature: valid run";
		String jsonString = " ";
		int found = 0;
		boolean begin = false;
		String addString = " ";
		try {
		    Scanner scanner = new Scanner(file);
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        if(begin && !line.contains(subString)) {
		        	addString = coalesce(List.of((line + "\n"),"\n"));
		        	jsonString += addString;
		        }
		        if(line.contains(subString)) { 
		        	if (found == 2) {
		        		break;
		        	}
		        	else if (found == 1) {
		        		subString = "******";
		        		found = 2;
		        		begin = true;
		        	}
		        	else if (found == 0) {
			        	subString = "Run";
			        	found = 1;
		        	}
		        }
		    }
	        scanner.close();
		} catch(FileNotFoundException e) {
		    e.printStackTrace();
		}
		return jsonString;
	}
	
	public static int[] findLines(File file) {
		String subString = "Run nature: valid run";
		int[] lineNrs = new int[2];
		int found = 0;
	    int lineNr = 0;
		try {
		    Scanner scanner = new Scanner(file);
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        lineNr++;
		        if(line.contains(subString)) { 
		        	if (found == 2) {
		        		lineNrs[1] = lineNr-1;
		        		break;
		        	}
		        	else if (found == 1) {
		        		lineNrs[0] = lineNr+1;
		        		subString = "******";
		        		found = 2;
		        	}
		        	else if (found == 0) {
			        	subString = "Run";
			        	found = 1;
		        	}
		        }
		    }
	        scanner.close();
		} catch(FileNotFoundException e) {
		    e.printStackTrace();
		}
		return lineNrs;
	}
	
	public static void extractJsonInfo(String jsonString) {
		JSONObject obj = new JSONObject(jsonString);
		getKeys(obj);
	}
	
	public static String coalesce(List<String> strings) {
        for (String s : strings)
            if (s != null)
                return s;
 
        return null;
    }
	
	public static void getKeys(JSONObject obj) {
		Iterator<String> keys = obj.keys();
		while(keys.hasNext()) {
		    String key = keys.next();
		    Main.pr(key);
		    if(obj.get(key) instanceof JSONObject) {
		    	JSONObject newObj = (JSONObject) obj.get(key);
                getKeys(newObj);
		    }
		    if(obj.get(key) instanceof JSONArray) {
		    	JSONArray arr = (JSONArray) obj.get(key);
		    	for (Object s : arr) {
		    		getKeys((JSONObject) s);
		    	}
		    }
		}
		
	}
}