package com.fsd.spring.repository;

import com.fsd.spring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query("select b from Book b where lower(title) like %:bookTitle%")
    List<Book> findByTitleContaining(@Param("bookTitle") String bookTitle);

    @Modifying
    @Query("delete from Book where lower(title) like %:bookTitle%")
    int deleteBooksByTitleContaining(@Param("bookTitle") String bookTitle);

}
