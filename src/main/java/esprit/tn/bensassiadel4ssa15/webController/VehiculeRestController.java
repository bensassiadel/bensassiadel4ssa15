
package esprit.tn.bensassiadel4ssa15.webController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculeRestController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World!");
    }
}
