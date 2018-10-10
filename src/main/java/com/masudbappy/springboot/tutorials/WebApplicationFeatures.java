package com.masudbappy.springboot.tutorials;

public class WebApplicationFeatures {
    /*
    What is needed to build web application?
    =======================================
    Just add
    <dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>

	Question No 1??
	===============
	When you create a application you don't keep all your files in webapp folder. webapp
	is a folder that is public what if you want to make it private? what if you want to
	put your pages in some other folder?
	Second thing is normally when you work on spring framework or spring MVC, you don't
	normally mention the jsp pages is because in future you might want to change velocity you
	might want to change thymeleaf. Offcourse you don't want to put a .jsp at the end.
    so we're able to search the page which is .jsp. As we know we have a concept of
    Auto configuration inside springboot which is doing this stuff for you. so the default
    folder is webapp and the extension is whatever you mention here. but if we want to configure
    this what we have to do is we have to mention at the application.properties file.
    In application properties---->
    the path of a page is defined with the help of prefix and the extension of a page is defined
    with the help of suffix.
    spring.mvc.view.prefix=/pages/
    spring.mvc.view.suffix=.jsp

     */
}
