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
		System.out.println("2-N�mero m�nimo de epis�dios;");
		System.out.println("3-N�mero m�nimo de temporadas;");
		System.out.println("4-S�ries com mais do que uma linguagem;");
		System.out.println("5-Network;");
		System.out.println("6-G�nero;");
		System.out.println("7-Nome de ator;");
		System.out.println("8-Per�odo temporal em que surgiu.");
		System.out.println("");
		System.out.println("Selecione a op��o que pretende: ");
		int opcao=0;
		
		
		
		
		boolean opcao_certa=true;
		
		
		while(opcao_certa)
		{
			while (!scan.hasNextInt())
			{
				scan.next();
				
				System.out.println("ERRO! Introduza um inteiro referente � op��o que pretente: ");
			}
			
			opcao=scan.nextInt();
			scan.nextLine();
			if (opcao<1 || opcao >8)
			{
				System.out.println("O valor introduzido n�o se encontra no menu. Tente novamente: ");
				
			}
			else
					{
						opcao_certa=false;
					}
			
			
		
		}
			
			
		
	}

}
