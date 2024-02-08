package dao;

import domain.Produto;

import java.util.List;

public interface IProdutoDAO {
    Produto cadastrar(Produto produto);

    Produto pesquisar(String codigo);

    void excluir(Produto produto);

    void alterar(Produto produtoCadastrado);

    List<Produto> pesquisarTodos();
}
