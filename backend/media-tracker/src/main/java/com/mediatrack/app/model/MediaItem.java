package com.mediatrack.app.model;

import jakarta.persistence.*;

@Entity
public class MediaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String mediaType; // "movie", "book", "show", "game"
    private String status;    // "wishlist", "in_progress", etc.

    private Integer currentProgress; // nullable
    private Integer totalProgress;   // nullable

    private Integer rating; // 1–10
    private Boolean liked;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public MediaItem() {
    }

    public MediaItem(String title, String mediaType, String status, Integer currentProgress,
                     Integer totalProgress, Integer rating, Boolean liked, User user) {
        this.title = title;
        this.mediaType = mediaType;
        this.status = status;
        this.currentProgress = currentProgress;
        this.totalProgress = totalProgress;
        this.rating = rating;
        this.liked = liked;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(Integer currentProgress) {
        this.currentProgress = currentProgress;
    }

    public Integer getTotalProgress() {
        return totalProgress;
    }

    public void setTotalProgress(Integer totalProgress) {
        this.totalProgress = totalProgress;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
