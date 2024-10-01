/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package apresentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.Dependente;
import negocio.Pessoa;

/**
 *
 * @author iapereira
 */
public class Main {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MeuPU");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Pessoa mcCatra = new Pessoa();
        mcCatra.setNome("McCatra");
        Dependente mcCatraJr = new Dependente();
        mcCatraJr.setNome("McCatraJr");
        mcCatraJr.setPessoa(mcCatra);
        mcCatra.getDependentes().add(mcCatraJr);
        entityManager.persist(mcCatra);
        entityManager.persist(mcCatraJr);       
        entityManager.getTransaction().commit();

        Pessoa m = entityManager.find(Pessoa.class, Long.valueOf(1));
//         System.out.println(m.getNome());
//        System.out.println(m.getDependentes().get(0).getNome());
////         m.getDependentes().forEach(d -> System.out.println(d));//         
//         entityManager.getTransaction().begin();
//         entityManager.remove(m.getDependentes().get(0));
//         entityManager.getTransaction().commit();
//         
         entityManager.getTransaction().begin();
         entityManager.remove(m);
         entityManager.getTransaction().commit();
    }
}
