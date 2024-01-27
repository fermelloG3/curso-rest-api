package io.github.fermelloG3;

import io.github.fermelloG3.domain.entity.Cliente;
import io.github.fermelloG3.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {


    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {

            System.out.println("Inserindo Clientes com JPA");
            clientes.save(new Cliente("Fernando"));
            clientes.save(new Cliente("Gregorio"));

            boolean existe = clientes.existsByNome("Fernando");
            System.out.println("Existe um nome Fernando na base de dados? " + existe);

            List<Cliente> clientesPorNombre = clientes.encontrarPorNome("nan");
            clientesPorNombre.forEach(System.out::println);


        };
    }


    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);

    }

}
