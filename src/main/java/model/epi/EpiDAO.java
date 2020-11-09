package model.epi;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public interface EpiDAO {
    public Epi saveEpi(Epi epi);
    public List<Epi> getEpis();
    public Epi updateEpi(Epi epi);
    public List<Epi> findByCode(String id);
}