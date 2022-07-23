package org.tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tms.Horse;
import org.tms.Pair;
import org.tms.RaceService;
import org.tms.Rider;

@Configuration
public class SpringConfig {

    @Bean
    public Horse horse1() {
        return new Horse("A");
    }

    @Bean
    public Horse horse2() {
        return new Horse("B");
    }

    @Bean
    public Horse horse3() {
        return new Horse("C");
    }

    @Bean
    public Rider rider1() {
        return new Rider("a");
    }

    @Bean
    public Rider rider2() {
        return new Rider("b");
    }

    @Bean
    public Rider rider3() {
        return new Rider("c");
    }

    @Bean
    public Pair pair1() {
        return new Pair(1, horse1(), rider1());
    }

    @Bean
    public Pair pair2() {
        return new Pair(2, horse2(), rider2());
    }

    @Bean
    public Pair pair3() {
        return new Pair(3, horse3(), rider3());
    }

    @Bean
    public RaceService raceService() {
        return new RaceService(5);
    }
}
