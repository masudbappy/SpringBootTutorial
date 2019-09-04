package com.masudbappy.springboot.domain;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Book> books;

    public BookCategory() {
    }

    public BookCategory(int id, String name, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public BookCategory(String name, Book... books) {
        this.name = name;
        this.books = Stream.of(books).collect(Collectors.toSet());
        this.books.forEach(x -> x.setBookCategory(this));
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
