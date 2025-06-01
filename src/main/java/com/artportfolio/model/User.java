package com.artportfolio.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String displayName;
    
    @Column(columnDefinition = "TEXT")
    private String bio;

    private String profileImage;
    
    @Column(nullable = false)
    private boolean isArtist;

    private String twitterHandle;
    private String instagramHandle;
    private String artstationHandle;

    @Column(nullable = false)
    private double averageRating;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Artwork> artworks = new ArrayList<>();

    @Embedded
    private SocialMediaLinks socialMediaLinks;

    private String commissionStatus;
    
    @Column(columnDefinition = "TEXT")
    private String commissionInfo;
} 