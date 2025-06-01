package com.artportfolio.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SocialMediaLinks {
    private String twitter;
    private String instagram;
    private String artstation;
    
    // Helper method to get formatted social media URLs
    public String getTwitterUrl() {
        return twitter != null ? "https://twitter.com/" + twitter.replace("@", "") : null;
    }
    
    public String getInstagramUrl() {
        return instagram != null ? "https://instagram.com/" + instagram : null;
    }
    
    public String getArtstationUrl() {
        return artstation != null ? "https://artstation.com/" + artstation : null;
    }
} 