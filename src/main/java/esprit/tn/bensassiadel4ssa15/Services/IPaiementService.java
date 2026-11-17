package esprit.tn.bensassiadel4ssa15.Services;

import esprit.tn.bensassiadel4ssa15.model.entities.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement createPaiement(Paiement paiement);
    Paiement getPaiementById(Long id);
    Paiement updatePaiement(Long id, Paiement paiement);
    void deletePaiement(Long id);
    List<Paiement> getAllPaiements();
}