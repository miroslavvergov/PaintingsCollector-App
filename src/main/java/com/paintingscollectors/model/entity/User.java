package com.paintingscollectors.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 20) // Adjust length as needed
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Painting> paintings;

    @ManyToMany
    @JoinTable(
            name = "favorite_paintings",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "painting_id")
    )
    private Set<Painting> favoritePaintings;

    @ManyToMany
    @JoinTable(
            name = "rated_paintings",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "painting_id")
    )
    private Set<Painting> ratedPaintings;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Painting> getPaintings() {
        return paintings;
    }

    public void setPaintings(Set<Painting> paintings) {
        this.paintings = paintings;
    }

    public Set<Painting> getFavoritePaintings() {
        return favoritePaintings;
    }

    public void setFavoritePaintings(Set<Painting> favoritePaintings) {
        this.favoritePaintings = favoritePaintings;
    }

    public Set<Painting> getRatedPaintings() {
        return ratedPaintings;
    }

    public void setRatedPaintings(Set<Painting> ratedPaintings) {
        this.ratedPaintings = ratedPaintings;
    }
}
