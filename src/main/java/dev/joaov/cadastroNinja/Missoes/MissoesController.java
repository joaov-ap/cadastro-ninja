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

    @PostMapping("create")
    public String createMission() {
        return "Mission created successfully";
    }

    @GetMapping("show")
    public List<MissoesModel> showMissions() {
        return missoesService.showMissions();
    }

    @GetMapping("show/{id}")
    public MissoesModel showMissionsById(@PathVariable Long id) {
        Optional<MissoesModel> missoesOptional = missoesService.showMissionsById(id);
        return missoesOptional.orElse(null);
    }

    @PutMapping("update")
    public String updateMission() {
        return "Mission updated successfully";
    }

    @DeleteMapping("delete")
    public String deleteMission() {
        return "Mission deleted successfully";
    }


}
