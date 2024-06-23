package com.paintingscollectors.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "paintings")
public class Painting {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 30)
    private String author;

    @ManyToOne(optional = false) // A painting has one style
    @JoinColumn(name = "style_id")
    private Style style;

    @ManyToOne(optional = false) // A painting has one owner (user)
    @JoinColumn(name = "owner_id")
    private User user;

    @Column(nullable = false, length = 150)
    private String imageUrl;

    @Column(nullable = false)
    private boolean isFavorite = false;  // Defaults to false

    @Column(nullable = false)
    private int votes = 0;  // Defaults to 0
}