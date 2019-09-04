package com.masudbappy.springboot.repositories;

import com.masudbappy.springboot.domain.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {

}
