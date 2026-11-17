package esprit.tn.bensassiadel4ssa15.Services.Impls;

import esprit.tn.bensassiadel4ssa15.Repositories.IMaintenanceRepository;
import esprit.tn.bensassiadel4ssa15.Services.IMaintenanceService;
import esprit.tn.bensassiadel4ssa15.model.entities.Maintenance;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository repository;

    @Override
    @Transactional
    public Maintenance createMaintenance(Maintenance maintenance) {
        maintenance.setIdMaintenance(null);
        return repository.save(maintenance);
    }

    @Override
    @Transactional(readOnly = true)
    public Maintenance getMaintenanceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance introuvable : id " + id));
    }

    @Override
    @Transactional
    public Maintenance updateMaintenance(Long id, Maintenance maintenance) {
        Maintenance existing = getMaintenanceById(id);
        existing.setDateDebut(maintenance.getDateDebut());
        existing.setDateFin(maintenance.getDateFin());
        existing.setDescription(maintenance.getDescription());
        existing.setVehicule(maintenance.getVehicule());
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void deleteMaintenance(Long id) {
        Maintenance existing = getMaintenanceById(id);
        repository.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Maintenance> getAllMaintenances() {
        return repository.findAll();
    }
}