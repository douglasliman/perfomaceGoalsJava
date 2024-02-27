package ecommerce.repository;

import ecommerce.model.Produto;
import java.util.Optional;
import java.util.Set;

public interface ProdutoRepository {

    void cadastrarNovoProduto(Produto produto);

    void atualizarDadosProduto(Produto produto);

    void removerProduto(int idProduto);

    Optional<Produto> buscarProdutoPorId(int idProduto);
    
    Optional<Produto> buscarProdutoPorNome(String nome);

    Set<Produto> buscarTodosProdutos();
}
