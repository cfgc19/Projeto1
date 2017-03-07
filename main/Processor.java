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

import generated.Actor;
import generated.Actors;
import generated.Stats;
import generated1.Project;
import generated1.Serie;

public class Processor {

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
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File xmlFile = new File("./src/series_temporario.xml");
		Actors actors = unmarshall.unmarshalles_actors();
		
		//System.out.println(actors);
		
		Actors obj_actors = new Actors();
		Project project = unmarshall.unmarshalles_project(xmlFile);
		String actor = "", serie="";
		int episodes;
		Map<String, List<String>> series_by_actors = new HashMap<String, List<String>>();
		Map<String, Integer> episodes_by_actors = new HashMap<String, Integer>();
		int t = 0;
		List<String> series_names = new ArrayList<String>();
		List<String> series_of_an_actor=new ArrayList<String>();
		
		// todos os atores
		int actors_episodes;
		
		for (int i = project.getSerie().size() - 1; i >= 0; i--) {
			episodes = project.getSerie().get(i).getEpisode().size();
			serie = project.getSerie().get(i).getSerieName();
			
			for (int j = project.getSerie().get(i).getCast().size() - 1; j >= 0; j--) {
				actor = project.getSerie().get(i).getCast().get(j).getName();
				
				if (series_by_actors.containsKey(actor)) {
									
					series_names = series_by_actors.get(actor);
					actors_episodes = episodes_by_actors.get(actor)+episodes;
					System.out.println(actor);
					System.out.println(actors_episodes);
					series_names.add(serie);
					series_names.sort(String::compareToIgnoreCase);
					
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
		
		
		//controlos e cenas
		System.out.println(episodes_by_actors);
		System.out.println(series_by_actors);
		
		List<Actor> actors_list = obj_actors.getActor();
		//for (Map.Entry<String, List<String>> entry : series_by_actors.entrySet()) {			
		
		for (String key : series_by_actors.keySet()){	
			Actor an_actor = new Actor();

			//String key = entry.getKey();
			//List<String> series_of_an_actor = entry.getValue();
			
			
			series_of_an_actor=series_by_actors.get(key);
			an_actor.setActorName(key);
			List<String> actor_series_list = an_actor.getSerie();			
			
			an_actor.setNoEpisodes(BigInteger.valueOf(episodes_by_actors.get(key)));
			
			
			
			//System.out.println("series of an actor");
			//System.out.println(series_of_an_actor);
			
			for (int i = 0; i < series_of_an_actor.size(); i++) {
				actor_series_list.add(series_of_an_actor.get(i));
			}
			System.out.println(series_of_an_actor);
			
			//actor_series_list.add(series_of_an_actor);
			
			actors_list.add(an_actor);
			
		}
		
		
		// ISTO FOI SO PARA TESTAR SE ESTAVA A FUNCIONAR. TEMOS DE MUDAAAR - filipa-JÁ MUDEI, DRICAS
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

//		for (int i = actors.getActor().size() - 1; i >= 0; i--) {

			// BigInteger ranting1 = project.getSerie().get(i).getRating();
			// if (ranting1.compareTo(ranting)>=0) {
			// series_list.add(project.getSerie().get(i).getSerieName());

			// o objetivo é ir ao project buscar todos os autores, po los no
			// outro xml
	//	}

	}
}