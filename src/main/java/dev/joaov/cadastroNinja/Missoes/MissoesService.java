package dev.joaov.cadastroNinja.Missoes;

import dev.joaov.cadastroNinja.Ninja.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO createMission(MissoesDTO missao) {
        MissoesModel missoes = missoesMapper.map(missao);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    public List<MissoesDTO> showMissions() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO showMissionsById(Long id) {
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO updateMission(Long id, MissoesDTO missaoDto) {
        Optional<MissoesModel> missaoExiste = missoesRepository.findById(id);
        if (!missaoExiste.isPresent()) {
            return null;
        }

        MissoesModel missao = missoesMapper.map(missaoDto);
        missao.setId(id);

        if (missao.getNome() == null) {
            missao.setNome(missaoExiste.get().getNome());
        }

        if (missao.getDificuldade() == null) {
            missao.setDificuldade(missaoExiste.get().getDificuldade());
        }

        if (missao.getNinjas() == null) {
            missao.setNinjas(missaoExiste.get().getNinjas());
        }

        MissoesModel editedMissao = missoesRepository.save(missao);
        return missoesMapper.map(editedMissao);
    }

    public void deleteMission(Long id) {
        Optional<MissoesModel> missao = missoesRepository.findById(id);

        if (missao.isEmpty()) {
            return;
        }

        if (missao.get().getNinjas() != null) {
            for (NinjaModel ninja: missao.get().getNinjas()) {
                ninja.setMissoes(null);
            }

            missoesRepository.save(missao.get());
            missoesRepository.deleteById(id);
            return;
        }

        missoesRepository.deleteById(id);
    }
}
