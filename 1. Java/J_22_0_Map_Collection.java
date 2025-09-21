
/*
 	Collection Framework :
 	___________________________________
 	
 	3. Map :-
	________________
	
	- Map stores the data in key-value pair form.
	- Map Interface can have 3 different classes as, HashMap, LinkedHashMap, and TreeMap.
	- HashMap does not store the data in the same form as they were inserted.
	- LinkedHashMap being a Linked Map, stores data in the same order as they were stored.
	- TreeMap stores the entity in sorted order based on keys.
	
*/


import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class J_22_0_Map_Collection {
	public static void main(String [] args) {
		Map<Integer, String> map1 = Map.of(1,"This is value1 of map1", 2, "This is value2 of map1");
		Map<Integer, String> map2 = new HashMap<>();
		Map<Integer, String> map3 = new LinkedHashMap<>();
		Map<Integer, String> map4 = new TreeMap<>();
		
		map2.put(1, "This is value1 of map2") ;
		map2.put(2, "This is value2 of map2") ;
		map2.put(3, "This is value3 of map2") ;
		
		map3.put(1, "This is value1 of map3") ;
		map3.put(2, "This is value2 of map3") ;
		map3.put(3, "This is value3 of map3") ;
		
		map4.put(1, "This is value1 of map4") ;
		map4.put(2, "This is value2 of map4") ;
		map4.put(3, "This is value3 of map4") ;
		
		System.out.println(map1) ;
		System.out.println(map2) ;
		System.out.println(map3) ;
		System.out.println(map4) ;
		
		//-------- To get all the keys of a particular map ---------
		
		Set<Integer> keySet1 = map2.keySet() ;
		
		System.out.println(keySet1);
		
		//------- To get all the values of a particular map -------
		
		Collection<String> mapValues = map2.values();
	
		System.out.println(mapValues) ;
		
		//------- To get all the key-value pair set ----------
		
		Set < Entry<Integer, String> > keyValuePair = map3.entrySet() ;
		
		for(Entry<Integer,String> enty:keyValuePair) {
			System.out.println("Key - " + enty.getKey() + " : Value - " + enty.getValue() );
		}
		
		//------------- iterate over the maps ----------------
		
		for(Integer keys : keySet1) {
			System.out.println(keys +" : " + map2.get(keys));
		}
		
		//------------- replace a value ----------------------
		map2.replace(3, "This is value3 in map2", "This is value4 in map2") ;
		
		//	----------- remove elements ----------------------
		map3.remove(2) ;	// provided key.
	}
}