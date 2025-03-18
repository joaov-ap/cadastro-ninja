package dev.joaov.cadastroNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel createMission(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    public List<MissoesModel> showMissions() {
        return missoesRepository.findAll();
    }

    public Optional<MissoesModel> showMissionsById(Long id) {
        return missoesRepository.findById(id);
    }

    public MissoesModel updateMission(Long id, MissoesModel missao) {
        if (!missoesRepository.existsById(id)) {
            return null;
        }

        missao.setId(id);
        return missoesRepository.save(missao);
    }

    public void deleteMission(Long id) {
        missoesRepository.deleteById(id);
    }
}
