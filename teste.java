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
		String language ="", network="", genre ="", actor="";
		
		Project research = unmarshall.unmarshalles();
		int opcao =2;
		switch (opcao) {
		case 1:
			// pesquisa por instituicao
			System.out.print("Escolha o valor minimo do Rating: ");
			ranting = scan.nextBigInteger();
			
			break;
		case 2:
			System.out.print("Escolha o valor minimo do epis�dios : ");
			episodes= scan.nextInt();
			break;
		case 3:
			System.out.println("Escolha o valor minimo de temporadas: ");
			seasons = scan.nextInt();
			break;
		case 4:
			System.out.println("Escolha a linguagem: ");
			language= scan.nextLine();
			ArrayList<String> lista ;
			int option_list =1;
			for (int i = research.getSerie().size()-1 ; i>=0; i--){
				
				for (int j = research.getSerie().get(i).getLanguages().size(); i>=0; i--){
				
					String lang = research.getSerie().get(i).getLanguages().get(j);
					if (j==0){
						lista.add(lang);
						System.out.println(option_list + " " + lang);
						option_list ++;
					}
					else{
						if(!lista.contains(lang)){
							lista.add(lang);
							System.out.println(option_list + " " + lang);
							option_list++;
						}
					}
					
				}
			}
					int option2 =scan.nextInt(); // falta validar se � um numero
					while(1>option2 || option2>lista.size()){
						System.out.print("Escreveu um numero errado. Volte a tentar: ");
					}

				//if (!research.getSerie().get(i).getLanguages().get(i).ge)
			break;
		case 5: 
			System.out.println("Escolha a Network: ");
			network = scan.nextLine();
			break;
		case 6: 
			System.out.println("Escolha o g�nero da s�rie: ");
			genre = scan.nextLine();
			break;
		case 7:
			System.out.println("Escolhe o nome do ator: ");
			actor = scan.nextLine();
			break;
		case 8:
			System.out.println("Escolhe o tipo temporal do inicio da s�rie: ");
			
			break;
		case 9:
			System.out.println("Goodbye!!!");
			return;
			
			
		}
		

	}
}
