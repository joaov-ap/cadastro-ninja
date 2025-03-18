package dev.joaov.cadastroNinja.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO createNinja(NinjaDTO ninja) {
        NinjaModel ninjaModel = ninjaMapper.map(ninja);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public List<NinjaDTO> showNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO showNinjaById(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDto) {
        Optional<NinjaModel> ninjaExiste = ninjaRepository.findById(id);

        if (!ninjaExiste.isPresent()) {
            return null;
        }

        NinjaModel ninja = ninjaMapper.map(ninjaDto);
        ninja.setId(id);
        NinjaModel editedNinja = ninjaRepository.save(ninja);
        return ninjaMapper.map(editedNinja);
    }

    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
