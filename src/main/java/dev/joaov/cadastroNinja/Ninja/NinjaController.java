package dev.joaov.cadastroNinja.Ninja;

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
    public NinjaModel createNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.createNinja(ninja);
    }

    @GetMapping("/show")
    public List<NinjaModel> showNinjas() {
        return ninjaService.showNinjas();
    }

    @GetMapping("/show/{id}")
    public NinjaModel showNinjaById(@PathVariable Long id) {
        Optional<NinjaModel> ninjaOptional = ninjaService.showNinjaById(id);
        return ninjaOptional.orElse(null);
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
