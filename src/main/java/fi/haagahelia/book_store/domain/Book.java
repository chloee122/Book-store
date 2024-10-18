package fi.haagahelia.book_store.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;

    public Book() {}

    public Book(String title, String author, int publicationYear, String isbn, Category category) {
        super();
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.category = category;
    }

    public void setBookId(Long id) {
        this.bookId = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
   
    public String getIsbn() {
        return isbn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", publicationYear="
                + publicationYear + ", isbn=" + isbn + ", category=" + category.getName() + "]";
    }  
   
}