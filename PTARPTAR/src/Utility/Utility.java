package Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import Parsing.Element;
import Parsing.Result_Parser;

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
                e.printStackTrace();{
            }
            }
        }
	}
	
	
	
//	FOR ELEMENTS AND STUFF
	public static String resultTransitionElemToString(List<Element> transition,Result_Parser parser) {
		String pta = parser.getPTA(transition).getContent();
		StringBuilder string = new StringBuilder();
		string.append(pta + ",");
		for(List<Element> g: parser.getGuards(transition)) {
			string.append(elemToString(g)+",");
		}
		for(List<Element> u: parser.getUpdates(transition)) {
			string.append(elemToString(u)+",");
		}
		return string.toString();
	} 

	public static String elemToString(List<Element> elems) {
		StringBuilder s = new StringBuilder();
		for(Element e : elems) {
			s.append(e.getContent()+ " ");
		}
		return s.toString();
	}
	
	public static String elemsToString(List<List<Element>> elems) {
		StringBuilder s = new StringBuilder();
		for(List<Element> es : elems) {
			for(Element e : es) {
				s.append(e.getContent()+ " ");
			}
		}
		return s.toString();
	}
	
	public static void printElem(Element elem) {
		elem.elemInfo();
	}
	
	public static void printElems(List<Element> elems) {
		for (Element e : elems) {
			e.elemInfo();
		}
	}
	
	public static void printStructures(List<List<Element>> structures) {
		for (List<Element> s : structures) {
			System.out.println("*".repeat(1000) + "\n NEW STRUCTURE \n " + "*".repeat(1000));
			for (Element e : s) {
				e.elemInfo();
			}
		}
	}
	
	public static Element findOperator(List<Element> elems) {
		for(Element e : elems) {
			if (e.isComparisonOperator()) {
				return e;
			}
		}
		return null;
	}
	
	public static void print(String s){
		System.out.println(s);
	}
}
