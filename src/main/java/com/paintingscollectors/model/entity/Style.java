package com.paintingscollectors.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // You can use UUID here as well
    private Long id;

    @Enumerated(EnumType.STRING) // Store the style name as a string
    @Column(unique = true, nullable = false)
    private StyleEnum styleEnum;

    @Column(nullable = false)
    private String description; // Automatically populated based on StyleName

    @OneToMany(mappedBy = "style")
    private Set<Painting> paintings;

    public Style(StyleEnum style, String description) {
        this.styleEnum = style;
        this.description = description;
    }

    public Style() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StyleEnum getStyleEnum() {
        return styleEnum;
    }

    public void setStyleEnum(StyleEnum styleEnum) {
        this.styleEnum = styleEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Painting> getPaintings() {
        return paintings;
    }

    public void setPaintings(Set<Painting> paintings) {
        this.paintings = paintings;
    }
}