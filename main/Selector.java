package main;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import generated_Series.Project;

public class Selector {
	//validar se é inteito
	public static void validation_int(Scanner scan) {
		while (!scan.hasNextBigInteger()) {
			scan.next();
			System.out.print("ERRO! Introduza um inteiro: ");
		}
	}
	//validar se é BigDecimal
	public static void validation_BigDecimal(Scanner scan){
		while(!scan.hasNextBigDecimal()){
			scan.next();
			System.out.print("ERRO! Introduza um decimal (ex: 8,9): ");
		}
	}
	//para a regra "ou" fazemos apenas remoção de series repetidas (entre uma regra e outra)
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
	//para a regra "e" mantemos apenas as series repetidas entre uma regra e outra
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
		BigDecimal rating=BigDecimal.valueOf(0);
		String language = "", network = "", type = "", actor = "", rating_source="";

		File xmlFile = new File("./src/series.xml");		
		Project project = unmarshall.unmarshalles_project(xmlFile);
		int option2 = 0;
		boolean opcao_certa = true;
		switch (opcao) {
		case 1:
			//pesquisa por Rating
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
			//é necessário escolher qual a fonte do Rating
			System.out.print("Escolha a fonte: ");
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
			//é necessário também escolher o valor minímo do rating das series que serão incluidas no xml (as escalas variam consoante a fonte)
			System.out.print("\nEscolha o valor minimo do Rating: ");		
			boolean validation=true;
			while(validation)
			{
				validation_BigDecimal(scan);
				rating = scan.nextBigDecimal();		
				scan.nextLine();
				if (sources_list.get(option2-1).equals("Rotten Tomatoes") || sources_list.get(option2-1).equals("Metacritic"))
				{
					if(rating.compareTo(BigDecimal.valueOf(0))>=0 && rating.compareTo(BigDecimal.valueOf(100))<=0)
					{
						validation=false;
					}
					else
					{
						System.out.print("Deve introduzir um valor entre 0 e 100. Tente novamente: ");
					}
				}
				else if (sources_list.get(option2-1).equals("IMDb") || sources_list.get(option2-1).equals("TV.com"))
				{
					if(rating.compareTo(BigDecimal.valueOf(0))>=0 && rating.compareTo(BigDecimal.valueOf(10))<=0)
					{
						validation=false;
					}
					else
					{
						System.out.print("Deve introduzir um valor entre 0 e 10. Tente novamente: ");
					}
					
				}
				else if (sources_list.get(option2-1).equals("HBO Uk"))
				{
					if(rating.compareTo(BigDecimal.valueOf(0))>=0 && rating.compareTo(BigDecimal.valueOf(4))<=0)
					{
						validation=false;
					}
					else
					{
						System.out.print("Deve introduzir um valor entre 0 e 4. Tente novamente: ");
					}
				}
			}			
			BigDecimal rating1;
			// ELIMINA NO XML AS SERIES QUE TENHAM RATING INFERIOR ÀQUELE QUE FOI ESCOLHIDO
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				for (int j=project.getSerie().get(i).getRating().size()-1;j>=0;j--)
				{
					rating1=project.getSerie().get(i).getRating().get(j).getValue();
					if (project.getSerie().get(i).getRating().get(j).getSource().equals(sources_list.get(option2-1)))
					{
						if (rating1.compareTo(rating)>=0) {
							series_list.add(project.getSerie().get(i).getSerieName());
						}

					}
				}

			}
			break;

		case 2:
			//pesquisa por número de seasons
			System.out.print("Escolha o valor minimo de temporadas: ");
			validation_int(scan);
			seasons = scan.nextBigInteger();
			BigInteger seasons1;
			BigInteger max_season;
			// ELIMINA NO XML AS SERIES QUE TENHAM MENOS SEASONS DO QUE O VALOR INTRODUZIDO
			for (int i=project.getSerie().size()-1; i>=0;i--){
				ArrayList<BigInteger> all_seasons = new ArrayList<BigInteger>();
				for (int j=project.getSerie().get(i).getEpisode().size()-1;j>=0;j--){
					seasons1=project.getSerie().get(i).getEpisode().get(j).getSeason();
					all_seasons.add(seasons1);
				}
				max_season=Collections.max(all_seasons);
				if (max_season.compareTo(seasons)>=0) {
					series_list.add(project.getSerie().get(i).getSerieName());
				}
			}
			break;
		case 3:
			//pesquisa por linguagens
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
			System.out.print("Escolha a linguagem: ");
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
		case 4:
			//pesquisa por network
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
			System.out.print("Escolha a Network: ");
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
			// ELIMINA NO XML AS SERIES QUE NAO TENHAM A NETWORK ESCOLHIDA
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				network = project.getSerie().get(i).getNetwork();
				if (network.equals(networks_list.get(option2 - 1))) {
					series_list.add(project.getSerie().get(i).getSerieName());
				}
			}
			break;
		case 5:
			//pesquisa por Tipo
			ArrayList<String> types_list = new ArrayList<String>();
			option_list = 1;
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				type = project.getSerie().get(i).getType();
				if (!types_list.contains(type)) {
					types_list.add(type);
					System.out.println(option_list + " " + type);
					option_list++;
				}
			}
			System.out.print("Escolha o tipo da série: ");
			while (opcao_certa) {
				validation_int(scan);
				option2 = scan.nextInt();
				scan.nextLine();
				if (1 > option2 || option2 > types_list.size()) {
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				} else {
					opcao_certa = false;
				}
			}	
			// ELIMINA NO XML AS SERIES QUE NAO TENHAM O TIPO DE SÉRIE ESCOLHIDO
			for (int i = project.getSerie().size() - 1; i >= 0; i--) {
				type = project.getSerie().get(i).getType();
				if (type.equals(types_list.get(option2 - 1))) {
					series_list.add(project.getSerie().get(i).getSerieName());
				}
			}					
			break;
		case 6:
			//pesquisa por ator
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
			System.out.print("Escolhe o nome do ator: ");
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
		case 7:

			System.out.println("Bye!");
			System.exit(0);
		}
		return series_list;
	}
}
