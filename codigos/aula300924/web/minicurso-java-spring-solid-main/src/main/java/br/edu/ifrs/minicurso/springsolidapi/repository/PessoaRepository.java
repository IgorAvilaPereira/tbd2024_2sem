package br.edu.ifrs.minicurso.springsolidapi.repository;

import br.edu.ifrs.minicurso.springsolidapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

//    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Aluno a WHERE a.matricula = :matricula")
//    boolean existsByMatricula(@Param("matricula") String matricula);
    
}
