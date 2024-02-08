package dao;

import domain.Produto;

import javax.persistence.*;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public void excluir(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT p FROM Produto p WHERE p.codigo = :codigo", Produto.class);
        query.setParameter("codigo", produto.getCodigo());

        Produto produtoParaExcluir = (Produto) query.getSingleResult();
        if (produtoParaExcluir != null) {
            entityManager.remove(produtoParaExcluir);
        }

        entityManager.getTransaction().commit();
    }

    @Override
    public void alterar(Produto produtoCadastrado) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT p FROM Produto p WHERE p.codigo = :codigo", Produto.class);
        query.setParameter("codigo", produtoCadastrado.getCodigo());

        Produto produtoParaAlterar = (Produto) query.getSingleResult();

        if (produtoParaAlterar != null) {
            produtoParaAlterar.setNome(produtoCadastrado.getNome());
            entityManager.merge(produtoParaAlterar);
        }

        entityManager.getTransaction().commit();
    }

    @Override
    public List<Produto> pesquisarTodos() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Query query = entityManager.createQuery("SELECT p FROM Produto p ", Produto.class);


        return query.getResultList();
    }

    @Override
    public Produto pesquisar(String codigo) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createQuery("SELECT p FROM Produto p WHERE p.codigo = :codigo");
            query.setParameter("codigo", codigo);
            return (Produto) query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Produto cadastrar(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }


}
