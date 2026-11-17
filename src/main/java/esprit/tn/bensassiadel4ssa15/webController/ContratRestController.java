package esprit.tn.bensassiadel4ssa15.webController;

import esprit.tn.bensassiadel4ssa15.Services.IContratService;
import esprit.tn.bensassiadel4ssa15.model.entities.Contrat;
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
@Tag(name = "Contrat", description = "Gestion des contrats de location")
@RequiredArgsConstructor
public class ContratRestController {

    public final IContratService iContratService;

    @Operation(
            summary = "Créer un contrat",
            description = "Crée un nouveau contrat à partir des données envoyées et le persiste en base de données."
    )
    @ApiResponse(responseCode = "201", description = "Contrat créé avec succès")
    @ApiResponse(responseCode = "400", description = "Données du contrat invalides")
    @PostMapping("/contrat")
    public ResponseEntity<Contrat> createContrat(@RequestBody Contrat newContrat) {
        Contrat savedContrat = iContratService.createContrat(newContrat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContrat);
    }

    @Operation(
            summary = "Récupérer un contrat par son identifiant",
            description = "Retourne le contrat correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Contrat trouvé")
    @ApiResponse(responseCode = "404", description = "Aucun contrat trouvé avec cet identifiant")
    @GetMapping("/contrat/{id}")
    public ResponseEntity<Contrat> getContratById(@PathVariable Long id) {
        Contrat contrat = iContratService.getContratById(id);
        if (contrat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contrat);
    }

    @Operation(
            summary = "Récupérer tous les contrats",
            description = "Retourne la liste complète des contrats enregistrés en base de données."
    )
    @ApiResponse(responseCode = "200", description = "Liste des contrats retournée avec succès")
    @GetMapping("/contrats")
    public ResponseEntity<List<Contrat>> getAllContrats() {
        return ResponseEntity.ok(iContratService.getAllContrats());
    }

    @Operation(
            summary = "Mettre à jour un contrat",
            description = "Met à jour les données du contrat correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Contrat mis à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Aucun contrat trouvé avec cet identifiant")
    @PutMapping("/contrat/{id}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable Long id, @RequestBody Contrat contrat) {
        Contrat updatedContrat = iContratService.updateContrat(id, contrat);
        if (updatedContrat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedContrat);
    }

    @Operation(
            summary = "Supprimer un contrat",
            description = "Supprime le contrat correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "204", description = "Contrat supprimé avec succès")
    @DeleteMapping("/contrat/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        iContratService.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}
