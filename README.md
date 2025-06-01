# Digital Art Portfolio Platform

A modern web application for artists to showcase their artwork and connect with potential clients through social media, similar to Danbooru. Built with Java Spring Boot and following Object-Oriented Programming principles.

## Features

- User registration and authentication
- Artist profiles with customizable portfolios
- Artwork upload and management
- Tag-based categorization
- Search functionality
- Integrated social media links (Twitter, Instagram, ArtStation)
- SEO-optimized for better visibility
- Responsive design for all devices

## Prerequisites

- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher

## Setup Instructions

1. Clone the repository:
```bash
git clone https://github.com/yourusername/digital-art-portfolio.git
cd digital-art-portfolio
```

2. Configure MySQL:
- Create a MySQL database named `art_portfolio`
- Update `src/main/resources/application.properties` with your database credentials

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## Project Structure

```
src/main/java/com/artportfolio/
├── model/          # Domain models
├── repository/     # Data access layer
├── service/        # Business logic
├── controller/     # REST endpoints
├── config/         # Configuration classes
└── security/       # Security configuration
```

## SEO Optimization

The platform is optimized for search engines with:
- Semantic HTML structure
- Meta tags and descriptions
- SEO-friendly URLs
- Sitemap generation
- Robot.txt configuration

## Security

- JWT-based authentication
- Password encryption
- CSRF protection
- XSS prevention
- Input validation

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed by me dont use it, only for project purposes >:(
