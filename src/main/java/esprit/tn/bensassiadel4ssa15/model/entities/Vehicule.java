package esprit.tn.bensassiadel4ssa15.model.entities;

import esprit.tn.bensassiadel4ssa15.model.enums.Categorievehicule;
import esprit.tn.bensassiadel4ssa15.model.enums.Statutvehicule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    private String immatriculation;
    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    private Categorievehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private Statutvehicule statut;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;
}