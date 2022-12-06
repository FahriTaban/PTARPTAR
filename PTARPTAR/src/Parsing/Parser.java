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
	
	public List<Element> getSubList(List<Element> tokens, String begin, String end){
		List<Element> elems = new ArrayList<>();
		boolean fetch = false;
		for (Element e : tokens) {
			if (e.getType() == begin) {
				fetch = true;
			}
			else if (e.getType() == end && fetch) {
				break;
			}
			else if (fetch) {
				elems.add(e);
			}
		}
		return elems;
	}
	
	
	/**
	 * Returns pairs of variable name and its value as elements
	 * @param tokens
	 * @param variableName
	 * @return
	 */
	public List<List<Element>> getVariableAndValue(List<Element> tokens, String variableName){
		List<List<Element>> elemsList = new ArrayList<>();
		List<Element> elems = new ArrayList<>();
		boolean fetchNext = false;
		for (Element e : tokens) {
			if (e.getType() == variableName && !fetchNext) {
				fetchNext = true;
				elems.add(e);
			}
			else if (fetchNext && (e.getType() == "KEY_VAR_NAME" || e.isValue())) {
				elems.add(e);
				elemsList.add(List.copyOf(elems));
				elems.clear();
			}
		}
		return elemsList;
	}
	
	
	/**
	 * Returns the first value found of a given type after a variable-element with the fitting name has been found
	 * @param tokens
	 * @param variableName
	 * @param valueType
	 * @return
	 */
	public Element getValue(List<Element> tokens, String variableName, String valueType){
		boolean fetchNext = false;
		for (Element e : tokens) {
			if (e.getType() == variableName) {
				fetchNext = true;
				}
			else if (fetchNext && e.getType() == valueType) {
				return e;
			}
		}
		return null;
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
		boolean fetchedFirst = false;
		List<Element> list = new ArrayList<>();
		for (Element e : elems) {
			if (fetch && e.getType() == end) {
				lists.add(List.copyOf(list));
				list.clear();
				fetch = false;
			}
			else if (fetch) {
				list.add(e);
			}
			if (e.getType() == begin) {
				fetch = true;
			}
			else if (begin == "" && !fetchedFirst) {
				fetch = true;
				fetchedFirst = true;
				list.add(e);
			}
		}
		if (!list.isEmpty()) {
			lists.add(list);
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
		boolean fetchedFirst = false;
		List<Element> list = new ArrayList<>();
		for (Element e : elems) {
			if (fetch && (e.getType() == end || e.getType() == altEnd)) {
				lists.add(List.copyOf(list));
				list.clear();
				fetch = false;
				fetchedFirst = false;
			}
			else if (fetch) {
				list.add(e);
			}
			if (e.getType() == begin) {
				fetch = true;
			}
			else if (begin == "" && !fetchedFirst) {
				fetch = true;
				fetchedFirst = true;
				list.add(e);
			}
		}
		if (!list.isEmpty()) {
			lists.add(list);
		}
		return lists;
	}
	
	/**
	 * Returns sublists of a list of elements.
	 * @param elems List of elements to split.
	 * @param begin Beginning of each sublist (Element-type)
	 * @param end End of each sublist (Element-type)
	 * @param altEnd Alternative end of each sublist (Element-type)
	 * @param include If true, include Element matching the begin parameter Element type
	 * @return
	 */
	public List<List<Element>> getElemLists(List<Element> elems, String begin, String end, String altEnd, boolean include){
		List<List<Element>> lists = new ArrayList<>();
		boolean fetch = false;
		List<Element> list = new ArrayList<>();
		for (Element e : elems) {
			if (fetch && (e.getType() == end || e.getType() == altEnd)) {
				lists.add(List.copyOf(list));
				list.clear();
				fetch = false;
			}
			else if (fetch) {
				list.add(e);
			}
			if (e.getType() == begin) {
				fetch = true;
				if (include) {
					list.add(e);
				}
			}
		}
		if (!list.isEmpty()) {
			lists.add(list);
		}
		return lists;
	}
	
	/**
	 * Returns sublists of a list of elements.
	 * @param elems List of elements to split.
	 * @param begin Beginning of each sublist (Element-type)
	 * @param end End of each sublist (Element-type)
	 * @param altEnd Alternative end of each sublist (Element-type)
	 * @param include If true, include Element matching the begin parameter Element type
	 * @return
	 */
	public List<List<Element>> getElemLists(List<Element> elems, String begin, String end, boolean include){
		List<List<Element>> lists = new ArrayList<>();
		boolean fetch = false;
		List<Element> list = new ArrayList<>();
		for (Element e : elems) {
			if (fetch && (e.getType() == end)) {
				lists.add(List.copyOf(list));
				list.clear();
				fetch = false;
			}
			else if (fetch) {
				list.add(e);
			}
			if (e.getType() == begin) {
				fetch = true;
				if (include) {
					list.add(e);
				}
			}
		}
		if (!list.isEmpty()) {
			lists.add(list);
		}
		return lists;
	}
}