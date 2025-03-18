package dev.joaov.cadastroNinja.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoes = new MissoesModel();

        missoes.setId(missoesDTO.getId());
        missoes.setNome(missoesDTO.getNome());
        missoes.setDificuldade(missoesDTO.getDificuldade());
        missoes.setNinjas(missoesDTO.getNinjas());

        return missoes;
    }

    public MissoesDTO map(MissoesModel missoes) {
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoes.getId());
        missoesDTO.setNome(missoes.getNome());
        missoesDTO.setDificuldade(missoes.getDificuldade());
        missoesDTO.setNinjas(missoes.getNinjas());

        return missoesDTO;
    }
}
