package dev.joaov.cadastroNinja.Ninja;

import dev.joaov.cadastroNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_ninja")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

}
