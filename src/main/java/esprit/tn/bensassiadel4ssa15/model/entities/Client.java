package esprit.tn.bensassiadel4ssa15.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String numPermis;
    private LocalDate dateInscription;

    // 1 client -> plusieurs réservations
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
}
