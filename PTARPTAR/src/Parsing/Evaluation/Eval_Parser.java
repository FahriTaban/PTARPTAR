package Parsing.Evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Parsing.Element;
import Parsing.Parser;
import Utility.UnitTest;

public class Eval_Parser extends Parser{
	
	public HashMap<String,String> getParameterValuation(List<Element> evals, int number){
		HashMap<String,String> valuations = new HashMap<>();
		List<Element> val = this.getParameterValHelper(evals, number);
		List<List<Element>> val_split = this.getVariableAndValue(val, "KEY_VAR_NAME");
		for(List<Element> v : val_split) {
			String varName = v.get(0).getContent();
			String rValue = v.get(1).getContent();
			valuations.put(varName,rValue);
		}
		return valuations;
		
	}
	
	public List<Element> getParameterValHelper(List<Element> elems, int number){
		List<List<Element>> vals = this.getElemLists(elems, "KEY_VALUATION", "KEY_VALUATION", false);
		List<Element> val = vals.get(number-1);
		return val;
	}
	
}
