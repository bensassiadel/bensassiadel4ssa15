package esprit.tn.bensassiadel4ssa15.webController;

import esprit.tn.bensassiadel4ssa15.Services.IEquipementService;
import esprit.tn.bensassiadel4ssa15.model.entities.Equipement;
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
@Tag(name = "Équipement", description = "Gestion des équipements des véhicules")
@RequiredArgsConstructor
public class EquipementRestController {

    public final IEquipementService iEquipementService;

    @Operation(
            summary = "Créer un équipement",
            description = "Crée un nouvel équipement à partir des données envoyées et le persiste en base de données."
    )
    @ApiResponse(responseCode = "201", description = "Équipement créé avec succès")
    @ApiResponse(responseCode = "400", description = "Données de l'équipement invalides")
    @PostMapping("/equipement")
    public ResponseEntity<Equipement> createEquipement(@RequestBody Equipement newEquipement) {
        Equipement savedEquipement = iEquipementService.createEquipement(newEquipement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipement);
    }

    @Operation(
            summary = "Récupérer un équipement par son identifiant",
            description = "Retourne l'équipement correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Équipement trouvé")
    @ApiResponse(responseCode = "404", description = "Aucun équipement trouvé avec cet identifiant")
    @GetMapping("/equipement/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        Equipement equipement = iEquipementService.getEquipementById(id);
        if (equipement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipement);
    }

    @Operation(
            summary = "Récupérer tous les équipements",
            description = "Retourne la liste complète des équipements enregistrés en base de données."
    )
    @ApiResponse(responseCode = "200", description = "Liste des équipements retournée avec succès")
    @GetMapping("/equipements")
    public ResponseEntity<List<Equipement>> getAllEquipements() {
        return ResponseEntity.ok(iEquipementService.getAllEquipements());
    }

    @Operation(
            summary = "Mettre à jour un équipement",
            description = "Met à jour les données de l'équipement correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Équipement mis à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Aucun équipement trouvé avec cet identifiant")
    @PutMapping("/equipement/{id}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable Long id, @RequestBody Equipement equipement) {
        Equipement updatedEquipement = iEquipementService.updateEquipement(id, equipement);
        if (updatedEquipement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEquipement);
    }

    @Operation(
            summary = "Supprimer un équipement",
            description = "Supprime l'équipement correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "204", description = "Équipement supprimé avec succès")
    @DeleteMapping("/equipement/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        iEquipementService.deleteEquipement(id);
        return ResponseEntity.noContent().build();
    }
}
