package io.github.fermelloG3.domain.repository;

import io.github.fermelloG3.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente,Integer> {
    @Query(value = "select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query("delete from Cliente c where c.nome=:nome")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);
}
