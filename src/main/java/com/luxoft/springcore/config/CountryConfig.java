package com.luxoft.springcore.config;

import com.luxoft.springcore.objects.Country;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Configuration
@Setter
@PropertySource("classpath:locations.properties")
public class CountryConfig {

    @Value("#{${codeNames}}")
    private Map<String, String> codeNames;

    @Value("#{${countryNames}}")
    private Map<String, String> countryNames;

    @Bean
    public Country getRussia() {
        return new Country(countryNames.get("russia"), codeNames.get("russia"));
    }

    @Bean
    public Country getPoland() {
        return new Country(countryNames.get("poland"), codeNames.get("poland"));
    }

    @Bean
    public Country getBulgaria() {
        return new Country(countryNames.get("bulgaria"), codeNames.get("bulgaria"));
    }

    @Bean
    public Country getAustria() {
        return new Country(countryNames.get("austria"), codeNames.get("austria"));
    }
}
