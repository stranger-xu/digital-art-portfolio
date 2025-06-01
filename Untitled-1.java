
// Pinterest-like Social Media Platform using OOP principles

// User Class
class User {
    private String username;
    private String email;
    private List<Board> boards;
    private List<Pin> savedPins;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.boards = new ArrayList<>();
        this.savedPins = new ArrayList<>();
    }

    public void createBoard(String boardName) {
        Board newBoard = new Board(boardName, this);
        boards.add(newBoard);
    }

    public void savePin(Pin pin) {
        savedPins.add(pin);
    }
}

// Board Class
class Board {
    private String name;
    private User owner;
    private List<Pin> pins;
    private boolean isPrivate;

    public Board(String name, User owner) {
        this.name = name;
        this.owner = owner;
        this.pins = new ArrayList<>();
        this.isPrivate = false;
    }

    public void addPin(Pin pin) {
        pins.add(pin);
    }

    public void setPrivacy(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
}

// Pin Class
class Pin {
    private String title;
    private String imageUrl;
    private String description;
    private User creator;
    private List<Comment> comments;
    private int likes;

    public Pin(String title, String imageUrl, User creator) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.creator = creator;
        this.comments = new ArrayList<>();
        this.likes = 0;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void like() {
        likes++;
    }
}

// Comment Class
class Comment {
    private User user;
    private String content;
    private LocalDateTime timestamp;

    public Comment(User user, String content) {
        this.user = user;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}

// Main Pinterest System
class PinterestSystem {
    private List<User> users;
    private List<Pin> allPins;

    public PinterestSystem() {
        this.users = new ArrayList<>();
        this.allPins = new ArrayList<>();
    }

    public void registerUser(String username, String email) {
        User newUser = new User(username, email);
        users.add(newUser);
    }

    public Pin createPin(String title, String imageUrl, User creator) {
        Pin newPin = new Pin(title, imageUrl, creator);
        allPins.add(newPin);
        return newPin;
    }

    public List<Pin> searchPins(String keyword) {
        return allPins.stream()
                .filter(pin -> pin.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}

// Example Usage
public class PinterestDemo {
    public static void main(String[] args) {
        PinterestSystem pinterest = new PinterestSystem();
        
        // Register users
        pinterest.registerUser("john_doe", "john@example.com");
        pinterest.registerUser("jane_smith", "jane@example.com");
        
        // Create and manage content
        User john = pinterest.getUsers().get(0);
        john.createBoard("Travel Photos");
        
        Pin travelPin = pinterest.createPin("Paris Evening", "paris.jpg", john);
        john.getBoards().get(0).addPin(travelPin);
        
        // Interact with content
        travelPin.like();
        travelPin.addComment(new Comment(john, "Beautiful sunset!"));
    }
}
