package dev.joaov.cadastroNinja.Ninja;

import dev.joaov.cadastroNinja.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String rank;
    private int idade;
    private MissoesModel missoesModel;

}
