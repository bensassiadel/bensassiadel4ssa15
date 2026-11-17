package esprit.tn.bensassiadel4ssa15.Services.Impls;

import esprit.tn.bensassiadel4ssa15.Repositories.IAgenceRepository;
import esprit.tn.bensassiadel4ssa15.Services.IAgenceService;
import esprit.tn.bensassiadel4ssa15.model.entities.Agence;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository repository;

    @Override
    @Transactional
    public Agence createAgence(Agence agence) {
        agence.setIdAgence(null);
        return repository.save(agence);
    }

    @Override
    @Transactional(readOnly = true)
    public Agence getAgenceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : id " + id));
    }

    @Override
    @Transactional
    public Agence updateAgence(Long id, Agence agence) {
        Agence existing = getAgenceById(id);
        existing.setNom(agence.getNom());
        existing.setVille(agence.getVille());
        existing.setAdresse(agence.getAdresse());
        existing.setTelephone(agence.getTelephone());
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void deleteAgence(Long id) {
        Agence existing = getAgenceById(id);
        repository.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Agence> getAllAgences() {
        return repository.findAll();
    }
}