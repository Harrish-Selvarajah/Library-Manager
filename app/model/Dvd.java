package model;


import org.mongodb.morphia.annotations.Entity;

@Entity
public class Dvd extends LibraryItem  {

    private String dvdid;
    private String available_languages;
    private String available_subtitles;
    private String producer;
    private String actors;


    public Dvd(String dvdid, String Title, String sector, String available_languages, String available_subtitles, String producer, String actors) {
        super( Title, sector); //constructor

        this.dvdid=dvdid;
        this.available_languages = available_languages;
        this.available_subtitles = available_subtitles;
        this.producer=producer;
        this.actors = actors;
    }



}
