package main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import generated.Project;

public class teste {

	public static void validation_int(Scanner scan) {
		while (!scan.hasNextBigInteger()) {
			scan.next();
			System.out.println("ERRO! Introduza um inteiro: ");
		}
	}
	
	public static ArrayList<String> rule_or(ArrayList<String> series_list)
	{
		int size=series_list.size();
		for (int i=0; i<size;i++)
		{
			for (int j=i+1;j<size;j++)
			{
				if (series_list.get(i).equals(series_list.get(j)))
				{
					series_list.remove(j--);
					size--;
				}
			}
		}
		return series_list;
		
	}
	public static ArrayList<String> rule_and (ArrayList<String> series_list){
		ArrayList<String> result_list = new ArrayList<String>();
		
		for (int i = 0; i < series_list.size()-1; i++)
        {
            for (int j = i+1; j < series_list.size(); j++)
            {
                if( (series_list.get(i).equals(series_list.get(j))) && (i != j) )
                {
                	result_list.add(series_list.get(i));
                }
            }
	}
		return result_list;
	}
	public static ArrayList<String> rules(int opcao, ArrayList<String> series_list) {
		
		Scanner scan = new Scanner(System.in);

		BigInteger ranting, episodes, seasons;
		String language = "", network = "", genre = "", actor = "";

		Project project = unmarshall.unmarshalles();
		int option2 = 0;
		boolean opcao_certa = true;

		switch (opcao) {
		case 1:
			// pesquisa por Ranting
			System.out.print("Escolha o valor minimo do Rating: ");

			validation_int(scan);

			ranting = scan.nextBigInteger();
			
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				BigInteger ranting1 = project.getSerie().get(i).getRating();
					if (ranting1.compareTo(ranting)!=-1) {
						series_list.add(project.getSerie().get(i).getSerieName());
				}
			}
			// faltam controlos
			break;
		case 2:
			System.out.print("Escolha o valor minimo do episódios : ");

			validation_int(scan);

			episodes = scan.nextBigInteger();

			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				BigInteger episodes1 = project.getSerie().get(i).getNumberOfEpisodes();
					if (episodes1.compareTo(episodes)!=-1) {
						series_list.add(project.getSerie().get(i).getSerieName());
						
				}
			}
			// faltam controlos
			break;
		case 3:
			System.out.println("Escolha o valor minimo de temporadas: ");

			validation_int(scan);

			seasons = scan.nextBigInteger();
			// faltam controlos
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				BigInteger seasons1 = project.getSerie().get(i).getNumberOfSeasons();
					if (seasons.compareTo(seasons1)!=-1) {
						series_list.add(project.getSerie().get(i).getSerieName());
				}
			}
			
			break;
		case 4:
			System.out.println("Escolha a linguagem: ");
			// APRESENTA A LISTA DE LINGUAGENS!!
			
			
			ArrayList<String> languages_list = new ArrayList<String>();
			int option_list = 1;
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				for (int j = project.getSerie().get(i).getLanguages().size() - 1; j >= 0; j--) {
					language = project.getSerie().get(i).getLanguages().get(j);
					if (!languages_list.contains(language)) {
						languages_list.add(language);
						System.out.println(option_list + " " + language);
						option_list++;
					}
				}
			}
			while (opcao_certa) {

				validation_int(scan);

				option2 = scan.nextInt();
				scan.nextLine();
				if (1 > option2 || option2 > languages_list.size()) {
					System.out.print("O valor introduzido não se encontra no menu. Tente novamente: ");
				} else {
					opcao_certa = false;
				}
			}
			// ELIMINA NO XML AS SERIES QUE NAO TENHAM A LINGUAGEM ESCOLHIDA
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				List<String> list = project.getSerie().get(i).getLanguages();
					if (list.contains(languages_list.get(option2 - 1))) {
						series_list.add(project.getSerie().get(i).getSerieName());
				
				}
			}
			break;
		case 5:
			System.out.println("Escolha a Network: ");
			// network = scan.nextLine(); ... creio que isto tem que ser em
			// baixo (ass dricas)
			ArrayList<String> networks_list = new ArrayList<String>();
			option_list = 1;
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				network = project.getSerie().get(i).getNetwork();
				if (!networks_list.contains(network)) {
					networks_list.add(network);
					System.out.println(option_list + " " + network);
					option_list++;
				}
			}
			opcao_certa = true;
			while (opcao_certa) {
				validation_int(scan);

				option2 = scan.nextInt();
				scan.nextLine();
				if (1 > option2 || option2 > networks_list.size()) {
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				} else {
					opcao_certa = false;
				}
			}
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				network = project.getSerie().get(i).getNetwork();
					if (network.equals(networks_list.get(option2 - 1))) {
						series_list.add(project.getSerie().get(i).getSerieName());
				}
			}
			break;
		case 6:
			System.out.println("Escolha o género da série: ");
			// genre = scan.nextLine();

			ArrayList<String> genres_list = new ArrayList<String>();
			option_list = 1;
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				for (int j = project.getSerie().get(i).getGenre().size(); i >= 0; i--) {
					genre = project.getSerie().get(i).getGenre().get(j);
					if (!genres_list.contains(genre)) {
						genres_list.add(genre);
						System.out.println(option_list + " " + genre);
						option_list++;
					}
				}

			}
			while (opcao_certa) {
				validation_int(scan);

				option2 = scan.nextInt();
				scan.nextLine();
				if (1 < option2 || option2 > genres_list.size()) {
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				} else {
					opcao_certa = false;
				}
			}
			
			// ELIMINA NO XML AS SERIES QUE NAO TENHAM A GENERO ESCOLHIDO
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				List<String> list = project.getSerie().get(i).getGenre();
					if (list.contains(genres_list.get(option2 - 1))) {
						series_list.add(project.getSerie().get(i).getSerieName());
				}
			}
			
			break;
		case 7:
			System.out.println("Escolhe o nome do ator: ");
			// actor = scan.nextLine();

			ArrayList<String> actors_list = new ArrayList<String>();
			option_list = 1;
			opcao_certa = true;
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				for (int j = project.getSerie().get(i).getCast().size(); i >= 0; i--) {
					actor = project.getSerie().get(i).getCast().get(j);
					if (!actors_list.contains(actor)) {
						actors_list.add(actor);
						System.out.println(option_list + " " + actor);
						option_list++;
					}
				}
			}
			while (opcao_certa) {
				validation_int(scan);

				option2 = scan.nextInt();
				scan.nextLine();
				if (1 < option2 || option2 > actors_list.size()) {
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				} else {
					opcao_certa = false;
				}
			}
			// ELIMINA NO XML AS SERIES QUE NAO TENHAM A GENERO ESCOLHIDO
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				List<String> list = project.getSerie().get(i).getCast();
					if (list.contains(actors_list.get(option2 - 1))) {
						series_list.add(project.getSerie().get(i).getSerieName());
				}
			}
			break;
		case 8:
			
			System.out.println("Goodbye!!!");
			System.exit(0);
		}
		return series_list;
	}
}
