package io.github.fermelloG3.service.impl;

import io.github.fermelloG3.domain.entity.Cliente;
import io.github.fermelloG3.domain.entity.ItemPedido;
import io.github.fermelloG3.domain.entity.Pedido;
import io.github.fermelloG3.domain.entity.Produto;
import io.github.fermelloG3.domain.repository.Clientes;
import io.github.fermelloG3.domain.repository.Pedidos;
import io.github.fermelloG3.domain.repository.Produtos;
import io.github.fermelloG3.domain.repository.itemsPedido;
import io.github.fermelloG3.exception.RegraNegocioException;
import io.github.fermelloG3.rest.dto.ItemPedidoDTO;
import io.github.fermelloG3.rest.dto.PedidoDto;
import io.github.fermelloG3.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final itemsPedido itemPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDto dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository.findById(idCliente)
                .orElseThrow(()->new RegraNegocioException("Codigo de cliente invalido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemPedidos = converterItems(pedido, dto.getItems());
        repository.save(pedido);
        itemPedidoRepository.saveAll(itemPedidos);
        pedido.setItens(itemPedidos);
        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return repository.findByIdFetchItens(id);
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não e possivel realizar um pedido sem items.");

        }

        return items
                .stream()
                .map( dto ->{
                    Integer idProducto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProducto)
                            .orElseThrow(
                                    ()-> new RegraNegocioException(
                                            "Codigo de produto invalido: "+ idProducto
                                    ));


                    ItemPedido itempedido = new ItemPedido();
                    itempedido.setQuantidade(dto.getQuantidade());
                    itempedido.setPedido(pedido);
                    itempedido.setProduto(produto);
                    return itempedido;

                }).collect(Collectors.toList());




    }
}
