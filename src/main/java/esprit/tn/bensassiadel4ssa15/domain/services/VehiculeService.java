package esprit.tn.bensassiadel4ssa15.domain.services;

import esprit.tn.bensassiadel4ssa15.domain.interfaces.IVehiculeService;
import esprit.tn.bensassiadel4ssa15.model.entities.Vehicule;
import esprit.tn.bensassiadel4ssa15.model.repositories.IVehiculeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehiculeService implements IVehiculeService {

    public  final IVehiculeRepository iVehiculeRepository;
    @Override
    public String getString(String str) {
        return str;
    }

    @Override
    public Integer getNumber(Integer nbr) {
        return nbr;
    }


    @Override
    public Vehicule createVehicule(Vehicule newVehicule) {
        Vehicule vehicule = new Vehicule();
        vehicule.setImmatriculation(newVehicule.getImmatriculation());
        vehicule.setMarque(newVehicule.getMarque());
        vehicule.setModele(newVehicule.getModele());
        vehicule.setCategorie(newVehicule.getCategorie());
        vehicule.setTarifJournalier(newVehicule.getTarifJournalier());
        vehicule.setStatut(newVehicule.getStatut());
        vehicule.setAgence(newVehicule.getAgence());

        Vehicule savedVehicule = iVehiculeRepository.save(vehicule);
        return savedVehicule;
    }

}
