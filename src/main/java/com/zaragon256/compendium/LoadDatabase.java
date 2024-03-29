package com.zaragon256.compendium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {


    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CreatureRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Creature("Caladrius", "bird")));
            log.info("Preloading " + repository.save(new Creature("Bugbear", "bear")));
        };
    }
}
