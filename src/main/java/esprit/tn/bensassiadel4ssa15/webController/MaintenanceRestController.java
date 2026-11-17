package esprit.tn.bensassiadel4ssa15.webController;

import esprit.tn.bensassiadel4ssa15.Services.IMaintenanceService;
import esprit.tn.bensassiadel4ssa15.model.entities.Maintenance;
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
@Tag(name = "Maintenance", description = "Gestion des maintenances des véhicules")
@RequiredArgsConstructor
public class MaintenanceRestController {

    public final IMaintenanceService iMaintenanceService;

    @Operation(
            summary = "Créer une maintenance",
            description = "Crée une nouvelle maintenance à partir des données envoyées et la persiste en base de données."
    )
    @ApiResponse(responseCode = "201", description = "Maintenance créée avec succès")
    @ApiResponse(responseCode = "400", description = "Données de la maintenance invalides")
    @PostMapping("/maintenance")
    public ResponseEntity<Maintenance> createMaintenance(@RequestBody Maintenance newMaintenance) {
        Maintenance savedMaintenance = iMaintenanceService.createMaintenance(newMaintenance);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMaintenance);
    }

    @Operation(
            summary = "Récupérer une maintenance par son identifiant",
            description = "Retourne la maintenance correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Maintenance trouvée")
    @ApiResponse(responseCode = "404", description = "Aucune maintenance trouvée avec cet identifiant")
    @GetMapping("/maintenance/{id}")
    public ResponseEntity<Maintenance> getMaintenanceById(@PathVariable Long id) {
        Maintenance maintenance = iMaintenanceService.getMaintenanceById(id);
        if (maintenance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(maintenance);
    }

    @Operation(
            summary = "Récupérer toutes les maintenances",
            description = "Retourne la liste complète des maintenances enregistrées en base de données."
    )
    @ApiResponse(responseCode = "200", description = "Liste des maintenances retournée avec succès")
    @GetMapping("/maintenances")
    public ResponseEntity<List<Maintenance>> getAllMaintenances() {
        return ResponseEntity.ok(iMaintenanceService.getAllMaintenances());
    }

    @Operation(
            summary = "Mettre à jour une maintenance",
            description = "Met à jour les données de la maintenance correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Maintenance mise à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Aucune maintenance trouvée avec cet identifiant")
    @PutMapping("/maintenance/{id}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        Maintenance updatedMaintenance = iMaintenanceService.updateMaintenance(id, maintenance);
        if (updatedMaintenance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMaintenance);
    }

    @Operation(
            summary = "Supprimer une maintenance",
            description = "Supprime la maintenance correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "204", description = "Maintenance supprimée avec succès")
    @DeleteMapping("/maintenance/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long id) {
        iMaintenanceService.deleteMaintenance(id);
        return ResponseEntity.noContent().build();
    }
}
