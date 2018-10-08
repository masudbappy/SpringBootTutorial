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

        @Controller
        ===========
        @Controller annotation indicates that the annotated class is a controller. It is a specialization of
         @Component and is autodetected through classpath scanning. It is typically used in combination with
         annotated handler methods based on the @RequestMapping annotation. @RestController is a sibling convenience
         annotation for creating Restful controllers.

         Now whenever you get a request, your springboot application will make sure that this contrller will
         handle all the requests and who is doing that? thanks to auto-configuration spring boot will do that for us.
         we have a dispatcher-servlet behind the scene and that dispatcher-servlet send request to the controller.
         But how you mapping. because there might be different requests. like we sent request for home or products or
         contact us. I want different different pages for different different requests. So we need to specify
         something call as ----
        ->-> @RequestMapping
         ===================
         so you can mention for which request i want to handle this.@RequestMapping("home")

         @RestController annotation returns the json from the method not HTML or JSP. It is the combination of
          @Controller and @ResponseBody in one. The main purpose of @RestController is to create RESTful web services.
           For returning html or jsp, simply annotated the controller class with @Controller.

         @ResponseBody
         =============
         @ResponseBody is a Spring annotation which binds a method return value to the web response body. It is not
          interpreted as a view name. It uses HTTP Message converters to convert the return value to HTTP response body,
           based on the content-type in the request HTTP header
           This response body says hey whatever you are returning is actually the data it's not the page name but data.
           But i don't want to print a data right now i want page but unfortunately spring boot
           does not support jsp so you need to add tomcat-jasper dependency.

           To returning html page by default to your project you need to add spring-boot-starter-thymeleaf dependency.




         */
}
