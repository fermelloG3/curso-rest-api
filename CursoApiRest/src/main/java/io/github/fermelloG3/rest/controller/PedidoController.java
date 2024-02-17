package io.github.fermelloG3.rest.controller;

import io.github.fermelloG3.domain.entity.Pedido;
import io.github.fermelloG3.rest.dto.PedidoDto;
import io.github.fermelloG3.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDto dto){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();

    }
}
