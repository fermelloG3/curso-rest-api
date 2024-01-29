package io.github.fermelloG3.service.impl;

import io.github.fermelloG3.domain.repository.Pedidos;
import io.github.fermelloG3.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository){
        this.repository = repository;
    }
}
