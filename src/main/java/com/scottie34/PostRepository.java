package com.scottie34;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;


public interface PostRepository extends JpaRepository<Post, Long> {

    Collection<Post> findByAuthor(String author);

    Collection<Post> findByAuthorAndDateBetween(String author, Date from, Date to);
}
