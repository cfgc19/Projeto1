import java.util.Scanner;

public class teste {

	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		System.out.println("ola:  ");

		int e = scan.nextInt();

		int ranting;

		int opcao_certa =2;
		switch (opcao_certa) {
		case 1:
			// pesquisa por instituicao
			System.out.print("Escolha o valor minimo do Rating: ");
			ranting = scan.nextInt();
			break;
		case 2:
			System.out.print("Escolha o valor minimo do Rating: ");
			break;
		}

	}
}
