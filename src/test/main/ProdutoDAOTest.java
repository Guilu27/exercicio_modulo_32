package main;

import dao.IProdutoDAO;
import dao.ProdutoDAO;
import domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoDAOTest {
    private IProdutoDAO iProdutoDAO;

    public ProdutoDAOTest() {
        iProdutoDAO = new ProdutoDAO();
    }

    @Test
    public void cadastrarProduto() {
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setNome("Produto 1");

        Produto produtoCadastrado = iProdutoDAO.cadastrar(produto);
        assertNotNull(produtoCadastrado);
        assertNotNull(produtoCadastrado.getId());

        Produto produtoPesquisado = iProdutoDAO.pesquisar(produto.getCodigo());
        assertNotNull(produtoPesquisado);
        assertEquals(produto.getCodigo(), produtoPesquisado.getCodigo());

        iProdutoDAO.excluir(produtoCadastrado);
        Produto produtoExcluido = iProdutoDAO.pesquisar(produtoCadastrado.getCodigo());
        assertNull(produtoExcluido);
    }

    @Test
    public void pesquisarProduto() {
        Produto produto = new Produto();
        produto.setCodigo("A2");
        produto.setNome("Produto 2");

        Produto produtoCadastrado = iProdutoDAO.cadastrar(produto);
        assertNotNull(produtoCadastrado);
        assertNotNull(produtoCadastrado.getId());

        Produto produtoPesquisado = iProdutoDAO.pesquisar(produto.getCodigo());
        assertNotNull(produtoPesquisado);
        assertEquals(produto.getCodigo(), produtoPesquisado.getCodigo());

        iProdutoDAO.excluir(produtoCadastrado);
        Produto produtoExcluido = iProdutoDAO.pesquisar(produtoCadastrado.getCodigo());
        assertNull(produtoExcluido);
    }

    @Test
    public void excluirProduto() {
        Produto produto = new Produto();
        produto.setCodigo("A3");
        produto.setNome("Produto 3");

        Produto produtoCadastrado = iProdutoDAO.cadastrar(produto);
        assertNotNull(produtoCadastrado);
        assertNotNull(produtoCadastrado.getId());

        Produto produtoPesquisado = iProdutoDAO.pesquisar(produto.getCodigo());
        assertNotNull(produtoPesquisado);
        assertEquals(produto.getCodigo(), produtoPesquisado.getCodigo());

        iProdutoDAO.excluir(produtoCadastrado);
        Produto produtoExcluido = iProdutoDAO.pesquisar(produtoCadastrado.getCodigo());
        assertNull(produtoExcluido);
    }

    @Test
    public void alterarProduto() {
        Produto produto = new Produto();
        produto.setCodigo("A4");
        produto.setNome("Produto 4");

        Produto produtoCadastrado = iProdutoDAO.cadastrar(produto);
        assertNotNull(produtoCadastrado);
        assertNotNull(produtoCadastrado.getId());

        Produto produtoPesquisado = iProdutoDAO.pesquisar(produto.getCodigo());
        assertNotNull(produtoPesquisado);
        assertEquals(produto.getCodigo(), produtoPesquisado.getCodigo());

        produtoCadastrado.setNome("Produto Quatro");
        iProdutoDAO.alterar(produtoCadastrado);
        Produto produtoAlterado = iProdutoDAO.pesquisar(produtoCadastrado.getCodigo());
        assertNotNull(produtoAlterado);
        assertEquals(produtoCadastrado.getNome(), produtoAlterado.getNome());

        iProdutoDAO.excluir(produtoCadastrado);
        Produto produtoExcluido = iProdutoDAO.pesquisar(produtoCadastrado.getCodigo());
        assertNull(produtoExcluido);
    }

    @Test
    public void pesquisarTodos() {
        Produto produto1 = new Produto();
        produto1.setCodigo("A5");
        produto1.setNome("Produto 5");

        Produto produto2 = new Produto();
        produto2.setCodigo("A6");
        produto2.setNome("Produto 6");

        Produto produtoCadastrado1 = iProdutoDAO.cadastrar(produto1);
        assertNotNull(produtoCadastrado1);
        assertNotNull(produtoCadastrado1.getId());

        Produto produtoCadastrado2 = iProdutoDAO.cadastrar(produto2);
        assertNotNull(produtoCadastrado2);
        assertNotNull(produtoCadastrado2.getId());

        List<Produto> list = iProdutoDAO.pesquisarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        for (Produto prod : list) {
            iProdutoDAO.excluir(prod);
            Produto produtoExcluido = iProdutoDAO.pesquisar(prod.getCodigo());
            assertNull(produtoExcluido);
        }
    }
}
