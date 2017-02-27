package main;

import java.util.Scanner;

public class MenuSelector {
	public static void main(String[] args)
	{
		Scanner scan=new Scanner (System.in);
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("                           Texto bonito a explicar o que estamos a fazer                                ");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("1-Valor minimo de rating;");
		System.out.println("2-Número mínimo de episódios;");
		System.out.println("3-Número mínimo de temporadas;");
		System.out.println("4-Séries com mais do que uma linguagem;");
		System.out.println("5-Network;");
		System.out.println("6-Género;");
		System.out.println("7-Nome de ator;");
		System.out.println("8-Período temporal em que surgiu.");
		System.out.println("");
		System.out.println("Selecione a opção que pretende: ");
		int opcao=0;
		boolean opcao_certa=false;
		while (!opcao_certa)
		{
			scan.next();
			if (!scan.hasNextInt())
			{
			System.out.println("ERRO! Introduza um inteiro referente à opção que pretente: ");
			}
			else{
				opcao=scan.nextInt();
				if (opcao<1 || opcao >8)
				{
				
					System.out.println("O valor introduzido não se encontra no menu. Tente novamente: ");
			
				}
				else
				{
					opcao_certa=true;
				}
		
			}
		}
		opcao=scan.nextInt();
			
		
	}

}
