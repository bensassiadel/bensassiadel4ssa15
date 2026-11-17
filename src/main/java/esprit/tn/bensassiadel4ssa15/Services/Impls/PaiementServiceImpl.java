package esprit.tn.bensassiadel4ssa15.Services.Impls;

import esprit.tn.bensassiadel4ssa15.Repositories.IPaiementRepository;
import esprit.tn.bensassiadel4ssa15.Services.IPaiementService;
import esprit.tn.bensassiadel4ssa15.model.entities.Paiement;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository repository;

    @Override
    @Transactional
    public Paiement createPaiement(Paiement paiement) {
        paiement.setIdPaiement(null);
        return repository.save(paiement);
    }

    @Override
    @Transactional(readOnly = true)
    public Paiement getPaiementById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable : id " + id));
    }

    @Override
    @Transactional
    public Paiement updatePaiement(Long id, Paiement paiement) {
        Paiement existing = getPaiementById(id);
        existing.setMontant(paiement.getMontant());
        existing.setDatePaiement(paiement.getDatePaiement());
        existing.setModePaiement(paiement.getModePaiement());
        existing.setContrat(paiement.getContrat());
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void deletePaiement(Long id) {
        Paiement existing = getPaiementById(id);
        repository.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paiement> getAllPaiements() {
        return repository.findAll();
    }
}