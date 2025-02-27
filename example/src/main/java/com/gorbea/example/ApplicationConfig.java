package com.gorbea.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration // Va a escanear esta clase al iniciarse main
//@Profile("dev") // Que está disponible solo para este perfil
public class ApplicationConfig {
    // Puedo hacerlo de esta forma o agregarle el @Componet a la clase para que lo roconozca
    @Bean
    @Qualifier("bean1") // Info extra para el Bean
    //@Bean("myBean") //Puedo ponerle un nombre al bean, sino por defecto será el de la funcion principal
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("First Bean");
    }

    @Bean
    //@Profile("dev") // Que está disponible solo para este perfil
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("Second Bean");
    }
    @Bean
    @Primary // Le va a dar una prioridad mas alta a este Bean
    public MyFirstClass myThirdBean(){
        return new MyFirstClass("Third Bean");
    }
}
