package esprit.tn.bensassiadel4ssa15.Repositories;

import esprit.tn.bensassiadel4ssa15.model.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeRepository extends JpaRepository<Employe, Long> {
}