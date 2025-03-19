package dev.joaov.cadastroNinja.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/create")
    public ResponseEntity<MissoesDTO> createMission(@RequestBody MissoesDTO missao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(missoesService.createMission(missao));
    }

    @GetMapping("/show")
    public ResponseEntity<List<MissoesDTO>> showMissions() {
        return ResponseEntity.ok(missoesService.showMissions());
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Object> showMissionsById(@PathVariable Long id) {
        if (missoesService.showMissionsById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission with id " + id + " not found.");
        }
        return ResponseEntity.ok(missoesService.showMissionsById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateMission(@PathVariable Long id, @RequestBody MissoesDTO missao) {
        if (missoesService.updateMission(id, missao) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission with id " + id + " not found.");
        }
        return ResponseEntity.ok(missoesService.updateMission(id, missao));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMission(@PathVariable Long id) {
        if (missoesService.showMissionsById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission with id " + id + " not found.");
        }
        missoesService.deleteMission(id);
        return ResponseEntity.ok("Mission with id " + id + " deleted successfully.");
    }
}
