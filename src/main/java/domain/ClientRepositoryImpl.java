package domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private EntityManagerFactory factory;

    private EntityManager manager;

    private String persistenceName = "com.mycompany_lab5_jar_1.0-SNAPSHOTPU";

    public ClientRepositoryImpl() {
        factory = Persistence.createEntityManagerFactory(persistenceName);
        manager = factory.createEntityManager();
    }

    @Override
    public Client getEntity(long id) {
        return manager.find(Client.class, id);
    }

    @Override
    public void editClient(Client entity) {
        manager.merge(entity);
    }

    @Override
    public void removeEntity(Client entity) {
        manager.remove(entity);
    }

    @Override
    public List<Client> getClients() {
        Query query = manager.createNamedQuery("Client.findAll", Client.class);
        return query.getResultList();
    }

    @Override
    protected void finalize() throws Throwable {
        manager.close();
    }



}
