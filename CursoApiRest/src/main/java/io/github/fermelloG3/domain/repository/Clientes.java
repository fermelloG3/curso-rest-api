package io.github.fermelloG3.domain.repository;

import io.github.fermelloG3.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static String INSERT = "insert into cliente (nome) values (?)";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";
    private static String SELECT_NAME = "SELECT * FROM CLIENTE WHERE NOME LIKE ?";
    private static String UPDATE = "UPDATE CLIENTE SET NOME = ? WHERE ID = ?";
    private static String DELETE = "DELETE FROM CLIENTE WHERE ID = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE,new Object[]{cliente.getNome(), cliente.getId()});
        return cliente;
    }
    public void delete(Cliente cliente){
        jdbcTemplate.update(DELETE,new Object[]{cliente.getId()});
    }

    public List<Cliente> obterPorNome(String nome){
        return jdbcTemplate.query(SELECT_NAME,new Object[]{"%" + nome + "%"},getRowMapper());
    }

    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, getRowMapper());
    }

    private static RowMapper<Cliente> getRowMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                return new Cliente(id, nome);
            }
        };
    }
}
