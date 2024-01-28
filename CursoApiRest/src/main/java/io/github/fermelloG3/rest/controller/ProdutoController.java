package io.github.fermelloG3.rest.controller;

import io.github.fermelloG3.domain.entity.Cliente;
import io.github.fermelloG3.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private Clientes clientes;

    public ProdutoController (Clientes clientes){
        this.clientes = clientes;
    }

    @GetMapping
    public Cliente getProdutoById(Integer id){
        return clientes.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }

    public void saveProduto

}
