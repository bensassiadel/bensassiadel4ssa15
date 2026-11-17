package esprit.tn.bensassiadel4ssa15.Services.Impls;

import esprit.tn.bensassiadel4ssa15.Repositories.IVehiculeRepository;
import esprit.tn.bensassiadel4ssa15.Services.IVehiculeService;
import esprit.tn.bensassiadel4ssa15.model.entities.Vehicule;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository repository;

    @Override
    @Transactional
    public Vehicule createVehicule(Vehicule vehicule) {
        vehicule.setIdVehicule(null);
        return repository.save(vehicule);
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicule getVehiculeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable : id " + id));
    }

    @Override
    @Transactional
    public Vehicule updateVehicule(Long id, Vehicule vehicule) {
        Vehicule existing = getVehiculeById(id);
        existing.setImmatriculation(vehicule.getImmatriculation());
        existing.setMarque(vehicule.getMarque());
        existing.setModele(vehicule.getModele());
        existing.setCategorie(vehicule.getCategorie());
        existing.setTarifJournalier(vehicule.getTarifJournalier());
        existing.setStatut(vehicule.getStatut());
        existing.setAgence(vehicule.getAgence());
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void deleteVehicule(Long id) {
        Vehicule existing = getVehiculeById(id);
        repository.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicule> getAllVehicules() {
        return repository.findAll();
    }

    @Override
    public String getString(String str) {
        return str;
    }

    @Override
    public Integer getNumber(Integer nbr) {
        return nbr;
    }
}
