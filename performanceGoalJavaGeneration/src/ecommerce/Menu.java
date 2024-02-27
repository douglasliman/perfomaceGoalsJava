package ecommerce;
import ecommerce.controller.ProdutoController;
import ecommerce.model.ChocolateAoLeite;
import ecommerce.model.ChocolateAmargo;
import ecommerce.model.ChocolateBranco;
import ecommerce.model.ChocolateMeioAmargo;
import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.Optional;

public class Menu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProdutoRepository produtoRepository = new ProdutoController();
        Produto produto1 = new ChocolateAoLeite(1000, "Chocolate ao Leite 1", "Delicioso chocolate ao leite", "Brasil", 5.99f, "Chocolate Ao Leite", 20, "Brasil");
        Produto produto2 = new ChocolateAmargo(1001, "Chocolate Amargo 1", "Chocolate amargo com alto teor de cacau", "Bélgica", 7.99f, "Chocolate Amargo", 70);
        Produto produto3 = new ChocolateBranco(1002, "Chocolate Branco 1", "Chocolate branco cremoso e suave", "Suíça", 4.99f, "Chocolate Branco", 0);
        Produto produto4 = new ChocolateMeioAmargo(1003, "Chocolate Meio Amargo 1", "Chocolate meio amargo com equilíbrio perfeito de sabores", "Peru", 6.99f, "Chocolate Meio Amargo", 50);

        produtoRepository.cadastrarNovoProduto(produto1);
        produtoRepository.cadastrarNovoProduto(produto2);
        produtoRepository.cadastrarNovoProduto(produto3);
        produtoRepository.cadastrarNovoProduto(produto4);
        while (true) {
            printMenu();

            int opcao = 0;
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                input.nextLine();
            }

            switch (opcao) {
                case 1:
                    criarProduto(input, produtoRepository);
                    break;
                case 2:
                    listarProdutos(produtoRepository);
                    break;
                case 3:
                    atualizarProduto(input, produtoRepository);
                    break;
                case 4:
                    removerProduto(input, produtoRepository);
                    break;
                case 5:
                	buscarProdutoPorId(input,  produtoRepository);
                    break;
                case 6:
                	buscarProdutoPorNome(input,  produtoRepository);
                    break;
                case 7:
                    System.out.println("\nTe vejo em breve!");
                    sobre();
                    input.close();
                    System.exit(0);
                    
                default:
                    System.out.println("\nOpção Inválida!\n");
                    break;
            }
            keyPress();
        }
    }

   




	public static void printMenu() {
        System.out.println("*****************************************************");
        System.out.println("                                                     ");
        System.out.println("                   My ChocoLove                      ");
        System.out.println("                                                     ");
        System.out.println("*****************************************************");
        System.out.println("                                                     ");
        System.out.println("            1 - Criar produto                        ");
        System.out.println("            2 - Listar todos os produtos             ");
        System.out.println("            3 - Atualizar dados do produto           ");
        System.out.println("            4 - Apagar produto                       ");
        System.out.println("            5 - buscar por id	                      ");
        System.out.println("            6 - buscar por nome	                      ");
        System.out.println("            7 - Sair                                 ");
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
            System.out.println("\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (Exception e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }

    public static void criarProduto(Scanner input, ProdutoRepository produtoRepository) {
        System.out.println("Escolha o tipo de produto:");
        System.out.println("1 - Chocolate Ao Leite");
        System.out.println("2 - Chocolate Amargo");
        System.out.println("3 - Chocolate Branco");
        System.out.println("4 - Chocolate Meio Amargo");
        int tipo = input.nextInt();

        System.out.println("Digite o nome do produto:");
        input.nextLine(); 
        String nome = input.nextLine();

        System.out.println("Digite a descrição do produto:");
        String descricao = input.nextLine();

        System.out.println("Digite o país de origem do produto:");
        String pais = input.nextLine();

        float preco = 0;
        boolean precoValido = false;
        while (!precoValido) {
            System.out.println("Digite o preço do produto:");
            try {
                preco = input.nextFloat();
                if (preco <= 0) {
                    throw new InputMismatchException("O preço deve ser um valor positivo!");
                }
                precoValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor de preço inválido! Digite novamente.");
                input.nextLine(); 
            }
        }

        Produto produto = null;

        switch (tipo) {
            case 1:
                produto = new ChocolateAoLeite(1, nome, descricao, pais, preco, "Chocolate Ao Leite", 20, "Brasil");
                break;
            case 2:
                produto = new ChocolateAmargo(2, nome, descricao, pais, preco, "Chocolate Amargo", 70);
                break;
            case 3:
                produto = new ChocolateBranco(3, nome, descricao, pais, preco, "Chocolate Branco", 0);
                break;
            case 4:
                produto = new ChocolateMeioAmargo(4, nome, descricao, pais, preco, "Chocolate Meio Amargo", 50);
                break;
            default:
                System.out.println("Tipo de produto inválido!");
                return;
        }

        produtoRepository.cadastrarNovoProduto(produto);
        System.out.println("Produto criado com sucesso!");
    }

    public static void listarProdutos(ProdutoRepository produtoRepository) {
        Set<Produto> produtos = produtoRepository.buscarTodosProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            System.out.println("Listagem de produtos:");
            for (Produto produto : produtos) {
                System.out.println("ID: " + produto.getId()); 
                produto.exibirDetalhes();
                System.out.println("-----------------------------");
            }
        }
    }
    
    public static void atualizarProduto(Scanner input, ProdutoRepository produtoRepository) {
        int idProduto;
        Optional<Produto> produtoOptional;

        do {
            System.out.println("Digite o ID do produto a ser atualizado:");
            idProduto = input.nextInt();
            input.nextLine();

            produtoOptional = produtoRepository.buscarProdutoPorId(idProduto);

            if (!produtoOptional.isPresent()) {
                System.out.println("Produto não encontrado. Digite novamente ou pressione 0 para voltar ao menu principal:");
                if (input.nextInt() == 0) {
                    return; 
                }
            }
        } while (!produtoOptional.isPresent());

        Produto produto = produtoOptional.get();

        System.out.println("Digite o novo nome do produto:");
        String nome = input.nextLine();
        produto.setNome(nome);

        System.out.println("Digite a nova descrição do produto:");
        String descricao = input.nextLine();
        produto.setDescricao(descricao);

        System.out.println("Digite o novo país de origem do produto:");
        String pais = input.nextLine();
        produto.setPais(pais);

        float preco;
        while (true) {
            System.out.println("Digite o novo preço do produto:");
            try {
                preco = input.nextFloat();
                if (preco <= 0) {
                    throw new InputMismatchException("O preço deve ser um valor positivo!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor de preço inválido! Digite novamente.");
                input.nextLine(); 
            }
        }
        produto.setPreco(preco);

        produtoRepository.atualizarDadosProduto(produto);
        System.out.println("Produto atualizado com sucesso!");
    }


    private static void buscarProdutoPorId(Scanner input, ProdutoRepository produtoRepository) {
        System.out.println("Digite o ID do produto a ser encontrado:");
        int idProduto = input.nextInt();
        input.nextLine();

        Optional<Produto> produtoOptional = produtoRepository.buscarProdutoPorId(idProduto);

        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            System.out.println("Produto encontrado:");
            System.out.println("ID: " + produto.getId());
            produto.exibirDetalhes();
            System.out.println("-----------------------------");
        } else {
            System.out.println("Produto não encontrado.");
            System.out.println("-----------------------------");
        }
    }
    
    private static void buscarProdutoPorNome(Scanner input, ProdutoRepository produtoRepository) {
        System.out.println("Digite o Nome do produto a ser encontrado:");
        String nomeProduto = input.nextLine();
        input.nextLine();

        Optional<Produto> produtoOptional = produtoRepository.buscarProdutoPorNome(nomeProduto);

        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            System.out.println("Produto encontrado:");
            System.out.println("Nome: " + produto.getNome());
            produto.exibirDetalhes();
            System.out.println("-----------------------------");
        } else {
            System.out.println("Produto não encontrado.");
            System.out.println("-----------------------------");
        }
    }
    public static void removerProduto(Scanner input, ProdutoRepository produtoRepository) {
        System.out.println("Digite o ID do produto a ser removido:");
        int idProduto = input.nextInt();

        Optional<Produto> produtoOptional = produtoRepository.buscarProdutoPorId(idProduto);

        if (produtoOptional.isPresent()) {
            produtoRepository.removerProduto(idProduto);
            System.out.println("Produto removido com sucesso!");
            System.out.println("-----------------------------");
        } else {
            System.out.println("Produto não encontrado.");
            System.out.println("-----------------------------");
        }
    }
}
