package esprit.tn.bensassiadel4ssa15.webController;

import esprit.tn.bensassiadel4ssa15.Services.IClientService;
import esprit.tn.bensassiadel4ssa15.model.entities.Client;
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
@Tag(name = "Client", description = "Gestion des clients")
@RequiredArgsConstructor
public class ClientRestController {

    public final IClientService iClientService;

    @Operation(
            summary = "Créer un client",
            description = "Crée un nouveau client à partir des données envoyées et le persiste en base de données."
    )
    @ApiResponse(responseCode = "201", description = "Client créé avec succès")
    @ApiResponse(responseCode = "400", description = "Données du client invalides")
    @PostMapping("/client")
    public ResponseEntity<Client> createClient(@RequestBody Client newClient) {
        Client savedClient = iClientService.createClient(newClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @Operation(
            summary = "Récupérer un client par son identifiant",
            description = "Retourne le client correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Client trouvé")
    @ApiResponse(responseCode = "404", description = "Aucun client trouvé avec cet identifiant")
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = iClientService.getClientById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @Operation(
            summary = "Récupérer tous les clients",
            description = "Retourne la liste complète des clients enregistrés en base de données."
    )
    @ApiResponse(responseCode = "200", description = "Liste des clients retournée avec succès")
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(iClientService.getAllClients());
    }

    @Operation(
            summary = "Mettre à jour un client",
            description = "Met à jour les données du client correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "200", description = "Client mis à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Aucun client trouvé avec cet identifiant")
    @PutMapping("/client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client updatedClient = iClientService.updateClient(id, client);
        if (updatedClient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedClient);
    }

    @Operation(
            summary = "Supprimer un client",
            description = "Supprime le client correspondant à l'identifiant fourni."
    )
    @ApiResponse(responseCode = "204", description = "Client supprimé avec succès")
    @DeleteMapping("/client/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        iClientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
