package ecommerce.model;

public class ChocolateAoLeite extends Produto {
	
    private int teorCacau;
    private String origemCacau;

    public ChocolateAoLeite(int id, String nome, String descricao, String pais, float preco, String tipo,
                             int teorCacau, String origemCacau) {
        super(id, nome, descricao, pais, preco, tipo, teorCacau);
        this.teorCacau = teorCacau;
        this.origemCacau = origemCacau;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Teor de Cacau: " + teorCacau);
        System.out.println("Origem do Cacau: " + origemCacau);
    }

    
    @Override
    public float calcularDesconto(int quantidade) {
        float desconto = super.calcularDesconto(quantidade);

        if (quantidade > 5) {
            desconto += getPreco() * 0.1f;
        }
        return desconto;
    }
}