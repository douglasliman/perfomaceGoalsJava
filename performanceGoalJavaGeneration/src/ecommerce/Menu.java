package ecommerce;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method 

		 Scanner input = new Scanner(System.in);
		 
		  while (true) {
	            printMenu();

	            int opcao = 0;
	            try {
	                opcao = input.nextInt();
	            } catch (Exception e) {
	                System.out.println("\nDigite valores inteiros!");
	                input.nextLine();
	            }

	            switch (opcao) {
	                case 1:
	                    System.out.println("Criar Produto\n\n");
	                    break;
	                case 2:
	                    System.out.println( "Listar todas os Produtos\n\n");
	                    break;
	                case 3:
	                    System.out.println( "Buscar Produto por nome\n\n");
	                    break;
	                case 4:
	                    System.out.println( "Atualizar dados do produto\n\n");
	                    break;
	                case 5:
	                    System.out.println( "Apagar a produto\n\n");
	                    break;
	                case 6:
	                    System.out.println( "\nSaindooo!");
	                    sobre();
	                    input.close();
	                    System.exit(0);
	                default:
	                    System.out.println("\nOpção Inválida!\n" );
	                    break;
	            }
	            keyPress();
	        }
	    }

	    public static void printMenu() {
	        System.out.println(
	                 "*****************************************************");
	        System.out.println("                                                     ");
	        System.out.println("               Ecommerce Sem Nome temp               ");
	        System.out.println("                                                     ");
	        System.out.println("*****************************************************");
	        System.out.println("                                                     ");
	        System.out.println("            1 - Criar produto                        ");
	        System.out.println("            2 - Listar todos os produtos             ");
	        System.out.println("            3 - buscar produto por nome              ");
	        System.out.println("            4 - Atualizar Dados do produto            ");
	        System.out.println("            5 - Apagar produto                       ");
	        System.out.println("            6 - Sair                                 ");
	        System.out.println("                                                     ");
	        System.out.println("*****************************************************");
	        System.out.println("Entre com a opção desejada:                          ");
	        System.out.println("                                                     ");
	    }

	    public static void sobre() {
	        System.out.println("\n*********************************************************");
	        System.out.println("Projeto Desenvolvido por: ");
	        System.out.println("Douglas Lima de Queiroz");
	        System.out.println("*********************************************************");
	    }

	    public static void keyPress() {
	        try {
	            System.out.println ("\n\nPressione Enter para Continuar...");
	            System.in.read();
	        } catch (Exception e) {
	            System.out.println("Você pressionou uma tecla diferente de enter!");
	        }
	    }
	}