package esprit.tn.bensassiadel4ssa15.model.repositories;

import esprit.tn.bensassiadel4ssa15.model.entities.Agence;
import esprit.tn.bensassiadel4ssa15.model.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContratRepository extends JpaRepository<Contrat,Long> {
}
