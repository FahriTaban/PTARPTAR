package Parsing;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	/**
	 * Returns a (sub)list of elements given another list of elements.
	 * @param tokens List of elements
	 * @param begin Beginning of sublist (Element-type)
	 * @param end End of sublist (Element-type)
	 * @return
	 */
	public List<Element> getVariableNames(List<Element> tokens, String begin, String end){
		List<Element> elems = new ArrayList<>();
		boolean fetch = false;
		for (Element e : tokens) {
			if (e.getType() == begin) {
				fetch = true;
				continue;
			}
			if (fetch && e.getType() == "KEY_VAR_NAME") {
				elems.add(e);
			}
			if(e.getType() == end) {
				break;
			}
		}
		return elems;
	}
	
	public ListList<Element> getVariableAndValue(List<Element> tokens, String variableName, String value){
		List<Element> elems = new ArrayList<>();
		boolean fetchNext = false;
		for (Element e : tokens) {
			if (e.getType() == variableName) {
				fetchNext = true;
				
				continue;
			}
			if (fetchNext && e.getType() == type) {
				elems.add(e);
			}
		}
		return elems;
	}
	
	/**
	 * Returns sublists of a list of elements.
	 * @param elems List of elements to split.
	 * @param begin Beginning of each sublist (Element-type)
	 * @param end End of each sublist (Element-type)
	 * @return
	 */
	public List<List<Element>> getElemLists(List<Element> elems, String begin, String end){
		List<List<Element>> lists = new ArrayList<>();
		boolean fetch = false;
		List<Element> list = new ArrayList<>();
		for (Element e : elems) {
			if (fetch && e.getType() == end) {
				lists.add(List.copyOf(list));
				list.clear();
				fetch = false;
			}
			if (begin == "" || e.getType() == begin) {
				fetch = true;
				continue;
			}
			if (fetch) {
				list.add(e);
			}
		}
		return lists;
	}
	
	/**
	 * Returns sublists of a list of elements.
	 * @param elems List of elements to split.
	 * @param begin Beginning of each sublist (Element-type)
	 * @param end End of each sublist (Element-type)
	 * @param altEnd Alternative end of each sublist (Element-type)
	 * @return
	 */
	public List<List<Element>> getElemLists(List<Element> elems, String begin, String end, String altEnd){
		List<List<Element>> lists = new ArrayList<>();
		boolean fetch = false;
		List<Element> list = new ArrayList<>();
		for (Element e : elems) {
			if (fetch && (e.getType() == end || e.getType() == altEnd)) {
				lists.add(List.copyOf(list));
				list.clear();
				fetch = false;
			}
			if (begin == "" || e.getType() == begin) {
				fetch = true;
				continue;
			}
			if (fetch) {
				list.add(e);
			}
		}
		return lists;
	}
}
