package io.github.fermelloG3.domain.repository;

import io.github.fermelloG3.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itemsPedido extends JpaRepository<ItemPedido,Integer> {
}
