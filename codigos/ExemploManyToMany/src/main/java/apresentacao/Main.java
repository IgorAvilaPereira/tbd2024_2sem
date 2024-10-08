/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package apresentacao;

import persistencia.ProjetoDAO;
import persistencia.FuncionarioDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.Funcionario;
import negocio.Projeto;

/**
 *
 * @author iapereira
 */
public class Main {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MeuPU");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(entityManager);
        ProjetoDAO projetoDAO = new ProjetoDAO(entityManager);
        
        Funcionario igor = new Funcionario();
        igor.setNome("igor");                    
        funcionarioDAO.inserir(igor);        
        projetoDAO.inserir(new Projeto("Projeto 1"));                     
        Projeto p1 = projetoDAO.obter(1L);       
        Funcionario f1 = funcionarioDAO.obter(1L);           
        funcionarioDAO.adicionaFuncionarioAoProjeto(f1, p1);        
        funcionarioDAO.removeFuncionarioDoProjeto(f1, p1);

        
        
        

        
    }
}
