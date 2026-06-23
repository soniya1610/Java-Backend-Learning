// Entity Class - a java class which is represents a table in the database
// imp annotations - @Entity - marks the class as an entity
// @Table - maps the class to a table in the database
// @Id - marks the field as the primary key
// @Column - maps the field to a column in the database
// @GeneratedValue - specifies the strategy for generating the primary key
package com.soniya.HbApp;

import jakarta.persistence.*;

@Entity
@Table(name = "my_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String name;

    private int price;

    @Column(name = "a_name", nullable = false)
    private String author;

    @Transient
    private int pages;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}