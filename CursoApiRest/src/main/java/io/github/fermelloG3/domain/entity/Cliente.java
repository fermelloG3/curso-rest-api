package io.github.fermelloG3.domain.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome", length = 100)
    private String nome;
    @OneToMany(mappedBy = "cliente")
    @JoinColumn
    private List<Pedido> pedidos;
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Cliente(){

    }
    public Cliente(String nome){
        this.nome = nome;
    }

    public Cliente(Integer id, String nome){
        this.nome = nome;
        this.id = id;
    }
}
