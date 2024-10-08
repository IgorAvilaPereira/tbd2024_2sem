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
public class FuncionarioDAO extends DAO<Funcionario, Long>{

    public FuncionarioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void inserir(Funcionario funcionario) {        
        entityManager.getTransaction().begin();
        entityManager.persist(funcionario);             
        entityManager.getTransaction().commit();
    }

    @Override
    public void excluir(Long id) {        
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Funcionario.class, id));             
        entityManager.getTransaction().commit();
    }

    @Override
    public Funcionario obter(Long id) {  
        return entityManager.find(Funcionario.class, id);    
    }

    @Override
    void atualizar(Funcionario modelo) {
        entityManager.getTransaction().begin();
        entityManager.merge(modelo);             
        entityManager.getTransaction().commit();
    }

   
    
}
