package esprit.tn.bensassiadel4ssa15.Services.Impls;

import esprit.tn.bensassiadel4ssa15.Repositories.IClientRepository;
import esprit.tn.bensassiadel4ssa15.Services.IClientService;
import esprit.tn.bensassiadel4ssa15.model.entities.Client;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientRepository repository;

    @Override
    @Transactional
    public Client createClient(Client client) {
        client.setIdClient(null);
        return repository.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClientById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable : id " + id));
    }

    @Override
    @Transactional
    public Client updateClient(Long id, Client client) {
        Client existing = getClientById(id);
        existing.setNom(client.getNom());
        existing.setPrenom(client.getPrenom());
        existing.setEmail(client.getEmail());
        existing.setTelephone(client.getTelephone());
        existing.setNumPermis(client.getNumPermis());
        existing.setDateInscription(client.getDateInscription());
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        Client existing = getClientById(id);
        repository.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> getAllClients() {
        return repository.findAll();
    }
}