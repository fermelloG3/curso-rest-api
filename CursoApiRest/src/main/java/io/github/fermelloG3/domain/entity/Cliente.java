package io.github.fermelloG3.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotEmpty(message = "Campo nome e obrigatório.")
    private String nome;

    @Column(length = 11)
    @NotEmpty(message = "Campo CPF é obrigatório.")
    @CPF(message = "Informe um CPF válido.")
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;
}
