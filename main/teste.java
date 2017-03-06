package main;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import generated1.Project;

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

		BigInteger episodes, seasons;
		Integer rating;
		String language = "", network = "", genre = "", actor = "", rating_source="";
		File xmlFile = new File("./src/series.xml");		
		Project project = unmarshall.unmarshalles_project(xmlFile);
		int option2 = 0;
		boolean opcao_certa = true;
		switch (opcao) {
		case 1:
			// pesquisa por Ranting
			//System.out.print("Escolha o valor minimo do Rating: ");
			System.out.println("Escolha a fonte: ");
			ArrayList<String> sources_list = new ArrayList<String>();
			int option_list = 1;
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				for (int j = project.getSerie().get(i).getRating().size() - 1; j >= 0; j--) {
					rating_source = project.getSerie().get(i).getRating().get(j).getSource();
					if (!sources_list.contains(rating_source)) {
						sources_list.add(rating_source);
						System.out.println(option_list + " " + rating_source);
						option_list++;
					}
				}
			}
			while (opcao_certa) {

				validation_int(scan);

				option2 = scan.nextInt();
				scan.nextLine();
				if (1 > option2 || option2 > sources_list.size()) {
					System.out.print("O valor introduzido não se encontra no menu. Tente novamente: ");
				} else {
					opcao_certa = false;
				}
			}
			System.out.println("Escolha o valor minimo do Rating: ");
			validation_int(scan);
			rating = scan.nextInt();
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				for (int j=project.getSerie().get(i).getRating().size()-1;j>=0;j--)
				{
					String rating_string="";
					float rating1=0;
					if (project.getSerie().get(i).getRating().get(j).getSource().equals(sources_list.get(option2-1)))
					{
						if (project.getSerie().get(i).getRating().get(j).getSource().equals("IMDb") || project.getSerie().get(i).getRating().get(j).getSource().equals("HBO Uk")|| project.getSerie().get(i).getRating().get(j).getSource().equals("TV.com"))
						{
							rating_string=project.getSerie().get(i).getRating().get(j).getValue();
							if (rating_string.contains("."))
							{
								rating1 = Float.parseFloat(rating_string.substring(0, 3));
							}
							else
							{
								rating1=Integer.parseInt(rating_string.substring(0,1));
							}

						}
						else if(project.getSerie().get(i).getRating().get(j).getSource().equals("Rotten Tomatoes") || project.getSerie().get(i).getRating().get(j).getSource().equals("Metacritic"))
						{
							rating_string=project.getSerie().get(i).getRating().get(j).getValue();

							rating1 = Integer.parseInt(rating_string.substring(0, 2));
							
						}
						if ((rating1-rating)>=0) {
							System.out.println(rating1);
							series_list.add(project.getSerie().get(i).getSerieName());
					}

					}
					}

			}
			break;
	

		case 2:
			System.out.println("Escolha o valor minimo de temporadas: ");

			validation_int(scan);

			seasons = scan.nextBigInteger();
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				BigInteger seasons1 = project.getSerie().get(i).getNumberOfSeasons();
					if (seasons1.compareTo(seasons)>=0) {
						series_list.add(project.getSerie().get(i).getSerieName());
				}
			}
			
			break;
		case 4:
			System.out.println("Escolha a linguagem: ");
			// APRESENTA A LISTA DE LINGUAGENS!!
			
			ArrayList<String> languages_list = new ArrayList<String>();
			option_list = 1;
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

			ArrayList<String> genres_list = new ArrayList<String>();
			option_list = 1;
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				for (int j = project.getSerie().get(i).getGenre().size()-1; j >= 0; j--) {
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
				if (1 > option2 || option2 > genres_list.size()) {
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
				for (int j = project.getSerie().get(i).getCast().size()-1; j >= 0; j--) {
					actor = project.getSerie().get(i).getCast().get(j).getName();
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
				if (1 > option2 || option2 > actors_list.size()) {
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				} else {
					opcao_certa = false;
				}
			}
			// ELIMINA NO XML AS SERIES QUE NAO TENHAM O ATOR ESCOLHIDO
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				for (int j=project.getSerie().get(i).getCast().size()-1; j>=0;j--)
				{
					ArrayList<String> list = new ArrayList<String>();
					list.add(project.getSerie().get(i).getCast().get(j).getName());
					if (list.contains(actors_list.get(option2 - 1))) {
						series_list.add(project.getSerie().get(i).getSerieName());
				}
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
