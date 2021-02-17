package com.luxoft.springcore.config;

import com.luxoft.springcore.objects.Person;
import com.luxoft.springcore.objects.UsualPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PersonsConfig {

    private final CityConfig cityConfig;

    @Autowired
    public PersonsConfig(CityConfig cityConfig) {
        this.cityConfig = cityConfig;
    }


    @Bean(name = "russianPerson")
    public Person getRussianPerson(){
        return new UsualPerson("Viktor Ponedelnik", 35, cityConfig.getMoscow());
    }

    @Bean(name = "bulgarianPerson")
    public Person getBulgarianPerson(){
        return new UsualPerson("Emil Kostadinov", 37, cityConfig.getSofia());
    }
}
