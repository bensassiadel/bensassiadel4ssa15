package esprit.tn.bensassiadel4ssa15.model.entities;

import esprit.tn.bensassiadel4ssa15.model.enums.ModePaiement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;

    private BigDecimal montant;

    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    // plusieurs paiements -> 1 contrat
    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Contrat contrat;
}

