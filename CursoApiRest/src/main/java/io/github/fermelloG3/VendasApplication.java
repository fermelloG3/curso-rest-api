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
            clientes.salvar(new Cliente("Fernando"));
            clientes.salvar(new Cliente("Gregorio"));

            System.out.println("Obtendo Clientes");
            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);
/*



            System.out.println("Buscando clientes por nome");
            clientes.obterPorNome("nan").forEach(System.out::println);

            System.out.println("Atualizando Clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + ".Atualizado");
                clientes.atualizar(c);
            });
            todosClientes.forEach(System.out::println);

            System.out.println("Deletando Clientes");
            clientes.obterTodos().forEach(c -> {
                clientes.delete(c);
            });

            todosClientes = clientes.obterTodos();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }else {
                todosClientes.forEach(System.out::println);
            }*/

        };
    }


    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);

    }

}
