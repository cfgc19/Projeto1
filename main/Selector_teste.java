package main;

import java.io.File;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import generated_Actors.Actor;
import generated_Actors.Actors;
import generated_Series.Project;

public class Selector_teste {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File xmlFile = new File("./src/series_temporario.xml");
		Actors actors = unmarshall.unmarshalles_actors();
		Project project=unmarshall.unmarshalles_project(xmlFile);

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
		

		Map<String, List<String>> series_by_actors = new HashMap<String,List<String>>();
		String[] nomes_series1 = {"Sexy and the city", "asfd"};
		ArrayList<String> series_names = new ArrayList<String>(Arrays.asList(nomes_series1));
		
		series_by_actors.put("Oliver", series_names);
		ArrayList<String> list = new ArrayList<String>();
		BigInteger numero = null;
	/*	
		if(series_by_actors.containsKey("Oliver")){
		    // if the key has already been used,
		    // we'll just grab the array list and add the value to it
			numero= numero.add(BigInteger.valueOf(3));

		} else {
		    // if the key hasn't been used yet,
		    // we'll create a new ArrayList<String> object, add the value
		    // and put it in the array list with the new key
		    list = new ArrayList<String>();
		    list.add("oiii");
		}
		System.out.println(series_by_actors);
		*/
		int t=0;
		List<String> teste = new ArrayList<String>();
		
		System.out.println(teste.size());
		
		for (Map.Entry<String, List<String>> entry : series_by_actors.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			Actor actor = new Actor();
			actor.setActorName(key);
			List<String> series_list1 =actor.getSerie();
			List<Actor> actors_list1 = actors.getActor();
			for(int i=0; i<value.size(); i++){
				series_list1.add(value.get(i));
			}
			actors_list1.add(actor);
		}
		System.out.println(actors.getActor().size());
		for (int i=0; i<actors.getActor().size(); i++){
			System.out.println(actors.getActor().get(i));
		}
		
	}
}
