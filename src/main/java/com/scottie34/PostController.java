package com.scottie34;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody Collection<Post> readPosts(@RequestParam("author") Optional<String> author,
                               @RequestParam(value="fromDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
                               @RequestParam(value="toDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {

        if (!author.isPresent() && fromDate == null && toDate == null) {
            return this.postRepository.findAll();
        }
        else {
            return this.postRepository.findByAuthorAndDateBetween(author.get(), fromDate, toDate);
        }


    }

}
