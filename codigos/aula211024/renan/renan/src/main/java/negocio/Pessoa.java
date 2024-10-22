package negocio;

import java.time.LocalDate;
import java.util.UUID;

// https://www.javadoc.io/doc/com.google.code.gson/gson/2.6.2/com/google/gson/annotations/Expose.html
// import com.google.gson.annotations.Expose;

public class Pessoa {
    
    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    

    public Pessoa(){
        this.id = UUID.randomUUID();
    }


    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }


    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + "]";
    }

    
    
}
