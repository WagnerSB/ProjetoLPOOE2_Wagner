
package sistemasemanaacademica.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersistenciaJPA implements InterfaceDB{
    
    EntityManager entity;
    EntityManagerFactory factory;
    
    public PersistenciaJPA(){
        factory = Persistence.createEntityManagerFactory("ProjetoLPOOE1_Wagner");
        
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
        entity = getEntityManager();
        try{
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
        } catch (Exception e)
        {
            if(entity.getTransaction().isActive()){
                entity.getTransaction().rollback();
            }
        }
    }
    
    public EntityManager getEntityManager(){
        if (entity == null || !entity.isOpen())
        {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try{
        entity.getTransaction().begin();
        entity.remove(o);
        entity.getTransaction().commit();
        } catch (Exception e)
        {
            if(entity.getTransaction().isActive()){
                entity.getTransaction().rollback();
            }
        }
    }
    
}
