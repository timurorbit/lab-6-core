package com.luxoft.springcore.config;

import com.luxoft.springcore.objects.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CityConfig {
    private final CountryConfig countryConfig;

    @Autowired
    public CityConfig(CountryConfig countryConfig) {
        this.countryConfig = countryConfig;
    }

    @Bean(name = "moscow")
    public City getMoscow() {
        return new City(0,"Moscow", countryConfig.getRussia());
    }

    @Bean(name = "warsaw")
    public City getWarsaw() {
        return new City(1, "Warsaw", countryConfig.getPoland());
    }

    @Bean(name = "krakow")
    public City getKrakow() {
        return new City(2, "Krakow", countryConfig.getPoland());
    }

    @Bean(name = "sofia")
    public City getSofia() {
        return new City(3, "Sofia", countryConfig.getBulgaria());
    }

    @Bean(name = "vienna")
    public City getVienna() {
        return new City(4, "Vienna", countryConfig.getAustria());
    }
}
