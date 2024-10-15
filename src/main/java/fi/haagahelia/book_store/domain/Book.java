package fi.haagahelia.book_store.domain;

public class Book {
    private String title;
    private String author;
    private Number year;
    private String isbn;
    private Number price;

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(Number year) {
        this.year = year;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPrice(Number price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Number getYear() {
        return year;
    }
    public String getIsbn() {
        return isbn;
    }
    public Number getPrice() {
        return price;
    }
}
