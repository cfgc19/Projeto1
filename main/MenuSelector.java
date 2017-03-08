package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.RunnableScheduledFuture;

import generated1.Project;

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
		//lista de series que vêm de cada regra 
		ArrayList<String> series_list = new ArrayList<String>();
		//project tem a info toda
		File xmlFile = new File("./src/series.xml");		
		Project project = unmarshall.unmarshalles_project(xmlFile);
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("                           Texto bonito a explicar o que estamos a fazer                                ");
		System.out.println("------------------------------------------------------------------------------------------");
		menu();
		int opcao=0;
		String opcao1="";
		boolean opcao_certa=true;
		while(opcao_certa)
		{

			teste.validation_int(scan);
			opcao=scan.nextInt();
			scan.nextLine();
			if (opcao<1 || opcao >7)
			{
				System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
			}
			else
			{
				opcao_certa=false;
			}
		}


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
			opcao_certa=false;
			while(!opcao_certa)
			{				
				opcao1=scan.next();
				if (opcao1.equals("a") || opcao1.equals("b") || opcao1.equals("c") || opcao1.equals("d")) 
				{			
					opcao_certa=true;
					break;
				}
				else
				{						
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
				}
			}
			int opcao2=0;
			if (opcao1.equals("a"))
				{
					menu();
					while(opcao_certa)
					{
						teste.validation_int(scan);
						opcao2=scan.nextInt();
						scan.nextLine();
						if (opcao2<1 || opcao2 >7)
						{
							System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
						}
						else
						{
							opcao_certa=false;
						}
					}
					series_list=teste.rules(opcao2,series_list);
					//ATUALIZAR A NOVA LISTA DE SERIES
					series_list = teste.rule_and(series_list);
					//System.out.println(series_list);
				}
			else if (opcao1.equals("b"))
				{
					menu();
					opcao_certa=true;
					while(opcao_certa)
					{
						teste.validation_int(scan);
						opcao2=scan.nextInt();
						scan.nextLine();
						if (opcao2<1 || opcao2 >7)
						{
							System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
						}
						else
						{
							opcao_certa=false;
						}
					}

					series_list=teste.rules(opcao2,series_list);
					series_list= teste.rule_or(series_list);
				}
			else if (opcao1.equals("c")) // criar o XML
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
			else if (opcao1.equals("d"))		
			{
					System.out.println("Byebye");
					System.exit(0);
			}
		}
		
		
		
		}
			
		
		}
			
		



