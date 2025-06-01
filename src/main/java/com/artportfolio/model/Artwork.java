package com.artportfolio.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "artworks")
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private User artist;

    @ElementCollection
    private Set<String> tags = new HashSet<>();

    private LocalDateTime uploadDate;

    private int views;

    private int likes;

    @Column(name = "image_width")
    private int width;

    @Column(name = "image_height")
    private int height;

    @Column(name = "file_size")
    private long fileSize;

    private String category;

    private boolean isNsfw;

    private String license;

    @PrePersist
    protected void onCreate() {
        uploadDate = LocalDateTime.now();
    }
} 