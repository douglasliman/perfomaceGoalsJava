package ecommerce.controller;

import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ProdutoController implements ProdutoRepository {

	private Set<Produto> produtos;
	private int proximoId;

	public ProdutoController() {
		this.produtos = new HashSet<>();
		this.proximoId = 1;
	}

	@Override
	public void cadastrarNovoProduto(Produto produto) {
		produtos.add(produto);
		proximoId = Math.max(proximoId, produto.getId() + 1);
	}

	@Override
	public void atualizarDadosProduto(Produto produto) {
		produtos.removeIf(p -> p.getId() == produto.getId());
		produtos.add(produto);
	}

	@Override
	public void removerProduto(int idProduto) {
		produtos.removeIf(p -> p.getId() == idProduto);
	}

	@Override
	public Optional<Produto> buscarProdutoPorId(int idProduto) {
		return produtos.stream().filter(p -> p.getId() == idProduto).findFirst();
	}

	@Override
	public Set<Produto> buscarTodosProdutos() {
		return produtos;
	}

	@Override
	public Optional<Produto> buscarProdutoPorNome(String nome) {
		return produtos.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst();
	}

}
