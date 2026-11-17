package esprit.tn.bensassiadel4ssa15.webController;

import esprit.tn.bensassiadel4ssa15.Services.IReservationService;
import esprit.tn.bensassiadel4ssa15.model.entities.Reservation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Réservation", description = "Gestion des réservations")
@RequiredArgsConstructor
public class ReservationRestController {

    public final IReservationService iReservationService;

    @Operation(
            summary = "Créer une réservation",
            description = "Crée une nouvelle réservation à partir des données envoyées et la persiste en base de données."
    )
    @ApiResponse(responseCode = "201", description = "Réservation créée avec succès")
    @ApiResponse(responseCode = "400", description = "Données de la réservation invalides")
    @PostMapping("/reservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation newReservation) {
        Reservation savedReservation = iReservationService.createReservation(newReservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReservation);
    }

    @Operation(
            summary = "Récupérer une réservation par son identifiant",
            description = "Retourne la réservation correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Réservation trouvée")
    @ApiResponse(responseCode = "404", description = "Aucune réservation trouvée avec cet identifiant")
    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = iReservationService.getReservationById(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservation);
    }

    @Operation(
            summary = "Récupérer toutes les réservations",
            description = "Retourne la liste complète des réservations enregistrées en base de données."
    )
    @ApiResponse(responseCode = "200", description = "Liste des réservations retournée avec succès")
    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(iReservationService.getAllReservations());
    }

    @Operation(
            summary = "Mettre à jour une réservation",
            description = "Met à jour les données de la réservation correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Réservation mise à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Aucune réservation trouvée avec cet identifiant")
    @PutMapping("/reservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        Reservation updatedReservation = iReservationService.updateReservation(id, reservation);
        if (updatedReservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedReservation);
    }

    @Operation(
            summary = "Supprimer une réservation",
            description = "Supprime la réservation correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "204", description = "Réservation supprimée avec succès")
    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        iReservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
