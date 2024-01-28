package io.github.fermelloG3.rest.controller;

import io.github.fermelloG3.domain.entity.Cliente;
import io.github.fermelloG3.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private Clientes clientes;

    public ClienteController(Clientes clientes){
        this.clientes = clientes;
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Integer id){
        return clientes.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }
    @PostMapping
    public ResponseEntity saveCliente(@RequestBody Cliente cliente){
        Cliente saveCliente = clientes.save(cliente);
        return ResponseEntity.ok(saveCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCliente(@PathVariable Integer id){

        Optional<Cliente> deletedCliente = clientes.findById(id);

        if(deletedCliente.isPresent()){
            clientes.delete(deletedCliente.get());

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente cliente){
        return clientes
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
            return ResponseEntity.noContent().build();
        }).orElseGet(()-> ResponseEntity.notFound().build() );

    }

    @GetMapping
    public ResponseEntity find(Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher
                                 .matching()
                                 .withIgnoreCase()
                                 .withStringMatcher(
                                         ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = clientes.findAll(example);
        return ResponseEntity.ok(lista);

    }
}


