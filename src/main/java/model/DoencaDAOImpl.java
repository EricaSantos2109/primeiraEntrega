package model.doenca;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DoencaDAOImpl implements DoencaDAO{
    public Doenca saveDoenca(Doenca doenca) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("doenca");     
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(doenca);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return doenca;
    }

    public List<Doenca> getDoencas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("doenca");     
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT doen FROM doencas doen");
        List<Doenca> doencas = query.getResultList();
        em.close();
        emf.close();
        return doencas;
    }

    public Doenca updateDoenca(Doenca doenca) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("doenca");     
        EntityManager em = emf.createEntityManager();
        Doenca doen = em.find(Doenca.class, doenca.getId());
        em.getTransaction().begin();
        doen.setNome(doenca.getName());
        doen.setSintomas(doenca.getSintomas());
        em.getTransaction().commit();
        em.close();
        emf.close();
        return doen;
    }

    public List<Doenca> findByCode(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("doenca");     
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT doen FROM doencas doen WHERE doen.id = '" + id + "'");
        List<Doenca> doencas = query.getResultList();
        em.close();
        emf.close();
        return doencas;
    }    
}