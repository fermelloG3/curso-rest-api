package io.github.fermelloG3.service;

import io.github.fermelloG3.domain.entity.Pedido;
import io.github.fermelloG3.domain.enums.StatusPedido;
import io.github.fermelloG3.rest.dto.PedidoDto;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDto dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
