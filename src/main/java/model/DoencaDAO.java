package model.doenca;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public interface DoencaDAO {
    public Doenca saveDoenca(Doenca doenca);
    public List<Doenca> getDoencas();
    public Doenca updateDoenca(Doenca doenca);
    public List<Doenca> findByCode(String id);
}