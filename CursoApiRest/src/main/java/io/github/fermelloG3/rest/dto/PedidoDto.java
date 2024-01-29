package io.github.fermelloG3.rest.dto;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDto {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> items;
}
