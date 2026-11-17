package esprit.tn.bensassiadel4ssa15.Services;

import esprit.tn.bensassiadel4ssa15.model.entities.Contrat;

import java.util.List;

public interface IContratService {
    Contrat createContrat(Contrat contrat);
    Contrat getContratById(Long id);
    Contrat updateContrat(Long id, Contrat contrat);
    void deleteContrat(Long id);
    List<Contrat> getAllContrats();
}