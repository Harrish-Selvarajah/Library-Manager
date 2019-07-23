package model;

import org.mongodb.morphia.annotations.Entity;

@Entity
public class Book extends LibraryItem{

    private String isbn;
    private Author author;
    private Publisher publisher;
    private String noofpages;
    private String publidate;



    public Book( String isbn,String title, String sector,String publidate,Author author, Publisher publisher, String noofpages) {
        super(title,sector);
        this.isbn=isbn;
        this.publidate=publidate;
        this.author = author;
        this.publisher = publisher;
        this.noofpages = noofpages;

    }


}

