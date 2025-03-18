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

    @PutMapping("/update/{id}")
    public NinjaModel updateNinja(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        return ninjaService.updateNinja(id, ninja);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }
}
