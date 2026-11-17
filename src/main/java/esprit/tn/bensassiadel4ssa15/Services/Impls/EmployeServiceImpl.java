package esprit.tn.bensassiadel4ssa15.Services.Impls;

import esprit.tn.bensassiadel4ssa15.Repositories.IEmployeRepository;
import esprit.tn.bensassiadel4ssa15.Services.IEmployeService;
import esprit.tn.bensassiadel4ssa15.model.entities.Employe;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final IEmployeRepository repository;

    @Override
    @Transactional
    public Employe createEmploye(Employe employe) {
        employe.setIdEmploye(null);
        return repository.save(employe);
    }

    @Override
    @Transactional(readOnly = true)
    public Employe getEmployeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employe introuvable : id " + id));
    }

    @Override
    @Transactional
    public Employe updateEmploye(Long id, Employe employe) {
        Employe existing = getEmployeById(id);
        existing.setNom(employe.getNom());
        existing.setPrenom(employe.getPrenom());
        existing.setRole(employe.getRole());
        existing.setAgence(employe.getAgence());
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void deleteEmploye(Long id) {
        Employe existing = getEmployeById(id);
        repository.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employe> getAllEmployes() {
        return repository.findAll();
    }
}