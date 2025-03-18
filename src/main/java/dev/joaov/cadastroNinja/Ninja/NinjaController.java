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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.createNinja(ninja);
    }

    @GetMapping("/show")
    public List<NinjaDTO> showNinjas() {
        return ninjaService.showNinjas();
    }

    @GetMapping("/show/{id}")
    public NinjaDTO showNinjaById(@PathVariable Long id) {
        return ninjaService.showNinjaById(id);
    }

    @PutMapping("/update/{id}")
    public NinjaDTO updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.updateNinja(id, ninja);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }
}
