package ecommerce.model;

public class ChocolateMeioAmargo extends Produto {
    private int teorCacau;
    private String[] ingredientesAdicionais;

    public ChocolateMeioAmargo(int id, String nome, String descricao, String pais, float preco, String tipo,
                               int teorCacau, String[] ingredientesAdicionais) {
        super(id, nome, descricao, pais, preco, tipo, teorCacau);
        this.teorCacau = teorCacau;
        this.ingredientesAdicionais = ingredientesAdicionais;
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
        System.out.println("Ingredientes Adicionais: ");
        for (String ingrediente : ingredientesAdicionais) {
            System.out.println("- " + ingrediente);
        }
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
