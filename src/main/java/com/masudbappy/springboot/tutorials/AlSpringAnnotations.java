package com.masudbappy.springboot.tutorials;

public class AlSpringAnnotations {
    /*
    So First Annotation is @SpringBootApplication.
    Many Spring Boot developers like their apps to use auto-configuration, component scan and be able to define extra configuration
     on their "application class". A single @SpringBootApplication annotation can be used to enable those three features, that is:

@EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
@ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
@Configuration: allow to register extra beans in the context or import additional configuration classes
The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration, and @ComponentScan with
their default attributes, as shown in the following example:
package com.example.myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

    @Component
    ==========
    If we use this annotation over a class it means this is class which i want an object. When we call run it
    will create the spring container for you and it will create one Object say for Alien a1 . It will create a A1 object
    for you which type is Alien. The moment you say getBean(Alien.class) your spring framework will say okay developer wants
    a bean of Alien. then it will check in the spring container that the bean is available or not which type is Alien. And if
    found then it will say hey we do have a bean which type is Alien. It will get connected autometically.
    That means spring framework is injecting this object in your application. That's what we say
    dependency injection.

    Question:
    =========
    What if i use getBean once more like if we create two objects??
    Alien a = context.getBean(Alien.class);
		a.show(); if we comment this two line we can see the "object is created."
		because we have a constructor in the Alien class. Spring framework says hey
		if don't want the object we will give it to you because by default speing uses a concept of singleton design pattern.
		Which means it will give you the object pre hand you don't have to wait for the object creation. the moment you
		start the application it will give you the object.
		Alien a = context.getBean(Alien.class);
		a.show();
		Alien a1 = context.getBean(Alien.class);
		a1.show();
		if we call the above two lines two times?
		It will created instance just one because by default spring uses the concept of Singleton.
		And if we use prototype here. then you will get two object.

		@Autowire
		=========
        If we declare a laptop object and use it in the Alien class then how this two
        two object get connected from the spring container. Because one object is depend to other.
        So how we connect them? just simply use @Autowire. Then it will search the object for you from
        the spring container. If you not doing this then you will get NullPointer exception.
        By default Autowire search by type like laptop
        If we want to search by name then add @Qualifier("lap1")
        Now it will search lap1

         */
}
