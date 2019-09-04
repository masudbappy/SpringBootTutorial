package com.masudbappy.springboot.config;

import com.masudbappy.springboot.domain.Book;
import com.masudbappy.springboot.domain.BookCategory;
import com.masudbappy.springboot.repositories.BookCategoryRepository;
import com.masudbappy.springboot.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private BookRepository bookRepository;
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    public BookController(BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @PostMapping(value = "/createCategory")
    public ResponseEntity createCategory(@RequestBody BookCategory bookCategory) {
        bookCategory = this.bookCategoryRepository.save(bookCategory);
        return ResponseEntity.ok(bookCategory);
    }
    @PostMapping(value = "/createBook")
    public ResponseEntity createBook(@RequestBody Book book) {
        book = this.bookRepository.save(book);
        return ResponseEntity.ok(book);
    }
    /*@PostMapping(value = "/createBook")
    public ResponseEntity createBook(@RequestBody List<Book> bookList) {
        bookList = this.bookRepository.saveAll(bookList);
        return ResponseEntity.ok(bookList);
    }*/
    /*@GetMapping(value = "/getBooks")
    public ResponseEntity getBooks(){
        return ResponseEntity.ok(bookRepository.findAll());
    }
*/

}
