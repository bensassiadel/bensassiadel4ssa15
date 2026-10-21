package esprit.tn.bensassiadel4ssa15.model.entities;

import esprit.tn.bensassiadel4ssa15.model.enums.RoleEmploye;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;

    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private RoleEmploye role;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;
}