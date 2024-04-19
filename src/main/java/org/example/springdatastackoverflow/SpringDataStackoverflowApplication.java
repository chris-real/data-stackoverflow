package org.example.springdatastackoverflow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mapping.context.AbstractMappingContext;

@SpringBootApplication
public class SpringDataStackoverflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataStackoverflowApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            AbstractMappingContext context = ctx.getBean(AbstractMappingContext.class);
            System.out.println(ctx.hashCode());
        };
    }

}
