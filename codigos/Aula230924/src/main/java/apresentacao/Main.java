/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package apresentacao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.Endereco;
import negocio.Pessoa;
import static spark.Spark.get;

/**
 *
 * @author iapereira
 */
public class Main {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MeuPU");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        get("/deletar/:id", (request, response) -> {
            Pessoa igor1 = entityManager.find(Pessoa.class, Integer.valueOf(request.params(":id")));
            entityManager.getTransaction().begin();
            entityManager.remove(igor1);
            entityManager.getTransaction().commit();
            return "deletado";
        });
        
          get("/adicionar/:nome", (request, response) -> {
            entityManager.getTransaction().begin();        
            Pessoa igor = new Pessoa();
            igor.setNome(request.params(":nome").trim());
            entityManager.persist(igor);        
            entityManager.getTransaction().commit();
            return "<h2 style='color: green'>adicionado </h2>";
        });

//        insert
//        entityManager.getTransaction().begin();        
//        Pessoa igor = new Pessoa();
//        igor.setNome("igor");
//        entityManager.persist(igor);        
//        entityManager.getTransaction().commit();
//        update
//        Pessoa igor2 = entityManager.find(Pessoa.class, 2);
//        igor2.setEndereco(new Endereco("alfredo huch", "134"));
//        entityManager.getTransaction().begin();
//        entityManager.merge(igor2);
//        entityManager.getTransaction().commit();
//        select where id = ?
//        Pessoa igor1 = entityManager.find(Pessoa.class, 1);
//        delete
//        entityManager.getTransaction().begin();
//        entityManager.remove(igor1);
//        entityManager.getTransaction().commit();
//        select all
//        List<Pessoa> vetPessoa = entityManager.createQuery("SELECT p FROM Pessoa p").getResultList();
//        vetPessoa.forEach(p -> System.out.println(p));
//
//        //        select all
//        List<Pessoa> vetPessoa2 = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.nome = 'igor'").getResultList();
//        vetPessoa2.forEach(p -> System.out.println(p));
    }
}
