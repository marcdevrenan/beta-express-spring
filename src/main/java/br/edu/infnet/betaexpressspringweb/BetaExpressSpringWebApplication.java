package br.edu.infnet.betaexpressspringweb;

import br.edu.infnet.domain.controller.AccessController;
import br.edu.infnet.domain.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {AccessController.class, UserService.class, UserLoader.class})
@EntityScan(basePackages = {"br.edu.infnet.domain.model"})
@EnableJpaRepositories(basePackages = {"br.edu.infnet.domain.repository"})
@EnableFeignClients
public class BetaExpressSpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetaExpressSpringWebApplication.class, args);
    }

}
