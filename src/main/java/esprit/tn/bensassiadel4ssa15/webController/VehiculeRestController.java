package esprit.tn.bensassiadel4ssa15.webController;

import esprit.tn.bensassiadel4ssa15.Services.IVehiculeService;
import esprit.tn.bensassiadel4ssa15.model.entities.Vehicule;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
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

@RestController
@Tag(name = "Véhicule", description = "Gestion des véhicules et endpoints de test")
@RequiredArgsConstructor
public class VehiculeRestController {

    public final IVehiculeService iVehiculeService;

    @Operation(
            summary = "Endpoint de test",
            description = "Retourne un simple message de bienvenue permettant de vérifier que l'API est disponible."
    )
    @ApiResponse(responseCode = "200", description = "Message retourné avec succès")
    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World!");
    }

    @Operation(
            summary = "Créer un véhicule",
            description = "Crée un nouveau véhicule à partir des données envoyées et le persiste en base de données."
    )
    @ApiResponse(responseCode = "201", description = "Véhicule créé avec succès")
    @ApiResponse(responseCode = "400", description = "Données du véhicule invalides")
    @PostMapping("/vehicule")
    public ResponseEntity<Vehicule> createVehicule(@RequestBody Vehicule newVehicule) {
        Vehicule savedVehicule = iVehiculeService.createVehicule(newVehicule);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicule);
    }

    @Operation(
            summary = "Récupérer un véhicule par son identifiant",
            description = "Retourne le véhicule correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Véhicule trouvé")
    @ApiResponse(responseCode = "404", description = "Aucun véhicule trouvé avec cet identifiant")
    @GetMapping("/vehicule/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id) {
        Vehicule vehicule = iVehiculeService.getVehiculeById(id);
        if (vehicule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicule);
    }

    @Operation(
            summary = "Récupérer tous les véhicules",
            description = "Retourne la liste complète des véhicules enregistrés en base de données."
    )
    @ApiResponse(responseCode = "200", description = "Liste des véhicules retournée avec succès")
    @GetMapping("/vehicules")
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        return ResponseEntity.ok(iVehiculeService.getAllVehicules());
    }

    @Operation(
            summary = "Mettre à jour un véhicule",
            description = "Met à jour les données du véhicule correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Véhicule mis à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Aucun véhicule trouvé avec cet identifiant")
    @PutMapping("/vehicule/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        Vehicule updatedVehicule = iVehiculeService.updateVehicule(id, vehicule);
        if (updatedVehicule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVehicule);
    }

    @Operation(
            summary = "Supprimer un véhicule",
            description = "Supprime le véhicule correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "204", description = "Véhicule supprimé avec succès")
    @DeleteMapping("/vehicule/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        iVehiculeService.deleteVehicule(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Traiter une chaîne de caractères",
            description = "Envoie une chaîne de caractères au service et retourne la chaîne traitée."
    )
    @ApiResponse(responseCode = "200", description = "Chaîne traitée retournée avec succès")
    @PostMapping("/vehicule/string")
    public ResponseEntity<String> postString(@RequestBody String str) {
        return ResponseEntity.ok(iVehiculeService.getString(str));
    }

    @Operation(
            summary = "Traiter un nombre",
            description = "Envoie un nombre au service et retourne le nombre traité."
    )
    @ApiResponse(responseCode = "200", description = "Nombre traité retourné avec succès")
    @PostMapping("/vehicule/number")
    public ResponseEntity<Integer> postNumber(@RequestBody Integer nbr) {
        return ResponseEntity.ok(iVehiculeService.getNumber(nbr));
    }
}
