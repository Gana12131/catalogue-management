package com.backend.mastery.catalogue.management.repository;

import com.backend.mastery.catalogue.management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
