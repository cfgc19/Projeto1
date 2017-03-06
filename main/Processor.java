package main;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import generated.Actor;
import generated.Actors;
import generated.Project;

public class Processor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Actors actors = unmarshall.unmarshalles_actors();
		Project project=unmarshall.unmarshalles_project();
		String actor="";
		String serie ="";
		ArrayList<String> actors_list = new ArrayList<String>();
		Map<String, ArrayList<String>> series_by_actors = new HashMap<String,ArrayList<String>>();
		
		ArrayList<String> series_names = new ArrayList<String>();
		
		if(series_by_actors.containsKey("Joana")){
		    series_names = series_by_actors.get("Oliver");
		    series_names.add("ola");
		} else {
		    series_names = new ArrayList<String>();
		    series_names.add("oiii");
		    series_by_actors.put("Joana", series_names);
		}
		
		
		//todos os atores
		for (int i= project.getSerie().size()-1; i>=0;i--)
		{
			for (int j = project.getSerie().get(i).getCast().size()-1; j >= 0; j--) {
				actor = project.getSerie().get(i).getCast().get(j).getName();
				serie =project.getSerie().get(i).getSerieName();
				if(series_by_actors.containsKey(actor)){
				    series_names = series_by_actors.get(actor);
				    series_names.add(serie);
				    series_names.sort(String::compareToIgnoreCase);
				} else {
				    series_names = new ArrayList<String>();
				    series_names.add(serie);
				    series_names.sort(String::compareToIgnoreCase);
				    series_by_actors.put(actor, series_names);
				}
			}
		}
		series_names.sort(String::compareToIgnoreCase);
		System.out.println(series_by_actors);

		
		for (int i = actors.getActor().size()- 1; i >= 0; i--) {
			
			//BigInteger ranting1 = project.getSerie().get(i).getRating();
				//if (ranting1.compareTo(ranting)>=0) {
					//series_list.add(project.getSerie().get(i).getSerieName());
		
		// o objetivo é ir ao project buscar todos os autores, po los no outro xml 
		}
		
	}


}
