package br.com.magalu.referenciaprojetofinal;

import br.com.magalu.referenciaprojetofinal.controllers.CarroController;
import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import br.com.magalu.referenciaprojetofinal.domain.repository.CarroRepository;
import br.com.magalu.referenciaprojetofinal.service.CarroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackageClasses = {Carro.class, CarroService.class})
@EnableJpaRepositories(basePackages = {
		"br.com.magalu.referenciaprojetofinal.domain.repository.**"
		})
@SpringBootApplication
public class ReferenciaProjetoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReferenciaProjetoFinalApplication.class, args);
	}

}
