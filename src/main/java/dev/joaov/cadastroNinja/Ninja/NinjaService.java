package dev.joaov.cadastroNinja.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public NinjaModel createNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public List<NinjaModel> showNinjas() {
        return ninjaRepository.findAll();
    }

    public Optional<NinjaModel> showNinjaById(Long id) {
        return ninjaRepository.findById(id);
    }

    public NinjaModel updateNinja(Long id, NinjaModel ninja) {
        if (!ninjaRepository.existsById(id)) {
            return null;
        }

        ninja.setId(id);
        return ninjaRepository.save(ninja);
    }

    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
