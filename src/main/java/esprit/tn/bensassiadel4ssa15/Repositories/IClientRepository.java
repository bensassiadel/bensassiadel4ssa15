package esprit.tn.bensassiadel4ssa15.Repositories;

import esprit.tn.bensassiadel4ssa15.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {
}