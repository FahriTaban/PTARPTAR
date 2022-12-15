package Utility;
import Parsing.*;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Tes {

	public static void main(String[] args) {
		System.out.print("\n".isBlank());
		String s = "x + s <= 2";
		List<String> strings = Utility.splitString(s, "[<>=]+");
		for(String a:strings) {
			System.out.print(a+",");
			System.out.println(Utility.isArOperator(a));
		}
	}
	
	static void printElems(List<Element> elems) {
		for (Element e : elems) {
			e.elemInfo();
		}
	}
	
	static void printStructures(List<List<Element>> structures) {
		for (List<Element> s : structures) {
			System.out.println("*".repeat(1000) + "\n NEW STRUCTURE \n " + "*".repeat(100));
			for (Element e : s) {
				e.elemInfo();
			}
		}
	}
	

}
