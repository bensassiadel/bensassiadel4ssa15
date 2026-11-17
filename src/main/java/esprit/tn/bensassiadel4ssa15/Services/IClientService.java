package esprit.tn.bensassiadel4ssa15.Services;

import esprit.tn.bensassiadel4ssa15.model.entities.Client;

import java.util.List;

public interface IClientService {
    Client createClient(Client client);
    Client getClientById(Long id);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
    List<Client> getAllClients();
}