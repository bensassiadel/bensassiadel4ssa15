package esprit.tn.bensassiadel4ssa15.webController;

import esprit.tn.bensassiadel4ssa15.Services.IEmployeService;
import esprit.tn.bensassiadel4ssa15.model.entities.Employe;
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
@Tag(name = "Employé", description = "Gestion des employés")
@RequiredArgsConstructor
public class EmployeRestController {

    public final IEmployeService iEmployeService;

    @Operation(
            summary = "Créer un employé",
            description = "Crée un nouvel employé à partir des données envoyées et le persiste en base de données."
    )
    @ApiResponse(responseCode = "201", description = "Employé créé avec succès")
    @ApiResponse(responseCode = "400", description = "Données de l'employé invalides")
    @PostMapping("/employe")
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe newEmploye) {
        Employe savedEmploye = iEmployeService.createEmploye(newEmploye);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmploye);
    }

    @Operation(
            summary = "Récupérer un employé par son identifiant",
            description = "Retourne l'employé correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Employé trouvé")
    @ApiResponse(responseCode = "404", description = "Aucun employé trouvé avec cet identifiant")
    @GetMapping("/employe/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long id) {
        Employe employe = iEmployeService.getEmployeById(id);
        if (employe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employe);
    }

    @Operation(
            summary = "Récupérer tous les employés",
            description = "Retourne la liste complète des employés enregistrés en base de données."
    )
    @ApiResponse(responseCode = "200", description = "Liste des employés retournée avec succès")
    @GetMapping("/employes")
    public ResponseEntity<List<Employe>> getAllEmployes() {
        return ResponseEntity.ok(iEmployeService.getAllEmployes());
    }

    @Operation(
            summary = "Mettre à jour un employé",
            description = "Met à jour les données de l'employé correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Employé mis à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Aucun employé trouvé avec cet identifiant")
    @PutMapping("/employe/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        Employe updatedEmploye = iEmployeService.updateEmploye(id, employe);
        if (updatedEmploye == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEmploye);
    }

    @Operation(
            summary = "Supprimer un employé",
            description = "Supprime l'employé correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "204", description = "Employé supprimé avec succès")
    @DeleteMapping("/employe/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {
        iEmployeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
