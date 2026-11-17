package esprit.tn.bensassiadel4ssa15.webController;

import esprit.tn.bensassiadel4ssa15.Services.IAgenceService;
import esprit.tn.bensassiadel4ssa15.model.entities.Agence;
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
@Tag(name = "Agence", description = "Gestion des agences")
@RequiredArgsConstructor
public class AgenceRestController {

    public final IAgenceService iAgenceService;

    @Operation(
            summary = "Créer une agence",
            description = "Crée une nouvelle agence à partir des données envoyées et la persiste en base de données."
    )
    @ApiResponse(responseCode = "201", description = "Agence créée avec succès")
    @ApiResponse(responseCode = "400", description = "Données de l'agence invalides")
    @PostMapping("/agence")
    public ResponseEntity<Agence> createAgence(@RequestBody Agence newAgence) {
        Agence savedAgence = iAgenceService.createAgence(newAgence);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAgence);
    }

    @Operation(
            summary = "Récupérer une agence par son identifiant",
            description = "Retourne l'agence correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Agence trouvée")
    @ApiResponse(responseCode = "404", description = "Aucune agence trouvée avec cet identifiant")
    @GetMapping("/agence/{id}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable Long id) {
        Agence agence = iAgenceService.getAgenceById(id);
        if (agence == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agence);
    }

    @Operation(
            summary = "Récupérer toutes les agences",
            description = "Retourne la liste complète des agences enregistrées en base de données."
    )
    @ApiResponse(responseCode = "200", description = "Liste des agences retournée avec succès")
    @GetMapping("/agences")
    public ResponseEntity<List<Agence>> getAllAgences() {
        return ResponseEntity.ok(iAgenceService.getAllAgences());
    }

    @Operation(
            summary = "Mettre à jour une agence",
            description = "Met à jour les données de l'agence correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Agence mise à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Aucune agence trouvée avec cet identifiant")
    @PutMapping("/agence/{id}")
    public ResponseEntity<Agence> updateAgence(@PathVariable Long id, @RequestBody Agence agence) {
        Agence updatedAgence = iAgenceService.updateAgence(id, agence);
        if (updatedAgence == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAgence);
    }

    @Operation(
            summary = "Supprimer une agence",
            description = "Supprime l'agence correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "204", description = "Agence supprimée avec succès")
    @DeleteMapping("/agence/{id}")
    public ResponseEntity<Void> deleteAgence(@PathVariable Long id) {
        iAgenceService.deleteAgence(id);
        return ResponseEntity.noContent().build();
    }
}
