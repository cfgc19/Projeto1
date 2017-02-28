import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import generated.Project;
import main.unmarshall;

public class teste {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("ola:  ");

		BigInteger ranting, episodes, seasons;
		String language = "", network = "", genre = "", actor = "";

		Project research = unmarshall.unmarshalles();
		int opcao = 2;
		int option2=0;
		boolean opcao_certa=true;
		
		switch (opcao) {
		case 1:
			// pesquisa por instituicao
			System.out.print("Escolha o valor minimo do Rating: ");
			
			while (!scan.hasNextBigInteger())
			{
				scan.next();
				System.out.println("ERRO! Introduza um inteiro: ");
			}
			ranting = scan.nextBigInteger();
			
			// faltam controlos
			break;
		case 2:
			System.out.print("Escolha o valor minimo do episódios : ");
			
			while (!scan.hasNextBigInteger())
			{
				scan.next();
				System.out.println("ERRO! Introduza um inteiro: ");
			}
			episodes = scan.nextBigInteger();

			// faltam controlos
			break;
		case 3:
			System.out.println("Escolha o valor minimo de temporadas: ");
			while (!scan.hasNextBigInteger())
			{
				scan.next();
				System.out.println("ERRO! Introduza um inteiro: ");
			}
			seasons = scan.nextBigInteger();
			// faltam controlos
			break;
		case 4:
			System.out.println("Escolha a linguagem: ");
			// language = scan.nextLine(); ... creio que isto tem que ser em
			// baixo (ass dricas)... ou melhor, creio que isto não é preciso
			ArrayList<String> languages_list= new ArrayList<String>();;
			int option_list = 1;
			for (int i = research.getSerie().size() - 1; i >= 0; i--) {
				for (int j = research.getSerie().get(i).getLanguages().size(); i >= 0; i--) {
					language = research.getSerie().get(i).getLanguages().get(j);
					if (!languages_list.contains(language)) {
						languages_list.add(language);
						System.out.println(option_list + " " + language);
						option_list++;
					}
				}
			}
			while(opcao_certa)
			{
				while (!scan.hasNextInt())
				{
					scan.next();
					System.out.println("ERRO! Introduza um inteiro referente à opção que pretente: ");
				}
				option2=scan.nextInt();
				scan.nextLine();
				if (1 < option2 || option2 > languages_list.size())
				{
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				}
				else
				{
					opcao_certa=false;
				}
			}
			//int option2 = scan.nextInt(); // falta validar se é um numero
			//while (1 < option2 || option2 > languages_list.size()) {
				//System.out.print("Escreveu um numero errado. Volte a tentar: ");
			//}
			// if (!research.getSerie().get(i).getLanguages().get(i).ge)
			break;
		case 5:
			System.out.println("Escolha a Network: ");
			// network = scan.nextLine(); ... creio que isto tem que ser em
			// baixo (ass dricas)
			ArrayList<String> networks_list = new ArrayList<String>();
			option_list = 1;
			for (int i = research.getSerie().size() - 1; i >= 0; i--) {
				network = research.getSerie().get(i).getNetwork();
				if (!networks_list.contains(network)) {
					networks_list.add(network);
					System.out.println(option_list + " " + network);
					option_list++;
				}
			}
			opcao_certa=true;
			while(opcao_certa)
			{
				while (!scan.hasNextInt())
				{
					scan.next();
					System.out.println("ERRO! Introduza um inteiro referente à opção que pretente: ");
				}
				
				option2=scan.nextInt();
				scan.nextLine();
				if (1 < option2 || option2 > networks_list.size())
				{
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				}
				else
				{
					opcao_certa=false;
				}
			}
			break;
		case 6:
			System.out.println("Escolha o género da série: ");
			//genre = scan.nextLine();
				
			ArrayList<String> genres_list= new ArrayList<String>();
			option_list = 1;
			for (int i = research.getSerie().size() - 1; i >= 0; i--) {
				for (int j = research.getSerie().get(i).getGenre().size(); i >= 0; i--) {
					genre = research.getSerie().get(i).getGenre().get(j);
					if (!genres_list.contains(genre)) {
						genres_list.add(genre);
						System.out.println(option_list + " " + genre);
						option_list++;
					}
				}

			}
			while(opcao_certa)
			{
				while (!scan.hasNextInt())
				{
					scan.next();
					System.out.println("ERRO! Introduza um inteiro referente à opção que pretente: ");
				}
				
				option2=scan.nextInt();
				scan.nextLine();
				if (1 < option2 || option2 > genres_list.size())
				{
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				}
				else
				{
					opcao_certa=false;
				}
			}
			break;
		case 7:
			System.out.println("Escolhe o nome do ator: ");
			//actor = scan.nextLine();
						
			ArrayList<String> actors_list= new ArrayList<String>();
			option_list = 1;
			opcao_certa=true;
			for (int i = research.getSerie().size() - 1; i >= 0; i--) {
				for (int j = research.getSerie().get(i).getCast().size(); i >= 0; i--) {
					actor = research.getSerie().get(i).getCast().get(j);
					if (!actors_list.contains(actor)) {
						actors_list.add(actor);
						System.out.println(option_list + " " + actor);
						option_list++;
					}
				}

			}
			while(opcao_certa)
			{
				while (!scan.hasNextInt())
				{
					scan.next();
					System.out.println("ERRO! Introduza um inteiro referente à opção que pretente: ");
				}
				
				option2=scan.nextInt();
				scan.nextLine();
				if (1 < option2 || option2 > actors_list.size())
				{
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				}
				else
				{
					opcao_certa=false;
				}
			}

			
			
			break;

		case 8:
			System.out.println("Goodbye!!!");
			return;

		}

	}
}
