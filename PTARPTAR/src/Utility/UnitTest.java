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
	
	public static void print(String s){
		System.out.println(s);
	}
}
