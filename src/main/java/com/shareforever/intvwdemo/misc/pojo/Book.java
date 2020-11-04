package com.shareforever.intvwdemo.misc.pojo;

public class Book {
    Integer id;
    String title, subtitle, author, publisher, quantity;
    Boolean isPublished;

    public Integer takeId(Integer id) {
        this.id += id;
        return id;
    }

    public void takeme(Book book) {

    }

    public Book(Integer id, String title, String subtitle, String author, String publisher, String quantity, Boolean isPublished) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.isPublished = isPublished;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }
}
