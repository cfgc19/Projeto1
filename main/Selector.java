package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Selector {

	public static void main(String[] args) {

		ArrayList<String> result_list = new ArrayList<String>();

		String[] serie = { "a", "b", "c", "d", "e","a","b" };
		ArrayList<String> series_list = new ArrayList<String>(Arrays.asList(serie));

		
		for (int i = 0; i < series_list.size() - 1; i++) {
			for (int j = i + 1; j < series_list.size(); j++) {
				if ((series_list.get(i).equals(series_list.get(j))) && (i != j)) {
					result_list.add(series_list.get(i));
				}
			}
		}
		System.out.println("ola");
		for (int i=0; i<result_list.size(); i++){
			System.out.println(result_list.get(i).toString());
		}
		
		
		Map<String, ArrayList<String>> series_by_actors = new HashMap<String,ArrayList<String>>();
		String[] nomes_series1 = {"Sexy and the city", "asfd"};
		ArrayList<String> series_names = new ArrayList<String>(Arrays.asList(nomes_series1));
		
		series_by_actors.put("Oliver", series_names);
		ArrayList<String> list = new ArrayList<String>();
		
		if(series_by_actors.containsKey("Oliver")){
		    // if the key has already been used,
		    // we'll just grab the array list and add the value to it
		    list = series_by_actors.get("Oliver");
		    list.add("ola");
		    list.sort(String::compareToIgnoreCase);
		} else {
		    // if the key hasn't been used yet,
		    // we'll create a new ArrayList<String> object, add the value
		    // and put it in the array list with the new key
		    list = new ArrayList<String>();
		    list.add("oiii");
		    series_by_actors.put("Joana", list);
		}
		System.out.println(series_by_actors);
	}
}
