
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_oficina")
public class Oficina implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(length = 100, nullable = false)
    private String nome;
    
    @Column(length = 500)
    private String descricao;
    private Date data;
    private double duracao;
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_aluno_oficina", joinColumns = @JoinColumn(name = "oficina_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private List<Aluno> alunos;

    
    @ManyToOne
    @JoinColumn(name = "ministrante", nullable = false)
    private Ministrante ministrante;

    public Oficina(String nome, String descricao, Date data, double duracao) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.duracao = duracao;
    }
    
    public Oficina()
    {
        alunos = new ArrayList<>();
    }
    
    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }

    public double getDuracao() {
        return duracao;
    }
    
    public List<Aluno> getAlunos() {
        return alunos;
    }
    
    public Ministrante getMinistrante() {
        return ministrante;
    }

    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
    
    public void setMinistrante(Ministrante ministrante) {
        this.ministrante = ministrante;
    }
    
    public void setAlunos(List<Aluno> alunos)
    {
        this.alunos = alunos;
    }
    
    
    public void addAluno(Aluno a) {
        alunos.add(a);
    }
    
    
    
}
