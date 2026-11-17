package esprit.tn.bensassiadel4ssa15.Services;

import esprit.tn.bensassiadel4ssa15.model.entities.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule createVehicule(Vehicule vehicule);
    Vehicule getVehiculeById(Long id);
    Vehicule updateVehicule(Long id, Vehicule vehicule);
    void deleteVehicule(Long id);
    List<Vehicule> getAllVehicules();

    String getString(String str);
    Integer getNumber(Integer nbr);
}
