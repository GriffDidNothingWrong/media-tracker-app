package com.mediatrack.app.model;

import jakarta.persistence.*;

@Entity
public class GlobalMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String type; // e.g., movie, book, show

    public GlobalMedia() {}

    public GlobalMedia(String title, String type) {
        this.title = title;
        this.type = type;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
