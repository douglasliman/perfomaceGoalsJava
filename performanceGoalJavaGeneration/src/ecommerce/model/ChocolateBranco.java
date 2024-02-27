package ecommerce.model;

public class ChocolateBranco extends Produto {
	private int teorLeite;

	public ChocolateBranco(int id, String nome, String descricao, String pais, float preco, String tipo, int teorLeite) {
		super(id, nome, descricao, pais, preco, tipo, teorLeite);
		this.teorLeite = teorLeite;
	}
	
	 public void exibirInstrucoesConsumo() {
	        System.out.println("Aprecie o sabor suave e cremoso do chocolate branco com queijo.");
	    }
	
	 @Override
	 public void exibirDetalhes() {
	     super.exibirDetalhes();
	     System.out.println("Teor de Leite: " + teorLeite);
	   
	 }

	 @Override
	 public float calcularDesconto(int quantidade) {
	     float desconto = super.calcularDesconto(quantidade);
	     
	     if (quantidade > 3) {
	         desconto += getPreco() * 0.1f; 
	     }
	     return desconto;
	 }
	 
	 

}
