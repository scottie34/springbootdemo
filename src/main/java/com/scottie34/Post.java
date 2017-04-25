package com.scottie34;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    public String content;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date date;

    public String author;

    public Post() {
    }

    public Post(String content, String author, Date date) {
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
