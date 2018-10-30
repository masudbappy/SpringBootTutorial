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

    Repository Architectural Overview
    =================================
    Repositories fit into the data access layer but they aren't the only objects and concepts that you have to keep in
    mind when working on a server side. Let's look at a typical Spring application from an architectural point of view
    to see how everything might fit together. Let's start with the database and work up from there. Your database
    typically consists of one or more tables. They may or may not be related such as a parent or child relationship.
    These structures all live in the database which is typically a standalone server separate from your application
    code and server. As we move into our data access layer, we are using JPA so we have JPA entities mapped to database
    tables. The entities map one to one with a JPA repository. By keeping the repository focused on a single entity,
    it keeps the DAO pattern limited to that specific data and data structure. With standard Spring repositories, you
    don't have to follow this standard. You can technically have the repository access anything and everything on the
    data side. But with Spring data JPA repositories, the repository is limited to a single JPA entity. Spring services
    can then be used to perform logical bundles of work for the application. A service may need data from a couple of
    repositories or a single repository, or the service may not even need to use the data access layer. The Spring at
    service annotation is another Spring stereotype and you would use it on classes and interfaces that live in your
    service layer. And last, your application will typically have some kind of controller layer that handles request
    routing coming in from a UI. These controllers can utilize one or more services and are responsible for returning a
    response to the UI or presentation tier. This can be done with a template render on the server side or something
    more service-oriented by returning a JSON payload to the caller via a URL endpoint or res-like service. The
    important thing to remember is that your code dependencies and bindings should only move to the right in this
    diagram. So controllers can inject services or repositories and services can inject repositories, but services and
    repositories should never inject controllers. This prevents cyclical code dependency issues. Keep in mind though
    that you're free to create a dependency within your layer. Meaning that your services can inject other services and
    repositories can inject other repositories.

    Spring Data JPA Repositories
    =============================
    Hopefully by now, you're starting to see that standard Spring repositories and Spring Data JPA repositories differ
    slightly in concept and structure. Here are the slight differences. First, all JPA repositories are Java interfaces
    instead of classes. There is one exception to this that I'll discuss in module four and that's in regards to
    customizing and implementing custom JPA repositories. But for now, just think of them as always being an interface.
    These interfaces are associated to a JPA entity as you saw on the previous slide. Each JPA repository can only
    perform data access operations for that particular entity and its data attributes. This helps focus the JPA
    repository on the DAO contract for that entity and its backing data. How do JPA repositories tie to a particular
    JPA entity? This is accomplished by using Java generics and typing. By supplying the JPA entity and its primary key
    data type, the JPA repository now knows exactly what database table in columns it can work with because all that
    information is bundled nicely inside your JPA entity. Again, if you're confused to what a JPA entity represents,
    make sure to spend some time viewing the JPA courses in the Pluralsight library to wrap your head around that
    concept. The last big difference between Spring Data JPA repositories and standard Spring repositories is how the
    implementation happens to fulfill the DAO pattern. If you remember from a couple slides ago, the DAO pattern allows
    you to implement the DAO contract however you want, and that implementation is up to you. With Spring Data JPA
    repositories, we no longer care about the implementation details since the framework is going to provide that for
    us. This let's us as the developer focus on the DAO contract while fulfilling the Spring Data JPA's goal of
    simplifying our data access layer without any loss of functionality. The big takeaway that you need to remember is
    that when your application starts up, Spring Data JPA recognizes your JPA repository and automatically generates an
    implementation for the DAO contract that's specified in that interface.

    JpaRepository Features
    ========================
    The repository that we replaced with a Spring Data JPA repository only contained CRUD operations in it. However,
    when you extend the JPA repository interface, you get access to a bunch of other features as well. The functionality
    that comes with the JPA repository include the CRUD operations that you've just seen with our last coding exercise,
    and it also contains Query DSL functionality which we will go in depth with in the next module of this course.
    There's also paging and sorting capabilities, and last, the JPA repository contains a few helpers that can make
    working with your data access layer much easier. Some of these include finding the count of your backing DB table,
    testing whether a record exists in the database, flushing your persistence context changes to the database, and
    handling deletes with a single query using the handy deleteInBatch method. If you take a look at the interface
    hierarchy of the JPA repository, you'll see that there are three more parent interfaces that the JPA repository
    extends from. These repositories have been sectioned out into specific roles in regard to functionality. You'll see
    that when combined into one hierarchical structure, all of the functionality that we've talked about for the JPA
    repository begins to make sense. The nice thing about breaking functionality out into separate interfaces is that it
    gives you the opportunity to reduce functionality in your data access layer if needed. Maybe you only want to have
    CRUD operations available on your repository so in that case, you can simply extend CRUD repository instead of JPA
    repository. One final thing to note about the JPA repository hierarchy is that the JPA repository interface is the
    only interface in the Spring Data JPA project. The other three interfaces actually come from the core Spring data
    project. This means that if you need to utilize one of the Spring Data JPA sibling projects such as Spring Data
    MongoDB, you're going to get similar functionality with that framework as you are with the Spring Data JPA framework.

    Tip: Customize JpaRepository Hierarchy
    ======================================
    When you're working with your data access layer, you should always be thinking about the big picture of your entire
    system. This includes not repeating yourself and setting up convenience helpers and methods across the board where
    it makes sense. For example, most enterprise databases have some kind of auditing columns on every table. When
    setting up the JPA entities for all of your data models, you can create a super class that has your auditing
    attributes on them. This is good use of inheritance and keeps your sub classes from always having to define and
    set up these attributes. From the JPA entity side of things, we're not repeating ourselves and we're enforcing
    auditing standards on all of our entities by providing a super class that all our entities will eventually extend
    from. On our repository layer, we maybe asked to provide auditing access methods and operations that ultimately
    apply to all of our entities. We could add DAO contracts on all of our JPA repositories and let Spring Data JPA
    implement them for us. If for some reason the auditing attributes change or we need to modify the auditing access
    methods, then we could also need to do that on all of our JPA repositories. This kind of breaks our don't repeat our
    self rule. Instead, we could provide a custom repository in the Spring Data JPA repository hierarchy that defines
    these common access methods and functionality. Then any of our other JPA repositories can extend from our custom
    repository and again those common auditing features automatically. This now sets up a repository layer to match what
    we have done in our JPA entity side, and prevents repeating ourselves on the repository side.

    Tip: Refactoring Existing Repositories
    ======================================
    If you're lucky enough to be starting a project from scratch, then you can begin with JPA repositories from the
    start and build out your data access layer from there. Many times, you'll be faced with a situation where you'll
    have to convert existing repositories that have already been built out into JPA repositories. So far, this has been
    the case with our sample project. Here's some tips to help with this particular situation. First, make sure that you
    have sufficient test build against your data access layer. This is a common refactoring practice that make sure that
    as you rework code, you don't break anything or introduce new bugs. If you don't have any tests or your tests aren't
    adequate, make sure to spend some time and add them before getting started. Next, you should create a new interface
    that extends JPA repository and give a new or more descriptive name. If you're refactoring MyRepository, create a
    new interface called something like MyJpaRepository. You typically don't want to keep the same repository name going
    forward because your existing DAO contract method names won't match up 100% with the Spring Data JPA methods and
    Query DSL method naming conventions. We saw this first hand in our last coding exercise. Creating a new repository
    name also allows you to refactor pieces of the repository one method at a time while you support both the old and
    new repositories simultaneously in your application. You can then do one of two things. You can switch out your
    client code dependencies with the new JPA repository contract. So far in this course, this is the route that we've
    done as we've refactored two of our existing repositories. If you only have one or two client bindings to your data
    access layer, this may not be too much effort. However, if you have a lot of client bindings to your data access
    layer, you'll then create a lot of refactoring work that's going to be needed on your client code. Instead, you can
    leave your existing repository in place and turn it into a proxy to the new JPA repository you're replacing it with.
    This allows you to keep your client code completely unchanged while gaining all of the flexibility and power of the
    Spring Data JPA framework. Let's go ahead and refactor the last two repositories in our project using the proxy
    strategy so you can see how that will look and work.

    Query DSL
    ==========
    Of all the features Spring Data JPA provides, the Query DSL feature in the JP repository is one of the most powerful,
    flexible, and pertinent to your application's data access query and read needs. Because the Query DSL is extremely
    customizable and is based off of your JPA entity, it can also be one of the harder aspects of Spring Data JPA to
    pick up and become efficient with. By the end of this module though, you'll have had plenty of practice with the
    various query keywords and concepts that you'll be able to work with the Spring Data JPA queries to handle a variety
    of your query needs going forward.

    Advantages of Using a Query DSL
    ================================
    To kick things off, let's talk about some of the advantages that using a Query DSL will give you over writing custom
    queries and finders. First, think about all of the effort that you've spent mapping JPA entities to your database
    tables. If you have a large database schema, setting up your JPA entities can take some work. Your entity layer
    contains loads of information about the database tables that it maps to. For example, JPA knows the table name, the
    columns, and the columns' data types all by looking at your entity annotations, attributes, and attribute data types.
    If you've gone the extra mile with your entity mapping, you can specify constraints in relationships which give you
    even more knowledge about your database from the software level. Why throw all this knowledge away to have to
    implement queries and finders manually? Let a framework like Spring Data JPA use this info so you can just define
    the query contract and let the framework provide the implementation. Because we aren't adding implementation code,
    that frees us as application developers from having to maintain that code. Think of this kind of like your garage.
    Over time, it collects tools and other various items and after awhile you'll find yourself cleaning, decluttering,
    and organizing your garage on a Saturday. So, from an application development standpoint, don't waste your precious
    Saturday time cleaning out your garage. Let Spring Data JPA deal with your implementation mess while you go fishing
    or do something else. Another time-saving advantage of using the Spring Data JPA Query DSL is that the framework
    checks the validity of your queries when your application starts up, rather than at run-time. This saves time from
    having to actually find and test the point in your application that the query has called. Application start-up
    checks also safeguard against refactoring changes. If an entity attribute changes, you'll quickly know if that
    broke any of your queries when you start up your application. Last, Query DSLs have been in use in scripted language
    platforms for a long time now. Ruby on Rails' active record framework, or Django's ORM stack are both good examples
    of this. Java has been slow to adopt this methodology because of its compiled and type-check nature. It's easy to
    add functionality on the fly in a scripted language because the clients that use it aren't type-checked or compiled.
    This gives scripted languages a lot of flexibility in this particular area. Spring Data JPA has found a pretty good
    balance by requiring the developer to define the data contract, and then the framework can implement that contract
    much like Rails or Django would. Client code can then bind and compile against that interface contract. And before
    going any further, let's make sure we're clear on what a DSL is. DSL is an acronym for domain specific language.
    This is a term used to classify an extension of a programming language to address a domain. In Spring Data JPA's
    case, this means that the framework is enhancing Java to be better suited at creating and working with JPA queries.
    We use domain specific language in speech all the time. Doctors have terms and words that help them work more
    efficiently, and the same for lawyers or construction workers, or any industry. The Spring Data JPA Query DSL is
    simply all about defining terms and syntax to work with JPA queries more efficiently. So I spent the last few
    minutes talking up how great the Query DSL is, so let's go ahead and get to work with some actual coding so you can
    see for yourself how powerful it can be.


*/

}
