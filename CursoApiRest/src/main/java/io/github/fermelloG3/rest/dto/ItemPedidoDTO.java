package io.github.fermelloG3.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ItemPedidoDTO {
    private Integer produto;
    private Integer quantidade;
}
