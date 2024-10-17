package fi.haagahelia.book_store.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

    public Book() {}

    public Book(String title, String author, int publicationYear, String isbn) {
        super();
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
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

    @Override
    public String toString() {
        return "Book [id=" + bookId + ", title=" + title + ", author=" + author + ", year=" + publicationYear + ", isbn=" + isbn
                + "]";
    }  
}