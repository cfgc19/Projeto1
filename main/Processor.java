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
		Project project = unmarshall.unmarshalles_project(xmlFile);
		String actor = "";
		String serie = "";
		BigInteger episodes;
		List<String> actors_list = new ArrayList<String>();
		Map<String, List<String>> series_by_actors = new HashMap<String, List<String>>();
		Map<String, BigInteger> episodes_by_actors = new HashMap<String, BigInteger>();
		int t = 0;

		List<String> series_names = new ArrayList<String>();
		// todos os atores
		BigInteger actors_episodes;
		for (int i = project.getSerie().size() - 1; i >= 0; i--) {
			// episodes = project.getSerie().get(i).getNumberOfEpisodes();
			serie = project.getSerie().get(i).getSerieName();
			for (int j = project.getSerie().get(i).getCast().size() - 1; j >= 0; j--) {
				actor = project.getSerie().get(i).getCast().get(j).getName();
				if (series_by_actors.containsKey(actor)) {
					series_names = series_by_actors.get(actor);
					actors_episodes = episodes_by_actors.get(actor);

					// actors_episodes.add(episodes);

					series_names.add(serie);
					series_names.sort(String::compareToIgnoreCase);

				} else {

					series_names = new ArrayList<String>();
					series_names.add(serie);

					series_names.sort(String::compareToIgnoreCase);
					series_by_actors.put(actor, series_names);
					// episodes_by_actors.put(actor, episodes);
					t++;
				}
			}
		}

		episodes_by_actors = sortByValue(episodes_by_actors);
		series_names.sort(String::compareToIgnoreCase);
		System.out.println(episodes_by_actors);
		System.out.println(series_by_actors);
		System.out.println(series_by_actors);
		for (Map.Entry<String, List<String>> entry : series_by_actors.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			Actor actor1 = new Actor();
			actor1.setActorName(key);
			List<String> series_list1 = actor1.getSerie();
			List<Actor> actors_list1 = actors.getActor();
			for (int i = 0; i < value.size(); i++) {
				series_list1.add(value.get(i));
			}
			actors_list1.add(actor1);
		}
		for (int i = 0; i < actors.getActor().size(); i++) {
			System.out.println(actors.getActor().get(i));
		}
		Boolean result = marshall.marshalles_actors(actors);
		System.out.println(result);
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