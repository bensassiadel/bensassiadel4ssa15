package esprit.tn.bensassiadel4ssa15.Services.Impls;

import esprit.tn.bensassiadel4ssa15.Repositories.IContratRepository;
import esprit.tn.bensassiadel4ssa15.Services.IContratService;
import esprit.tn.bensassiadel4ssa15.model.entities.Contrat;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final IContratRepository repository;

    @Override
    @Transactional
    public Contrat createContrat(Contrat contrat) {
        contrat.setIdContrat(null);
        return repository.save(contrat);
    }

    @Override
    @Transactional(readOnly = true)
    public Contrat getContratById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable : id " + id));
    }

    @Override
    @Transactional
    public Contrat updateContrat(Long id, Contrat contrat) {
        Contrat existing = getContratById(id);
        existing.setDateSignature(contrat.getDateSignature());
        existing.setMontantTotal(contrat.getMontantTotal());
        existing.setValide(contrat.isValide());
        existing.setReservation(contrat.getReservation());
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void deleteContrat(Long id) {
        Contrat existing = getContratById(id);
        repository.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contrat> getAllContrats() {
        return repository.findAll();
    }
}