package esprit.tn.bensassiadel4ssa15.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private boolean valide;

    // 1 contrat -> 1 réservation
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // Composition : les paiements dépendent du contrat
    // (si on supprime le contrat, ses paiements sont supprimés)
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paiement> paiements;
}
