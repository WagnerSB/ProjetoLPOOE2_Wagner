/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import model.Aluno;
import model.Ministrante;
import model.Oficina;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sistemasemanaacademica.dao.PersistenciaJPA;

/**
 *
 * @author 20231PF.CC0021
 */
public class TestePersistencia {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistencia() {
    }
    
    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }
    
    @Test
    public void testePersistencia() throws ParseException{
        Aluno a = new Aluno();
        a.setNome("Jorge dos Santos");
        a.setEmail("jorge@teste.com");
        a.setMatricula("20231PF.CC0099");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse("20/01/2005", dtf);
        a.setDataNascimento(nascimento);
        
        Aluno aa = new Aluno();
        aa.setNome("Ana Maria");
        aa.setEmail("ana@teste.com");
        aa.setMatricula("20231PF.CC0098");
        LocalDate nascimento2 = LocalDate.parse("02/08/2003", dtf);
        aa.setDataNascimento(nascimento2);
        
        Ministrante m = new Ministrante();
        
        m.setNome("Maria Aparecida");
        m.setTitulacao("Doutora");
        m.setEspecialidade("Computação aplicada");
        
        Oficina o = new Oficina();
        o.setNome("Processamento Linguagem Natural");
        o.setDescricao("Curso sobre NLP");
        o.setData(new Date(2024 - 1900, 10, 15, 10, 30));
        o.setDuracao(3.0);
        o.setMinistrante(m);
        
        o.addAluno(a);
        o.addAluno(aa);
        a.addOficina(o);
        aa.addOficina(o);
        
        
        Oficina oo = new Oficina();
        oo.setNome("Introdução ao java");
        oo.setDescricao("Curso sobre Java");
        oo.setData(new Date(2024 - 1900, 10, 15, 8, 0));
        oo.setDuracao(2.0);
        oo.setMinistrante(m);
        
        oo.addAluno(a);
        a.addOficina(oo);
        
        System.out.println("Alunos: "+a+"\n"+aa);
        System.out.println("Oficinas: "+o);
        System.out.println("Ministrantes: "+m);
        
        
        
        try {
            jpa.persist(a);
            jpa.persist(aa);
            jpa.persist(m);
            jpa.persist(o);
            jpa.persist(oo);

        } catch (Exception e) {
            System.err.println("Erro de persistencia: "+e);
        }
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
