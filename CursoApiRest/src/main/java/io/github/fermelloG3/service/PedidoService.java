package io.github.fermelloG3.service;

import io.github.fermelloG3.domain.entity.Pedido;
import io.github.fermelloG3.rest.dto.PedidoDto;

public interface PedidoService {
    Pedido salvar(PedidoDto dto);
}
