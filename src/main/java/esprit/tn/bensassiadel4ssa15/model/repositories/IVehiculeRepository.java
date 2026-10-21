package esprit.tn.bensassiadel4ssa15.model.repositories;

import esprit.tn.bensassiadel4ssa15.model.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehiculeRepository extends JpaRepository<Vehicule,Long> {
}
