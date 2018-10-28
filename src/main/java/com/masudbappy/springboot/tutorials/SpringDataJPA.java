package com.masudbappy.springboot.tutorials;

public class SpringDataJPA {
   /* What Is Spring Data JPA?
   ===========================
    Now that you've gotten a taste of what Spring Data JPA can do, let's talk about what it is and some of the features
    we're going to cover in this course. First off, this framework builds upon the popular and powerful Spring
    framework, and is considered one of the core projects in Spring's suite of tools. Spring Data JPA also builds upon
    and enhances JPA, which stands for Java Persistence API. I'll discuss these two technologies more in the upcoming
    slide, and what I won't be covering in this course. Most applications are backed with some kind of data store. As
    your application complexity and feature set grows, you'll find that your Data Access Layer and persistence tier
    code will also grow. One of the core objectives of Spring Data JPA is to reduce your code and simplify your Data
    Access Layer, while still maintaining a rich and full-featured set of functionality. To make this possible, Spring
    DATA JPA allows you to build intelligent Spring Repository stereotyped interfaces. These Repositories are Java
    interfaces that allow you as the developer to define a data access contract. The Spring Data JPA framework can then
    inspect that contract, and automatically build the interface implementation under the covers for you. As you saw in
    the previous slide, this allows for a dramatic cutback in actual development code needed for your Data Access Layer.
    We'll be discussing Repositories in depth in module two of this course. For Spring Data JPA to intelligently
    generate an implementation of your Repository interface, a Query DSL is needed. DSL is an acronym for Domain
    Specific Language. The Query Domain Specific Language allows you to create Java interface methods that utilize
    certain keywords along with JPA entity attributes to perform the work needed to correctly implement your queries
    without having to provide much in the way of actual coding. We will cover just about all you need to know about
    Query DSL specifics in module three of this course. And last, Spring Data JPA provides some nice extras that are
    often seen and used in Data Access Layers in persistent tiers. Features such as Auditing, paging and handling of
    native SQL queries can be utilized with Spring Data JPA framework. Module four of this course will discuss these
    advanced features of the framework. If, for some reason, Spring Data JPA can't provide a solution for one of your
    Data Access Layer needs, it can easily get out of the way and let you code or work side-by-side, or outside of the
    framework entirely, without stepping on your toes.


    Tip: Choosing a Java Data Access Layer
    =======================================
    Whenever you are building or working on a Data Access Layer or persistence tier, you have a variety of options you
    can use. I want to take a minute to talk about these options to help you see where Spring Data JPA can fit in
    architecturally. You should also realize that no one framework or API typically works for everything. And the best
    Data Access Layers are often a hybrid of frameworks. If you're working with a really simple database with maybe only
    a few tables, or you have a lot of Native SQL needs, then some Data Access Layer frameworks can be overkill. Using
    straight JDBC or Spring JDBC with Native SQL may be your best and simplest option. Sometimes your reporting needs
    dictate a certain Data Access Layer, and JDBC or Native SQL may work best for that. We're not going to cover any of
    these other Data Access Layer frameworks, other than Spring Data JPA in this course, but it never hurts to be aware
    of them, just so you can have them on your radar. If you have an application that needs to perform a lot of SQL
    inserts, updates or deletes, you'll want to get a framework that specializes in that particular functionality. JPA
    is not a great candidate for massive amounts of writes to your data store. The reason why JPA or ORMs in general
    struggle with large writes is that the nature of the framework requires that you would create your object graph in
    memory, then update it with the changed values and then persist it back to your data store. If you're working with
    really large graph trees, this can be quite expensive time-wise, and end up creating large memory footprints on your
    server. Instead, you should probably be looking at a framework that handles batching specifically. A framework like
    Spring Batch or Hadoop. Java EE 7 also contains a Batch writing component as part of its core functionality now. The
    majority of time, you'll find that your data needs fall into a reasonably normalized data structure that fits nicely
    in a relational database. You'll see graph trees with parent-child relationships, one-to-one relationships,
    many-to-many relationships and so on. When you start seeing graph trees, or there is a heart-like object with lots
    of relationships associated with it, just to make a single UI screen, then you can run into issues using an ORM. In
    cases like that, jumping back to something like Spring JDBC may make more sense. Otherwise, utilizing an ORM can
    really buy you a lot of power and flexibility once your entities or models are in place. When you place Spring Data
    JPA on top of this, your data functionality can almost start to work magically with very minimal code when dealing
    with basic data access needs. Sometimes the nature of the data you are working with will steer you to a specific
    Data Access Layer framework. Data that is topical in nature or relationally-threaded can be stored in a standard
    relational database, but queries often get complex and response times slow as data grows. For this, you may want to
    look at NoSQL databases and frameworks. Platforms like MongoDB along with Spring Data MongoDB would be a great
    candidate for data needs that fall in this category. Even though this has been a pretty high flyover architecturally,
    hopefully it gives you a general guideline if you need to choose a Data Layer for your application. There are many
    other points that we didn't cover, such as working with legacy databases, multiple schemas or multiple databases,
    but you may find that combining two or three of these frameworks together to make a hybrid framework really does
    make a lot of sense for your Data Access Layer needs. Make sure to take everything into account when you are
    building your initial architecture and stack for your Java application.

    Spring Data
    ========================
    Spring Data JPA is actually part of the larger Spring Data umbrella project in the Spring ecosystem. Spring Data's goal
    is to make working with a variety of persistence stores easier than if you were to just use them directly. So if you
    decide that you do want to setup a hybrid persistence tier, like we talked about on the previous slide, there's
    probably a Spring Data project that you can use to simplify your overall Data Access Layer. Spring Data provides a
    Commons artifact that defines the general repository contract and functionality that all Spring Data projects must
    adhere and comply with. This includes your basic CRUD operations and query generation. From there, Spring provides
    the following projects that implement the Spring Data Commons API and contract. As of the time of this course
    publication, Spring has nine data access implementations and APIs that it supports. You'll notice that Spring Data
    JPA is one of these, and that the Spring Data project as a whole is quite large and encompassing. There's also four
    more community-based Spring Data projects. These projects have been contributed by the open source community, and
    can still be found on the Spring site, but they aren't part of the main Spring Data project suite at this time.
    Concepts that you learn from Spring Data JPA are going to be similar if you need to work with of these alternate
    Spring Data implementations, since each of these project adhere to the core Spring Data Commons interfaces and contracts.

    Spring Repositories
    ========================
    Spring has supported the concept of a repository for some time now. Repository is one of Spring's core stereotypes
    and you should plan on using them in your data access layer regardless of your chosen data access layer API and
    framework. The repository's whole point is to define a contract that your data access layer will implement. This
    contract or interface can then be included and bound to by client code that needs to access data in some fashion.
    What this really means is that a Spring repository is essentially the Data Access Object pattern or DAO pattern. By
    defining an interface that the surface code uses, the data access layer is free to implement the DAO contract anyway
    that makes the most sense to be successful. That may mean that when you started your project you implemented your
    data access layer with JPA. Maybe at some point later in the project, you needed to replace that implementation with
    the JDBC implementation instead of JPA. When you switch the interface implementation out, the client service code
    didn't even notice or care that anything changed implementation-wise in your data access layer. And who knows, maybe
    at some point in the future, you'll need to switch out your JDBC implementation with something else. This pattern
    allows you to set up hybrid data access layers like we talked about in module one of this course. Your
    implementation may actually do some operations using JPA while utilizing JDBC for other operations. The purest
    definition of a DAO pattern would say that you need to define a contract with an interface. Spring repositories
    however don't necessarily need to be an interface. In our sample project, you may have noticed that we have classes
    with the @Repository annotation on them. In this case, we're still following the DAO pattern to a point because any
    method or attribute that you set up as public scope becomes your DAO contract. You can then still choose your
    implementation details for your public methods, you just need to make sure to keep the scope private or protected.
    Most of the time this is sufficient for most data access layers.


*/

}
