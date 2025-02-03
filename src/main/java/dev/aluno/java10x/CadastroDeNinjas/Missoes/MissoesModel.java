package dev.aluno.java10x.CadastroDeNinjas.Missoes;

import dev.aluno.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;

    // One mission can have many ninjas
    @Column(name = "ninjas")
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
