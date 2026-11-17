package esprit.tn.bensassiadel4ssa15.Services;

import esprit.tn.bensassiadel4ssa15.model.entities.Agence;

import java.util.List;

public interface IAgenceService {
    Agence createAgence(Agence agence);
    Agence getAgenceById(Long id);
    Agence updateAgence(Long id, Agence agence);
    void deleteAgence(Long id);
    List<Agence> getAllAgences();
}