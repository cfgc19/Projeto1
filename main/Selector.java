package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
		
	}
}
