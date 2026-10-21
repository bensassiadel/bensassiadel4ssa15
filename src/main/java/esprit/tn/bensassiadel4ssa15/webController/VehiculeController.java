package esprit.tn.bensassiadel4ssa15.webController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Véhicule", description = "Gestion des véhicules et endpoints de test")
public class VehiculeRestController {

    @Operation(
            summary = "Endpoint de test",
            description = "Retourne un simple message de bienvenue permettant de vérifier que l'API est disponible."
    )
    @ApiResponse(responseCode = "200", description = "Message retourné avec succès")
    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World!");
    }
}
