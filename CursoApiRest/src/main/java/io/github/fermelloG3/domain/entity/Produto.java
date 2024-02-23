package io.github.fermelloG3.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    @NotEmpty(message = "Campo NOME é obrigatório.")
    private String nome;

    @Column(name = "descricao")
    @NotEmpty(message = "Campo DESCRIÇÃO é obrigatório.")
    private String descricao;

    @Column(name = "preco unitario")
    @NotNull(message = "Campo PREÇO é obrigatorio.")
    private BigDecimal preco;
}
