package dev.joaov.cadastroNinja.Missoes;

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
    public MissoesDTO createMission(@RequestBody MissoesDTO missao) {
        return missoesService.createMission(missao);
    }

    @GetMapping("/show")
    public List<MissoesModel> showMissions() {
        return missoesService.showMissions();
    }

    @GetMapping("/show/{id}")
    public MissoesModel showMissionsById(@PathVariable Long id) {
        Optional<MissoesModel> missoesOptional = missoesService.showMissionsById(id);
        return missoesOptional.orElse(null);
    }

    @PutMapping("/update/{id}")
    public MissoesModel updateMission(@PathVariable Long id, @RequestBody MissoesModel missao) {
        return missoesService.updateMission(id, missao);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMission(@PathVariable Long id) {
        missoesService.deleteMission(id);
    }

}
