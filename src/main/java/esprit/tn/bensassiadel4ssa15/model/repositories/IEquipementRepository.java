package esprit.tn.bensassiadel4ssa15.model.repositories;

import esprit.tn.bensassiadel4ssa15.model.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEquipementRepository extends JpaRepository<Agence,Long> {
}
