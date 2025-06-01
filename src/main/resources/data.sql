-- Sample Artists
INSERT INTO users (username, password, email, display_name, bio, profile_image, is_artist, twitter_handle, instagram_handle, artstation_handle, average_rating)
VALUES 
    ('sakura_art', '$2a$10$xP3/fDwgkdHKZAz.COzsQOqq/UIRH0SIQpqDHKtjNX.1vxKF3ZZm2', 'sakura@email.com', 'Sakura Arts', 
    'Digital artist specializing in anime and manga style illustrations. Commission status: OPEN', 
    '/images/profiles/sakura.jpg', true, '@sakura_arts', 'sakura.arts', 'sakura_arts', 4.8),

    ('neo_painter', '$2a$10$xP3/fDwgkdHKZAz.COzsQOqq/UIRH0SIQpqDHKtjNX.1vxKF3ZZm2', 'neo@email.com', 'Neo Digital', 
    'Contemporary digital artist focusing on cyberpunk and sci-fi themes', 
    '/images/profiles/neo.jpg', true, '@neo_digital', 'neo.digital.art', 'neo_digital', 4.9),

    ('nature_brush', '$2a$10$xP3/fDwgkdHKZAz.COzsQOqq/UIRH0SIQpqDHKtjNX.1vxKF3ZZm2', 'nature@email.com', 'Nature Brush', 
    'Digital landscape artist inspired by natural wonders and fantasy worlds', 
    '/images/profiles/nature.jpg', true, '@nature_brush', 'nature.brush', 'nature_brush', 4.7);

-- Sample Artworks for Sakura Arts
INSERT INTO artworks (title, description, image_url, artist_id, views, likes, image_width, image_height, file_size, category, is_nsfw, license, upload_date)
VALUES 
    ('Cherry Blossom Spirit', 'Digital illustration of a spirit among cherry blossoms', '/images/artworks/sakura1.jpg', 
    (SELECT id FROM users WHERE username = 'sakura_art'), 1500, 320, 1920, 1080, 2500000, 'Illustration', false, 'CC BY-NC-SA', NOW()),
    
    ('Magical Girl', 'Original magical girl character design', '/images/artworks/sakura2.jpg',
    (SELECT id FROM users WHERE username = 'sakura_art'), 2100, 450, 1920, 1080, 3000000, 'Character Design', false, 'CC BY-NC-SA', NOW());

-- Sample Artworks for Neo Digital
INSERT INTO artworks (title, description, image_url, artist_id, views, likes, image_width, image_height, file_size, category, is_nsfw, license, upload_date)
VALUES 
    ('Neon City', 'Cyberpunk cityscape at night', '/images/artworks/neo1.jpg',
    (SELECT id FROM users WHERE username = 'neo_painter'), 3200, 890, 2560, 1440, 4500000, 'Environment', false, 'CC BY-NC-SA', NOW()),
    
    ('Cyber Samurai', 'Futuristic samurai character concept', '/images/artworks/neo2.jpg',
    (SELECT id FROM users WHERE username = 'neo_painter'), 2800, 760, 1920, 1080, 3200000, 'Character Design', false, 'CC BY-NC-SA', NOW());

-- Sample Artworks for Nature Brush
INSERT INTO artworks (title, description, image_url, artist_id, views, likes, image_width, image_height, file_size, category, is_nsfw, license, upload_date)
VALUES 
    ('Mystic Forest', 'Fantasy forest landscape with glowing elements', '/images/artworks/nature1.jpg',
    (SELECT id FROM users WHERE username = 'nature_brush'), 2400, 520, 2560, 1440, 4000000, 'Landscape', false, 'CC BY-NC-SA', NOW()),
    
    ('Crystal Falls', 'Magical waterfall with crystal formations', '/images/artworks/nature2.jpg',
    (SELECT id FROM users WHERE username = 'nature_brush'), 1900, 410, 1920, 1080, 2800000, 'Landscape', false, 'CC BY-NC-SA', NOW());

-- Insert tags for artworks
INSERT INTO artwork_tags (artwork_id, tags)
SELECT id, 'anime' FROM artworks WHERE title = 'Cherry Blossom Spirit'
UNION ALL
SELECT id, 'digital art' FROM artworks WHERE title = 'Cherry Blossom Spirit'
UNION ALL
SELECT id, 'character design' FROM artworks WHERE title = 'Magical Girl'
UNION ALL
SELECT id, 'cyberpunk' FROM artworks WHERE title = 'Neon City'
UNION ALL
SELECT id, 'cityscape' FROM artworks WHERE title = 'Neon City'
UNION ALL
SELECT id, 'samurai' FROM artworks WHERE title = 'Cyber Samurai'
UNION ALL
SELECT id, 'landscape' FROM artworks WHERE title = 'Mystic Forest'
UNION ALL
SELECT id, 'fantasy' FROM artworks WHERE title = 'Mystic Forest'
UNION ALL
SELECT id, 'nature' FROM artworks WHERE title = 'Crystal Falls'; 