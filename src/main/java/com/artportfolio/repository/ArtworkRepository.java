package com.artportfolio.repository;

import com.artportfolio.model.Artwork;
import com.artportfolio.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
    Page<Artwork> findByArtist(User artist, Pageable pageable);
    
    @Query("SELECT a FROM Artwork a WHERE a.isNsfw = false ORDER BY a.uploadDate DESC")
    Page<Artwork> findRecentArtworks(Pageable pageable);
    
    @Query("SELECT a FROM Artwork a WHERE :tag MEMBER OF a.tags")
    Page<Artwork> findByTag(String tag, Pageable pageable);
    
    @Query("SELECT a FROM Artwork a WHERE a.title LIKE %:query% OR :query MEMBER OF a.tags")
    Page<Artwork> search(String query, Pageable pageable);
    
    List<Artwork> findTop10ByOrderByViewsDesc();
} 