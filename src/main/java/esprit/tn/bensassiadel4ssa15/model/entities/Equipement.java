package esprit.tn.bensassiadel4ssa15.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;

    private String libelle;

    // plusieurs équipements <-> plusieurs véhicules (table de jointure créée automatiquement)
    @ManyToMany
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "equipement_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicule_id")
    )
    private List<Vehicule> vehicules;
}
