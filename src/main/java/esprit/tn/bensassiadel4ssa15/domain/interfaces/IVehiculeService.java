package esprit.tn.bensassiadel4ssa15.domain.interfaces;

import esprit.tn.bensassiadel4ssa15.model.entities.Vehicule;

public interface IVehiculeService {
     String getString(String str);
     Integer getNumber(Integer nbr);
     Vehicule createVehicule(Vehicule vehicule);
}
