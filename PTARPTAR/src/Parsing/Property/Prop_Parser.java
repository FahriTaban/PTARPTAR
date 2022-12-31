package Parsing.Property;

import java.util.ArrayList;
import java.util.List;

import Parsing.Element;
import Parsing.Parser;

public class Prop_Parser extends Parser{

	public List<List<Element>> getLocations(List<Element> prop){
		List<List<Element>> locs = this.getVariableAndValue(prop, "KEY_LOCATION_ACCESS");
		return locs;
	}	
}
