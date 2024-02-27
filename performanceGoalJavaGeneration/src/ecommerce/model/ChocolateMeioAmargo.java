package ecommerce.model;

public class ChocolateMeioAmargo extends Produto {
    private int teorCacau;

    public ChocolateMeioAmargo(int id, String nome, String descricao, String pais, float preco, String tipo,
                               int teorCacau) {
        super(id, nome, descricao, pais, preco, tipo, teorCacau);
        this.teorCacau = teorCacau;
    
    }

    public void exibirInformacoesNutricionais() {
        System.out.println("Informações nutricionais do chocolate meio amargo:");
        
    }

    public float calcularDescontoPromocional() {
        
        return getPreco() * 0.8f; 
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
            desconto += getPreco() * 0.1f;
        }
        return desconto;
    }
}
