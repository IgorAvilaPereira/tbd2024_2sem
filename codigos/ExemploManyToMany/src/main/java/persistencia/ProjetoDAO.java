/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import javax.persistence.EntityManager;
import negocio.Funcionario;
import negocio.Projeto;

/**
 *
 * @author iapereira
 */
public class ProjetoDAO extends DAO<Projeto, Long> {

    private final EntityManager entityManager;

    public ProjetoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void inserir(Projeto projeto) {
        entityManager.getTransaction().begin();
        entityManager.persist(projeto);             
        entityManager.getTransaction().commit();
    }

    @Override
    public void excluir(Long id) {        
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Projeto.class, id));             
        entityManager.getTransaction().commit();
    }

    @Override
    public Projeto obter(Long id) {
        return entityManager.find(Projeto.class, id);
    }

    @Override
    void atualizar(Projeto modelo) {
        entityManager.getTransaction().begin();
        entityManager.merge(modelo);             
        entityManager.getTransaction().commit();    
    }
    
}
