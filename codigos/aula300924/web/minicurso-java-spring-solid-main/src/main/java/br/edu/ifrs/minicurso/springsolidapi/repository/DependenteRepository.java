/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrs.minicurso.springsolidapi.repository;

import br.edu.ifrs.minicurso.springsolidapi.model.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {

//    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Aluno a WHERE a.matricula = :matricula")
//    boolean existsByMatricula(@Param("matricula") String matricula);
    
}
