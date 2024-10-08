/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import javax.persistence.EntityManager;
import negocio.Funcionario;
import negocio.Projeto;

/**
 *
 * @author iapereira
 */
public abstract class DAO<Modelo, Pk> {

    protected EntityManager entityManager;
    
    public DAO(){
        this.entityManager = entityManager;
    }
    
    
    abstract Modelo obter(Pk id);
    abstract void inserir(Modelo modelo);
    abstract void excluir(Pk id); 
    abstract void atualizar(Modelo modelo);
    
    public void adicionaFuncionarioAoProjeto(Funcionario funcionario, Projeto projeto) {
        funcionario.getProjetos().add(projeto);
        projeto.getFuncionarios().add(funcionario);  
        entityManager.getTransaction().begin();
        entityManager.merge(funcionario);
        entityManager.merge(projeto);
        entityManager.getTransaction().commit();
        
    }
    
     public void removeFuncionarioDoProjeto(Funcionario funcionario, Projeto projeto) {
        funcionario.getProjetos().remove(projeto);
        projeto.getFuncionarios().remove(funcionario);  
        entityManager.getTransaction().begin();
        entityManager.merge(funcionario);
        entityManager.merge(projeto);
        entityManager.getTransaction().commit();
        
    }
}
