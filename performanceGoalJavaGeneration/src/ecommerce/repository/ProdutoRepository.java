package ecommerce.repository;

import ecommerce.model.Produto;
import java.util.Optional;
import java.util.Set;

public interface ProdutoRepository {

    void adicionarEstoque(int idProduto, int quantidade);

    boolean removerEstoque(int idProduto, int quantidade);

    int consultarEstoque(int idProduto);

    void cadastrarNovoProduto(Produto produto);

    void atualizarDadosProduto(Produto produto);

    void removerProduto(int idProduto);

    Optional<Produto> buscarProdutoPorId(int idProduto); 

    Set<Produto> buscarTodosProdutos();
}
