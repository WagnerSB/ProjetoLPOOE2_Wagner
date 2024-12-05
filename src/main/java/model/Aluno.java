
package model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_aluno")
public class Aluno extends Pessoa{
    
    @Column(length = 15)
    private String matricula;
    
    @ManyToMany(mappedBy = "alunos", fetch = FetchType.EAGER)
    private List<Oficina> oficinas;
    
    public Aluno() {
        super();
        oficinas = new ArrayList<>();
    }

    public Aluno(String nome) {
        super(nome);
        oficinas = new ArrayList<>();
    }

    public List<Oficina> getOficinas() {
        return oficinas;
    }

    

    public String getMatricula() {
        return matricula;
    }
    
    public List<Oficina> getCursos() {
        return oficinas;
    }
    
    
    
    

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void setOficinas(List<Oficina> oficinas) {
        this.oficinas = oficinas;
    }
    
    public void addOficina(Oficina o){
        if (!this.oficinas.contains(o)) {
        this.oficinas.add(o);
        o.addAluno(this);  // Manter a bidirecionalidade
    }
    }
    
    public void removeOficina(Oficina o) {
    if (this.oficinas.contains(o)) {
        this.oficinas.remove(o);
        o.removeAluno(this);
    }
}
    
    

    @Override
    public String toString() {
        return super.getNome() + " - " + this.matricula;
    }

    
}
