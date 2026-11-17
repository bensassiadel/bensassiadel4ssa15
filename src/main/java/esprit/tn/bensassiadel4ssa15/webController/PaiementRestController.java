package esprit.tn.bensassiadel4ssa15.webController;

import esprit.tn.bensassiadel4ssa15.Services.IPaiementService;
import esprit.tn.bensassiadel4ssa15.model.entities.Paiement;
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
@Tag(name = "Paiement", description = "Gestion des paiements")
@RequiredArgsConstructor
public class PaiementRestController {

    public final IPaiementService iPaiementService;

    @Operation(
            summary = "Créer un paiement",
            description = "Crée un nouveau paiement à partir des données envoyées et le persiste en base de données."
    )
    @ApiResponse(responseCode = "201", description = "Paiement créé avec succès")
    @ApiResponse(responseCode = "400", description = "Données du paiement invalides")
    @PostMapping("/paiement")
    public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement newPaiement) {
        Paiement savedPaiement = iPaiementService.createPaiement(newPaiement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPaiement);
    }

    @Operation(
            summary = "Récupérer un paiement par son identifiant",
            description = "Retourne le paiement correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Paiement trouvé")
    @ApiResponse(responseCode = "404", description = "Aucun paiement trouvé avec cet identifiant")
    @GetMapping("/paiement/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id) {
        Paiement paiement = iPaiementService.getPaiementById(id);
        if (paiement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paiement);
    }

    @Operation(
            summary = "Récupérer tous les paiements",
            description = "Retourne la liste complète des paiements enregistrés en base de données."
    )
    @ApiResponse(responseCode = "200", description = "Liste des paiements retournée avec succès")
    @GetMapping("/paiements")
    public ResponseEntity<List<Paiement>> getAllPaiements() {
        return ResponseEntity.ok(iPaiementService.getAllPaiements());
    }

    @Operation(
            summary = "Mettre à jour un paiement",
            description = "Met à jour les données du paiement correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Paiement mis à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Aucun paiement trouvé avec cet identifiant")
    @PutMapping("/paiement/{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long id, @RequestBody Paiement paiement) {
        Paiement updatedPaiement = iPaiementService.updatePaiement(id, paiement);
        if (updatedPaiement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPaiement);
    }

    @Operation(
            summary = "Supprimer un paiement",
            description = "Supprime le paiement correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "204", description = "Paiement supprimé avec succès")
    @DeleteMapping("/paiement/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        iPaiementService.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
