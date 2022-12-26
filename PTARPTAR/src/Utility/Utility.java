package Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ConstraintSystem.ToSMT2;
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
		for(Element g: parser.getGuards(transition)) {
			string.append(g.getContent()+",");
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
	
	public static List<Element> reverseList(List<Element> elems){
		List<Element> reversed = new ArrayList<>();
		for(int i = elems.size()-1;i >= 0;i--) {
			Element e = elems.get(i);
			if(e.isComparisonOperator()) {
				Element f = new Element("",negateOperator(e.getContent()));
				reversed.add(f);
			} else {
			reversed.add(elems.get(i));
			}
		}
		return reversed;
	}
	
	public static String negateOperator(String operator) {
		switch(operator) {
			case "=":
				return "=";
			case ">=":
				return "<=";
			case "<=":
				return ">=";
			case ">":
				return "<";
			case "<":
				return ">";
			default:
				return operator;
		}
	}
	
	public static List<String> splitString(String s, String delim){
		System.out.println(s);
		Pattern p = Pattern.compile(delim);
		Matcher m = p.matcher(s);
		if (m.find()) {
			int begin = m.start();
			int end = m.end();
			String lhs = s.substring(0,begin).strip();
			String op = s.substring(begin,end).strip();
			String rhs = s.substring(end,s.length()).strip();
	        return List.of(lhs,op,rhs);
		} else {
			return List.of(s);
		}
	}
	
	public static boolean isArOperator(String s) {
		Pattern p = Pattern.compile("[+\\-\\*]");
		Matcher m = p.matcher(s);
		if(m.find() && s.length() == 1) {
			return true;
		} 
		return false;
	}
	
	public static String concatStrings(List<String> ss) {
		StringBuilder sb = new StringBuilder();
		for(String s : ss) {
			sb.append(s+"\n");
		}
		return sb.toString().strip();
	}
	
	public static String concatPretty(String connector, List<String> strings) {
		if (strings.isEmpty()) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		s.append("("+connector+" ");
		String ws;
		for(int i = 0; i < strings.size(); i++) {
			String c = strings.get(i);
			if (i != strings.size()-1) {
				ws = "\n\t";
			} else {
				ws = "";
			}
			s.append(c + ws);
		}
		s.append(")");
		return s.toString();
	}
	
	public static String concatPretty(String connector, String innerConnector, List<List<String>> strings) {
		if (strings.isEmpty()) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		s.append("(assert ("+connector+" ");
		String ws;
		for(int i = 0; i < strings.size(); i++) {
			List<String> c = strings.get(i);
			if (i != strings.size()-1) {
				ws = "\n\t";
			} else {
				ws = "";
			}
			s.append(ToSMT2.connectClauses(c, innerConnector) + ws);
		}
		s.append("))");
		return s.toString();
	}
}
