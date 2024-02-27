package ecommerce.model;

import java.util.Optional;

public abstract class Produto {
	
	 protected int id;
	 protected String nome;
	 protected String descricao;
	 protected String pais;
	 protected float preco;
	 protected String tipo;
	  protected int estoque;
	  
	public Produto(int id, String nome, String descricao, String pais, float preco, String tipo,int estoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.pais = pais;
		this.preco = preco;
		this.tipo = tipo;
		  this.estoque = estoque;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public void exibirDetalhes() {
		System.out.println("Nome: " + nome);
		System.out.println("Descrição: " + descricao);
		System.out.println("País: " + pais);
		System.out.println("Preço: R$" + preco);
	}
	

	public float calcularDesconto(int quantidade) {
		float desconto = 0;
		if (quantidade > 5) {
			desconto = preco * 0.1f;
		}
		return desconto;
	}
	
	
	   public void adicionarEstoque(int quantidade) {
	        estoque += quantidade;
	    }

	    public Optional<Integer> removerEstoque(int quantidade) {
	        if (quantidade <= estoque) {
	            estoque -= quantidade;
	            return Optional.of(quantidade);
	        } else {
	            System.out.println("Quantidade não disponível em estoque.");
	            return Optional.empty();
	        }
	    }
}
