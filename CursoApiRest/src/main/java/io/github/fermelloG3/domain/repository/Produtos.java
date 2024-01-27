package io.github.fermelloG3.domain.repository;

import io.github.fermelloG3.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository <Produto, Integer> {
}
