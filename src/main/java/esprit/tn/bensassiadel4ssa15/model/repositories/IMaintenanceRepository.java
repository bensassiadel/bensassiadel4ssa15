package esprit.tn.bensassiadel4ssa15.model.repositories;

import esprit.tn.bensassiadel4ssa15.model.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaintenanceRepository extends JpaRepository<Maintenance,Long> {
}
