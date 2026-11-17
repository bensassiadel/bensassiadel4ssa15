package esprit.tn.bensassiadel4ssa15.Services;

import esprit.tn.bensassiadel4ssa15.model.entities.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement createEquipement(Equipement equipement);
    Equipement getEquipementById(Long id);
    Equipement updateEquipement(Long id, Equipement equipement);
    void deleteEquipement(Long id);
    List<Equipement> getAllEquipements();
}