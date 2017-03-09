package main;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.transform.TransformerException;

import generated_Actors.Actor;
import generated_Actors.Actors;
import generated_Actors.Stats;
import generated_Series.Project;
import generated_Series.Serie;

public class Processor {
	
	//método que ordena um HashMap pelos seus valores
	public static HashMap sortByValue(Map map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object value1, Object value2) {
				return ((Comparable) ((Map.Entry) (value2)).getValue()).compareTo(((Map.Entry) (value1)).getValue());
			}
		});
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
	

	public static void main(String[] args) throws TransformerException {
		Scanner scan = new Scanner(System.in);
		File xmlFile = new File("./src/temporary_series.xml");
		//Objeto actors contém toda a informação referente a um ator
		Actors actors = unmarshall.unmarshalles_actors();
		
		Actors obj_actors = new Actors();
		Project project = unmarshall.unmarshalles_project(xmlFile);
		String actor = "", serie="";
		int episodes;
		Map<String, List<String>> series_by_actors = new HashMap<String, List<String>>();
		Map<String, Integer> episodes_by_actors = new HashMap<String, Integer>();
		List<String> series_names = new ArrayList<String>();
		List<String> series_of_an_actor=new ArrayList<String>();
		

		int actors_episodes;
		// criação de dois HashMaps: um deles tem como chave o nome dos actores e como valores as suas séries, o outro tem também como chave o nome dos atores mas como valor o número de episodios nos quais participa
		for (int i = project.getSerie().size() - 1; i >= 0; i--) {
			episodes = project.getSerie().get(i).getEpisode().size();
			serie = project.getSerie().get(i).getSerieName();
			
			for (int j = project.getSerie().get(i).getCast().size() - 1; j >= 0; j--) {
				actor = project.getSerie().get(i).getCast().get(j).getName();
				
				if (series_by_actors.containsKey(actor)) {
									
					series_names = series_by_actors.get(actor);
					actors_episodes = episodes_by_actors.get(actor).intValue()+episodes;

					series_names.add(serie);
					series_names.sort(String::compareToIgnoreCase);
					
					episodes_by_actors.put(actor, actors_episodes);
					series_by_actors.put(actor, series_names);
					
				} else {

					actors_episodes=episodes;

					series_names = new ArrayList<String>();
					
					series_names.add(serie);
					series_names.sort(String::compareToIgnoreCase);
					
					series_by_actors.put(actor, series_names);
					episodes_by_actors.put(actor, actors_episodes);
					

				}
			}
		}

		episodes_by_actors = sortByValue(episodes_by_actors);
		series_names.sort(String::compareToIgnoreCase);
		
		List<Actor> actors_list = obj_actors.getActor();
		for (String key : series_by_actors.keySet()){	
			Actor an_actor = new Actor();
			
			series_of_an_actor=series_by_actors.get(key);
			an_actor.setActorName(key);
			
			List<String> actor_series_list = an_actor.getSerie();			

			an_actor.setNoEpisodes(BigInteger.valueOf(episodes_by_actors.get(key)));

			for (int i = 0; i < series_of_an_actor.size(); i++) {
				actor_series_list.add(series_of_an_actor.get(i));
			}		
			actors_list.add(an_actor);
			
		}
	
		Stats stats = new Stats();
		stats.setNoActors(BigInteger.valueOf(episodes_by_actors.size()));
		
		List<String> actors_on_podium = stats.getPodiumActors();
		String name_actor;
		
		for (int k=0; k<3; k++)
		{
			name_actor=(String) episodes_by_actors.keySet().toArray()[k];
			actors_on_podium.add(name_actor);
		}

	
		obj_actors.setStats(stats);
		Boolean result = marshall.marshalles_actors(obj_actors);
		System.out.println(result);
		if (!result) {
			System.out.println("A pesquisa efetuada nao tem resultados.");

		} else {
			System.out.println("O XML foi criado e apresentado em cima!");
		}


	}
}