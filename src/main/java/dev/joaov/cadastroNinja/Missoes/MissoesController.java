package dev.joaov.cadastroNinja.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @PostMapping("create")
    public String createMission() {
        return "Mission created successfully";
    }

    @GetMapping("show")
    public String showMissions() {
        return "Missions listed successfully";
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
