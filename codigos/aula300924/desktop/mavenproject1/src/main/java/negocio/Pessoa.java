/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author iapereira
 */
@Entity
public class Pessoa {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String nome;
    
//  @OneToMany(mappedBy = "pessoa", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OneToMany(mappedBy = "pessoa")
    private ArrayList<Dependente> dependentes;

    public Pessoa() {
        this.dependentes = new ArrayList<>();
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(ArrayList<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", dependentes=" + dependentes + '}';
    }
    
    
    
    
    
}
