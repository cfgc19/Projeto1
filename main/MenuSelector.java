package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.RunnableScheduledFuture;

import generated_Series.Project;

public class MenuSelector {
	public static void menu()
	{
		System.out.println("\n1-Valor minimo de rating;");
		System.out.println("2-Número mínimo de temporadas;");
		System.out.println("3-Linguagem;");
		System.out.println("4-Network;");
		System.out.println("5-Tipo;");
		System.out.println("6-Nome de ator;");
		System.out.println("7-Sair!");
		System.out.println("");
		System.out.print("Selecione a opção que pretende: ");		
	}
	public static void main(String[] args)
	{	
		Scanner scan=new Scanner (System.in);
		//Lista de series que provêm de cada regra 
		ArrayList<String> series_list = new ArrayList<String>();
		File xmlFile = new File("./src/series.xml");		
		//Objeto projeto representa cada série
		Project project = unmarshall.unmarshalles_project(xmlFile);
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("                                       Series Selector                                    ");
		System.out.println("Esta aplicação permite a geração de um ficheiro XML que contém apenas as séries que \n respeitam todas as regras que selecionar! Comece por selecionar uma das regras abaixo: ");
		System.out.println("------------------------------------------------------------------------------------------");
		menu();
		int option=0;
		String option1="";
		boolean option_while=true;
		while(option_while)
		{

			Selector.validation_int(scan);
			option=scan.nextInt();
			scan.nextLine();
			if (option<1 || option >7)
			{
				System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
			}
			else
			{
				option_while=false;
			}
		}
		series_list=Selector.rules(option,series_list);
		boolean exit=false;
		while (!exit){
			System.out.println("\n------------------------------------------------------------------------------------------");
			System.out.println("                           Selecione o próximo passo                                      ");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("a - AND (escolha de uma nova regra);");
			System.out.println("b - OR (escolha de uma nova regra);");
			System.out.println("c - Criar XML;");
			System.out.println("d - Sair!");
			System.out.print("Escolha a opção: ");
			option_while=false;
			while(!option_while)
			{				
				option1=scan.next();
				if (option1.equals("a") || option1.equals("b") || option1.equals("c") || option1.equals("d")) 
				{			
					option_while=true;
					break;
				}
				else
				{						
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				}
			}
			int option2=0;
			if (option1.equals("a"))
				{
					menu();
					while(option_while)
					{
						Selector.validation_int(scan);
						option2=scan.nextInt();
						scan.nextLine();
						if (option2<1 || option2 >7)
						{
							System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
						}
						else
						{
							option_while=false;
						}
					}
					series_list=Selector.rules(option2,series_list);
					//atualizar a lista de series
					series_list = Selector.rule_and(series_list);
				}
			else if (option1.equals("b"))
				{
					menu();
					option_while=true;
					while(option_while)
					{
						Selector.validation_int(scan);
						option2=scan.nextInt();
						scan.nextLine();
						if (option2<1 || option2 >7)
						{
							System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
						}
						else
						{
							option_while=false;
						}
					}

					series_list=Selector.rules(option2,series_list);
					//atualizar a lista de series
					series_list= Selector.rule_or(series_list);
				}
			else if (option1.equals("c")) // geração do XML
			{
				for (int i = project.getSerie().size() - 1; i >= 0; i--) {
						if (!(series_list.contains(project.getSerie().get(i).getSerieName()))) {
							project.getSerie().remove(i);
					}
				}
				File xmlFile1 = new File("./src/series_temporario.xml");
				File schemaFile1 = new File("./src/schema.xsd");
				Boolean result = marshall.marshalles_project(project);
				if (!result) {
					System.out.println("A pesquisa efetuada nao tem resultados.");
					
				} else {
					System.out.println("O XML foi criado e apresentado em cima!");
				}
				System.exit(0);
			}
			else if (option1.equals("d"))		
			{
					System.out.println("Bye!");
					System.exit(0);
			}
		}
		
		
		
		}
			
		
		}
			
		



