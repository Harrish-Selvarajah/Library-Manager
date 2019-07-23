package model;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;
import java.util.ArrayList;


public class WestminsterLibraryManger implements  LibraryManager {

    final static MongoClient client = new MongoClient();
    final static Morphia morphia = new Morphia();
    final static Datastore bookDb = morphia.createDatastore(client, "YourDB");
    // bookDb is the reference of my database
    final static Datastore dvddb = morphia.createDatastore(client, "YourDB");

    MongoDatabase booksdb = client.getDatabase("YourDB");
    //booksdb is the reference of ypurDb database
    MongoDatabase dvdsdb = client.getDatabase("YourDB");
    //booksdb is the reference of ypurDb database


    @Override
    public void adddBook(JsonNode json) {
//        this method intialises the json vlaue which we get from the angual to the variable
//        and we put it into a constructor of the book class and pass into the database
        //System.out.println("isbn" + json.findPath("isbn").textValue());
        String isbn = json.findPath("isbn").asText();
        String title = json.findPath("title").asText();
        String sector = json.findPath("sector").asText();
        String publidate = json.findPath("publidate").asText();
        String author = json.findPath("author").asText();
        String publisher = json.findPath("publisher").asText();
        String noofpages = json.findPath("noofpages").asText();
        Author authour = new Author(author);
        //creation  of the author objects of its class
        Publisher publisheer = new Publisher(publisher);
        //creation of publisher object of its class

        Book book = new Book(isbn, title, sector, publidate, authour, publisheer, noofpages);
        //book class constructor

        bookDb.save(book); //here the book object is saved into the  bookDb which is a reference to the yourDb database
    }

    @Override
    public void adddDvd(JsonNode json) {
        //        this method intialises the json vlaue which we get from the angualR to the variable
//        and we put it into a constructor of the dvd class and pass into the database
//        System.out.println(json.asText());
        String dvdid = json.findPath("dvdid").asText();
        //hee the dvdid is put into the dvdid variable as text
        String title = json.findPath("titled").asText();
        String sector = json.findPath("sector").asText();
        String availang = json.findPath("availang").asText();
        String sub = json.findPath("sub").asText();
        String producer = json.findPath("producer").asText();
        String actors = json.findPath("actors").asText();

        Dvd dvd = new Dvd(dvdid, title, sector, availang, sub, producer, actors);
        //dvd class constructor

        dvddb.save(dvd); ///here the book object is saved into the  dvddb which is a reference to the yourDb database
    }

    public List<Document> retreivebook() {
        // this method is used to retrieve the book obj from mongo and send it to
        //displaycomponenet in angular
        MongoCollection<Document> bookcollec = booksdb.getCollection("Book");
        // here the books are in a colection in the mongodb
        // booksdb is the reference for the yourdb
        //bookcollec is the name of the book collection
        List<Document> booklist = bookcollec.find().into(new ArrayList<>());
        //here we get the books from the mongocollection and put them into an arraylist named booklist

        return booklist;
        // goes to the corresponding home controller method
    }

    public List<Document> retreivedvd() {
        // this method is used to retrieve the dvd obj from mongo and send it to
        //displaycomponenet in angular
        MongoCollection<Document> dvdcollec = dvdsdb.getCollection("Dvd");
        // here the dvds are in a colection in the mongodb
        // dvdsdb is the reference for the yourdb
        //dvdcollec is the name of the dvd collection
        List<Document> dvdlist = dvdcollec.find().into(new ArrayList<>());
        //here we get the dvds from the mongocollection and put them into an arraylist named booklist
        return dvdlist;
        // goes to the corresponding home controller method
    }

    public void deletebook(String isbn) {
//    this method is used to retrieve the dvd obj from mongo and delete the book in the
//   displaycomponenet in angular
        MongoCollection<Document> bookcollec = booksdb.getCollection("Book");
        Document delete = new Document("$eq", isbn);
        Document find = new Document("isbn", delete);
        bookcollec.deleteOne(find);
    }

    public void deletedvd(int dvdid) {
// this method is used to retrieve the dvd obj from mongo and delete the book in the
//   displaycomponenet in angular
        MongoCollection<Document> dvdcollec = dvdsdb.getCollection("Dvd");
        Document delete = new Document("$eq", dvdid);
        Document find = new Document("dvdid", delete);
        dvdcollec.deleteOne(find);
    }

}
