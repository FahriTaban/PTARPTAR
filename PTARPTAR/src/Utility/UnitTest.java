package Utility;

import java.util.List;

import NPTA.Transition;
import Parsing.Element;
import Parsing.Parser;
import Parsing.Result_Parser;

public class UnitTest {

	public static String resultTransitionElemToString(List<Element> transition,Result_Parser parser) {
		String pta = parser.getPTA(transition).getContent();
		StringBuilder string = new StringBuilder();
		string.append(pta + ",");
		for(Element g: parser.getGuards(transition)) {
			string.append(g.getContent()+",");
		}
		for(List<Element> u: parser.getUpdates(transition)) {
			string.append(elemsToString(u)+",");
		}
		return string.toString();
	} 

	public static String elemsToString(List<Element> elems) {
		StringBuilder s = new StringBuilder();
		for(Element e : elems) {
			s.append(e.getContent()+ " ");
		}
		return s.toString();
	}
	
	public static String elemssToString(List<List<Element>> elems) {
		StringBuilder s = new StringBuilder();
		for(List<Element> es : elems) {
			for(Element e : es) {
				s.append(e.getContent()+ " ");
			}
			s.append("\n");
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
	
	public static void print(String s){
		System.out.println(s);
	}
	
	public static void printList(List<String> l) {
		for(String s : l) {
			System.out.println(s);
		}
	}

	public static void printListList(List<List<String>> l) {
		for(List<String> s : l) {
			printList(s);
		}
	}
}
