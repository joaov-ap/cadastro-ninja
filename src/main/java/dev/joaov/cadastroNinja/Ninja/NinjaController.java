package dev.joaov.cadastroNinja.Ninja;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/create")
    public ResponseEntity<NinjaDTO> createNinja(@RequestBody NinjaDTO ninja) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ninjaService.createNinja(ninja));
    }

    @GetMapping("/show")
    public ResponseEntity<List<NinjaDTO>> showNinjas() {
        return ResponseEntity.ok(ninjaService.showNinjas());
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showNinjaById(@PathVariable Long id) {
        if (ninjaService.showNinjaById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with id " + id + " not found.");
        }
        return ResponseEntity.ok(ninjaService.showNinjaById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        if (ninjaService.updateNinja(id, ninja) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with id " + id + " not found.");
        }
        return ResponseEntity.ok(ninjaService.updateNinja(id, ninja));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNinja(@PathVariable Long id) {
        if (ninjaService.showNinjaById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with id " + id + " not found.");
        }
        ninjaService.deleteNinja(id);
        return ResponseEntity.ok("Ninja with id " + id + " deleted successfully.");
    }
}
