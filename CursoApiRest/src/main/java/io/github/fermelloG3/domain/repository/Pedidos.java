package io.github.fermelloG3.domain.repository;

import io.github.fermelloG3.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
