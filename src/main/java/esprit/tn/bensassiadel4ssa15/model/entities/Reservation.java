package esprit.tn.bensassiadel4ssa15.model.entities;

import esprit.tn.bensassiadel4ssa15.model.enums.StatutReservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    // plusieurs réservations -> 1 véhicule
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    // plusieurs réservations -> 1 client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // 1 réservation -> 1 contrat
    @OneToOne(mappedBy = "reservation")
    private Contrat contrat;
}

