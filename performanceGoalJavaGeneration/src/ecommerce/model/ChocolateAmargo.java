package ecommerce.model;

public class ChocolateAmargo extends Produto {
    private int teorCacau;


    public ChocolateAmargo(int id, String nome, String descricao, String pais, float preco, String tipo,
                           int teorCacau) {
        super(id, nome, descricao, pais, preco, tipo, teorCacau);
        this.teorCacau = teorCacau;
  
    }

    public void verificarValidade() {
        System.out.println("Verificando validade do chocolate amargo...");
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); 
        System.out.println("Teor de Cacau: " + teorCacau);

    }

    @Override
    public float calcularDesconto(int quantidade) {
        float desconto = super.calcularDesconto(quantidade);
     
        if (quantidade > 5) {
            desconto += getPreco() * 0.2f;
        }
        return desconto;
    }
}