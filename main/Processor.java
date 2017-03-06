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
import generated.Project;

public class Processor {

	public static HashMap ola(Map map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
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
		Project project = unmarshall.unmarshalles_project(xmlFile);
		String actor = "";
		String serie = "";
		BigInteger episodes;
		List<String> actors_list = new ArrayList<String>();
		Map<String, List<String>> series_by_actors = new HashMap<String, List<String>>();
		Map<String, BigInteger> episodes_by_actors = new HashMap<String, BigInteger>();
		int t = 1;
		Actor actor_element = new Actor(null, null, null);
		
		List<String> series_names = new ArrayList<String>();
		// todos os atores
		BigInteger actors_episodes;
		for (int i = project.getSerie().size() - 1; i >= 0; i--) {
			episodes = project.getSerie().get(i).getNumberOfEpisodes();
			serie = project.getSerie().get(i).getSerieName();
			System.out.println(episodes);
			for (int j = project.getSerie().get(i).getCast().size() - 1; j >= 0; j--) {
				actor = project.getSerie().get(i).getCast().get(j).getName();

				if (series_by_actors.containsKey(actor)) {
					series_names = series_by_actors.get(actor);
					actors_episodes = episodes_by_actors.get(actor);
					System.out.println(actors_episodes);

					actors_episodes.add(episodes);

					series_names.add(serie);
					series_names.sort(String::compareToIgnoreCase);

					
				} else {
					actors.getActor().set(t, new Actor(actor,series_names, BigInteger.valueOf(4)))
					series_names = new ArrayList<String>();
					series_names.add(serie);

					series_names.sort(String::compareToIgnoreCase);
					series_by_actors.put(actor, series_names);
					episodes_by_actors.put(actor, episodes);
					t++;
				}
			}
		}

		episodes_by_actors = ola(episodes_by_actors);
		series_names.sort(String::compareToIgnoreCase);
		System.out.println(episodes_by_actors);
		System.out.println(series_by_actors);
		System.out.println(series_by_actors);
		/*for (Map.Entry<String, List<String>> entry : series_by_actors.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			actors.getActor().get(t).setActorName(key);
			List<String> series_temporary_list = actors.getActor().get(t).getSerie();
			series_temporary_list = value;
			t++;
		}*/
		
		File xmlFile1 = new File("./src/actors.xml");
		File schemaFile1 = new File("./src/actor.xsd");
		Boolean result = marshall.marshalles_actors(actors);
		if (!result) {
			System.out.println("A pesquisa efetuada nao tem resultados.");

		} else {
			System.out.println("O XML foi criado e apresentado em cima!");
		}

		for (int i = actors.getActor().size() - 1; i >= 0; i--) {

			// BigInteger ranting1 = project.getSerie().get(i).getRating();
			// if (ranting1.compareTo(ranting)>=0) {
			// series_list.add(project.getSerie().get(i).getSerieName());

			// o objetivo é ir ao project buscar todos os autores, po los no
			// outro xml
		}

	}

}
