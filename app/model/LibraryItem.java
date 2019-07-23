package model;


import org.mongodb.morphia.annotations.Embedded;
@Embedded
public abstract class LibraryItem { //library class


    @Embedded
    private String title;
    @Embedded
    private String sector;

    public LibraryItem( String title, String sector) {

        this.title = title;
        this.sector= sector;
    }

    // these are the class variables








}


