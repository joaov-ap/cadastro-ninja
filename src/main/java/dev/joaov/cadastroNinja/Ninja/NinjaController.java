package dev.joaov.cadastroNinja.Ninja;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @PostMapping("/create")
    public String createNinja() {
        return "Ninja created";
    }

    @GetMapping("/showAll")
    public String showAllNinjas() {
        return "Showing ninjas";
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
