package esprit.tn.bensassiadel4ssa15.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;

    // plusieurs maintenances -> 1 véhicule
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;
}
