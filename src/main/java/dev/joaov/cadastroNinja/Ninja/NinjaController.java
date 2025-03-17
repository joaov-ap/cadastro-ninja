package dev.joaov.cadastroNinja.Ninja;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/create")
    public String createNinja() {
        return "Ninja created";
    }

    @GetMapping("/show")
    public List<NinjaModel> showNinjas() {
        return ninjaService.showNinjas();
    }

    @GetMapping("/showById")
    public String showNinjaById() {
        return "Show Ninja by id";
    }

    @PutMapping("/update")
    public String updateNinja() {
        return "Ninja updated";
    }

    @DeleteMapping("/delete")
    public String deleteNinja() {
        return "Deleting ninja";
    }
}
