package com.gorbea.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {

		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		var ctx = app.run(args);

		//MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
		//MyFirstClass myFirstClass = ctx.getBean("myBean", MyFirstClass.class); // Busca en un Bean en particular

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);

		System.out.println(myFirstService.tellAStory());
		/*System.out.println(myFirstService.getJavaVersion());
		System.out.println(myFirstService.getOSName());
		System.out.println(myFirstService.readProp());*/

		//System.out.println(myFirstService.getCustomProperyAnotherFile());
		//System.out.println(myFirstService.getCustomProperyAnotherFile2());
		System.out.println(myFirstService.getCustomPropery());
;
	}


}
