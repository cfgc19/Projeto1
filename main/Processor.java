package main;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
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
		ArrayList<String> actors_list = new ArrayList<String>();
		
		//todos os atores
		for (int i= project.getSerie().size()-1; i>=0;i--)
		{
			for (int j = project.getSerie().get(i).getCast().size()-1; j >= 0; j--) {
				actor = project.getSerie().get(i).getCast().get(j).getName();
				if (!actors_list.contains(actor)) {
					actors_list.add(actor);
				}
			}
		}
		
		for (int i = actors.getActor().size()- 1; i >= 0; i--) {
			//BigInteger ranting1 = project.getSerie().get(i).getRating();
				//if (ranting1.compareTo(ranting)>=0) {
					//series_list.add(project.getSerie().get(i).getSerieName());
		
		// o objetivo é ir ao project buscar todos os autores, po los no outro xml 
		}
		
	}


}
