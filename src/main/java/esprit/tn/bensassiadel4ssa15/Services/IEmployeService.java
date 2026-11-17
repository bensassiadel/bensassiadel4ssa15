package esprit.tn.bensassiadel4ssa15.Services;

import esprit.tn.bensassiadel4ssa15.model.entities.Employe;

import java.util.List;

public interface IEmployeService {
    Employe createEmploye(Employe employe);
    Employe getEmployeById(Long id);
    Employe updateEmploye(Long id, Employe employe);
    void deleteEmploye(Long id);
    List<Employe> getAllEmployes();
}