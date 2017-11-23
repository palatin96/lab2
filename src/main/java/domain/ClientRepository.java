package domain;

import java.util.List;

public interface ClientRepository {

    Client getEntity(long id);

    void editClient(Client entity);

    void removeEntity(Client entity);

    List<Client> getClients();


}
