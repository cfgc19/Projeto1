package main;

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

import generated.Actor;
import generated.Actors;
import generated.Project;

public class Processor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Actors actors = unmarshall.unmarshalles_actors();
		
		
		for (int i = actors.getActor().size()- 1; i >= 0; i--) {
			//BigInteger ranting1 = project.getSerie().get(i).getRating();
				//if (ranting1.compareTo(ranting)>=0) {
					//series_list.add(project.getSerie().get(i).getSerieName());
			}
		
	}


}
