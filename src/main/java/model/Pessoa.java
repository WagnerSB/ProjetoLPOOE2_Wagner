package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(length = 100)
    private String email;
    
    public Pessoa()
    {     
        
    }
    
    public Pessoa(String nome)
    {     
        nome = this.nome;
    }
    
    public Pessoa(String nome, LocalDate dataNascimento)
    {     
        nome = this.nome;
        dataNascimento = this.dataNascimento;
    }
    
    public Pessoa(String nome, LocalDate dataNascimento, String email)
    {     
        nome = this.nome;
        email = this.email;
        dataNascimento = this.dataNascimento;
    }
    
    public Pessoa(String nome, String email)
    {     
        nome = this.nome;
        email = this.email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String toString(){
        return nome;
    }
}