package sistemasemanaacademica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Aluno;
import model.Ministrante;
import model.Oficina;

public class PersistenciaJPA implements InterfaceDB {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("ProjetoLPOOE2_Wagner");

        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void persist(Object o) throws Exception {
//        entity = getEntityManager();
//        try {
//            entity.getTransaction().begin();
//            entity.persist(o);
//            entity.getTransaction().commit();
//        } catch (Exception e) {
//            if (entity.getTransaction().isActive()) {
//                entity.getTransaction().rollback();
//            }
//        }
//        
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {;
                o = entity.merge(o);
            } else {
                entity.persist(o);
            }
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao persistir: "+e);
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
//        System.out.println("Object: "+o);
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o);
            }
            entity.remove(o);
            entity.flush();
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao remover item: " + e);
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }
    

    public List<Aluno> getAlunos() {
        entity = getEntityManager();

        try {
            TypedQuery<Aluno> query
                    = entity.createQuery("Select a from Aluno a", Aluno.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Alunos: " + e);
            return null;
        }

    }
    
    public List<Aluno> getAlunos(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Aluno> query
                    = entity.createQuery("Select a from Aluno a where lower(a.nome) LIKE :n", Aluno.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Alunos: " + e);
            return null;
        }

    }
    
    
    public List<Ministrante> getMinistrantes() {
        entity = getEntityManager();

        try {
            TypedQuery<Ministrante> query
                    = entity.createQuery("Select m from Ministrante m", Ministrante.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Ministrantes: " + e);
            return null;
        }

    }
    
    public List<Ministrante> getMinistrantes(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Ministrante> query
                    = entity.createQuery("Select m from Ministrante m where lower(m.nome) LIKE :n", Ministrante.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Ministrantes: " + e);
            return null;
        }

    }
    
    
    public List<Oficina> getOficinas() {
        entity = getEntityManager();

        try {
            TypedQuery<Oficina> query
                    = entity.createQuery("Select o from Oficina o", Oficina.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Oficinas: " + e);
            return null;
        }

    }
    
    public List<Oficina> getOficinas(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Oficina> query
                    = entity.createQuery("Select o from Oficina o where lower(o.nome) LIKE :n", Oficina.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Oficinas: " + e);
            return null;
        }

    }
}
