package model.epi;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EpiDAOImpl implements EpiDAO{

    public Epi saveEpi(Epi epi) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epi");     
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(epi);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return epi;
    }

    public List<Epi> getEpis() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epi");     
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT epi FROM epis epi");
        List<Epi> epis = query.getResultList();
        em.close();
        emf.close();
        return epis;
    }

    public Epi updateEpi(Epi epi) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epi");     
        EntityManager em = emf.createEntityManager();
        Epi epid = em.find(Epi.class, epi.getId());
        em.getTransaction().begin();
        epid.setColeta(epi.getColeta());
        epid.setAssociada(epi.getAssociada());
        em.getTransaction().commit();
        em.close();
        emf.close();
        return epid;
    }

    public List<Epi> findByCode(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epi");     
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT epi FROM epis epi WHERE epi.id = '" + id + "'");
        List<Epi> epis = query.getResultList();
        em.close();
        emf.close();
        return epis;
    }    
}