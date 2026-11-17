package esprit.tn.bensassiadel4ssa15.Services.Impls;

import esprit.tn.bensassiadel4ssa15.Repositories.IEquipementRepository;
import esprit.tn.bensassiadel4ssa15.Services.IEquipementService;
import esprit.tn.bensassiadel4ssa15.model.entities.Equipement;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipementRepository repository;

    @Override
    @Transactional
    public Equipement createEquipement(Equipement equipement) {
        equipement.setIdEquipement(null);
        return repository.save(equipement);
    }

    @Override
    @Transactional(readOnly = true)
    public Equipement getEquipementById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable : id " + id));
    }

    @Override
    @Transactional
    public Equipement updateEquipement(Long id, Equipement equipement) {
        Equipement existing = getEquipementById(id);
        existing.setLibelle(equipement.getLibelle());
        existing.setVehicules(equipement.getVehicules());
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void deleteEquipement(Long id) {
        Equipement existing = getEquipementById(id);
        repository.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Equipement> getAllEquipements() {
        return repository.findAll();
    }
}