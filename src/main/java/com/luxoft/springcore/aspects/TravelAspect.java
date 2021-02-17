package com.luxoft.springcore.aspects;

import com.luxoft.springcore.objects.City;
import com.luxoft.springcore.objects.Person;
import com.luxoft.springcore.objects.UsualPerson;
import lombok.Setter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Aspect
@Service
@PropertySource("classpath:application.properties")
public class TravelAspect {

    private final Map<String, Integer> distances;

    public TravelAspect(@Value("#{${distances}}") Map<String, Integer> distances) {
        this.distances = distances;
    }

    @Pointcut("execution(* *.travel(..))")
    public void travel(){}



    @Around("travel()")
    public Integer distanceTraveled(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        City from = (City) (thisJoinPoint.getArgs())[0];
        City to = (City) (thisJoinPoint.getArgs())[1];
        Integer answer = distances.get(from.getName() + to.getName());
        if (answer == null) {
            throw new Exception("noSuchPath");
        }
        UsualPerson person =(UsualPerson)thisJoinPoint.getThis();
        person.setDistanceTravelled(person.getDistanceTravelled() + answer);
        return answer;
    }

}
