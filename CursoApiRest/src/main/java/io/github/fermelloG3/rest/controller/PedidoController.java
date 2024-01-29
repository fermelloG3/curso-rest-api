package io.github.fermelloG3.rest.controller;

import io.github.fermelloG3.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service){
        this.service = service;
    }
}
