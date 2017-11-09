package com.sda.springjavapoz4.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String smallImgPath;
    private String largeImgPath;
    @ManyToOne
    private User author;

    public News(Long id, String title, String description, LocalDate date, String smallImgPath, String slargeImgPath, User author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.smallImgPath = smallImgPath;
        this.largeImgPath = slargeImgPath;
        this.author = author;
    }

    public News() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSmallImgPath() {
        return smallImgPath;
    }

    public void setSmallImgPath(String smallImgPath) {
        this.smallImgPath = smallImgPath;
    }

    public String getLargeImgPath() {
        return largeImgPath;
    }

    public void setLargeImgPath(String largeImgPath) {
        this.largeImgPath = largeImgPath;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAbbreviateDescription() {
        return StringUtils.abbreviate(description, 30);
    }
}
