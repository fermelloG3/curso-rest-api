package io.github.fermelloG3.domain.entity;

import java.math.BigDecimal;

public class Produto {
    private Integer id;
    private String descricao;
    private BigDecimal prec;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrec() {
        return prec;
    }

    public void setPrec(BigDecimal prec) {
        this.prec = prec;
    }
}
