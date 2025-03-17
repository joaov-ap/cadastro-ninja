package dev.joaov.cadastroNinja.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("update")
    public String updateMission() {
        return "Mission updated successfully";
    }

    @DeleteMapping("delete")
    public String deleteMission() {
        return "Mission deleted successfully";
    }


}
