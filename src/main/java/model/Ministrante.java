
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_ministrante")
public class Ministrante extends Pessoa{
    @Column(length = 30)
    private String titulacao;
    @Column(length = 30)
    private String especialidade;

    @OneToMany(mappedBy = "ministrante")
    private List<Oficina> oficinas;
    
    public Ministrante(String nome) {
        super(nome);
        oficinas = new ArrayList<>();
    }
    
    public Ministrante() {
        super();
        oficinas = new ArrayList<>();
    }

    public String getTitulacao() {
        return titulacao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public List<Oficina> getCursos() {
        return oficinas;
    }
    
    
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setListaAlunoCursos(List<Oficina> oficina) {
        this.oficinas = oficina;
    }
    
    
    
    public void addOficina(Oficina o)
    {
        oficinas.add(o);
    }
    
}
