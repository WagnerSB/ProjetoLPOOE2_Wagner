
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistemasemanaacademica.dao.PersistenciaJPA;


public class TesteConexao {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TesteConexao() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        if(jpa.conexaoAberta()){
            System.out.println("Conexao Aberta");
        }
        else{
            System.out.println("Erro ao abrir");
        }
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
        System.out.println("Conexao Fechada");
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testeConexao() {
         System.out.println("Conexao realizada com sucesso");
     }
     
}
