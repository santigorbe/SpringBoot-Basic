package com.gorbea.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
//@PropertySource("classpath:custom.properties") // Si quiero usar un archivo de properties diferente a aplication.properties
@PropertySources({
    @PropertySource("classpath:custom.properties"),
    @PropertySource("classpath:custom-file-2.properties")
})
public class MyFirstService {

    // PROPERTIES

    private final MyFirstClass myFirstClass;

    //private Environment environment;

    @Value("Hello Santi Gorbea")
    private String stringValue;
    @Value("123")
    private Integer intValue;

    @Value("${my.prop}")
    private String customProperyAnotherFile;

    @Value("${second.my.prop}")
    private String customProperyAnotherFile2;

    @Value("${my.custom.property}")
    private String customPropery;


     // METHODS

    // Constructor injection es el mejor y mas seguro de todos los metodos de inyeccion
    public MyFirstService(
            @Qualifier("mySecondBean") MyFirstClass myFirstClass // Le indico que bean debe usar, puede ser el nombre del bean o el del Qualifier
            //MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "the dependency is saying: " + myFirstClass.sayHello();
    }

    public String getCustomProperyAnotherFile() {
        return customProperyAnotherFile;
    }

    public String getCustomProperyAnotherFile2() {
        return customProperyAnotherFile2;
    }

    public String getCustomPropery() {
        return customPropery;
    }


    //Method injection
    /*@Autowired
    public void injectDependencies(
            @Qualifier("mySecondBean") MyFirstClass myFirstClass
    ){
        this.myFirstClass = myFirstClass;
    }*/

    // Setter injection
    /*@Autowired
    public void setMyFirstClass(
            @Qualifier("bean1") MyFirstClass myFirstClass // Lo necesito pq tengo 3 Beans que devuelven MyFirstClass
    ){
        this.myFirstClass = myFirstClass;
    }*/


    /*
    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }
    public String getOSName(){
        return environment.getProperty("os.name");
    }
    public String readProp(){
        return environment.getProperty("my.custom.property");
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }*/


}
