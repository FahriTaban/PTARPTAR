package Utility;

import java.util.List;

import Parsing.Element;

public class UnitTest {
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
