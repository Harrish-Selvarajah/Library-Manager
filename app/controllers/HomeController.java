package controllers;

        import com.fasterxml.jackson.databind.JsonNode;
        import com.mongodb.MongoClient;
        import model.LibraryManager;
        import model.WestminsterLibraryManger;
        import org.mongodb.morphia.Datastore;
        import org.mongodb.morphia.Morphia;
        import play.libs.Json;
        import play.mvc.*;

        import static tyrex.util.Configuration.console;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        MongoClient client= new MongoClient();
        Morphia morphia= new Morphia();
        Datastore db=morphia.createDatastore(client,"YourDB");


        User user= new User("Ashan","Azhali","we@gmail.com");
        db.save(user);

        return ok("Success");
    }

    public Result Pbook(){
        LibraryManager libMan= new WestminsterLibraryManger();
        //libman is the object of the westminusterlibrarymaager class
        //System.out.println(request().body().asJson());

        libMan.adddBook(request().body().asJson());
        //here the return value of addBook method taken

        String pp="post book works";
        return ok(Json.toJson(pp));
    }

    public Result Pdvd(){
        LibraryManager libMan= new WestminsterLibraryManger();
        //libman is the object of the westminusterlibrarymaager class
        //System.out.println(request().body().asJson());
        System.out.println(request().body().asJson());

        libMan.adddDvd(request().body().asJson());
        //here the return value of addBook method taken

        String dp="post dvd works";
        return ok(Json.toJson(dp));

    }

    public Result Gbook(){

        LibraryManager vbook = new WestminsterLibraryManger();
        //vbook is the object of the westminusterlibrarymaager class
        JsonNode a=Json.toJson(vbook.retreivebook());
        System.out.println(a);

        return ok(a);
//        the book item is returnes to the post link in angular
    }

    public Result Gdvd(){
        LibraryManager vbook = new WestminsterLibraryManger();
        JsonNode b=Json.toJson(vbook.retreivedvd());
        System.out.println(b);
        return ok(b);
    }

    public Result Dbook(String isbn){
        LibraryManager vbook = new WestminsterLibraryManger();
        int c= Integer.parseInt(isbn);
        ((WestminsterLibraryManger) vbook).deletebook(isbn);
        return ok("Book has been Deleted");
    }

    public Result Ddvd(String dvdid){
       LibraryManager vbook = new WestminsterLibraryManger();
        int d= Integer.parseInt(dvdid);
        ((WestminsterLibraryManger) vbook).deletedvd(d);
        return ok("DVD has been Deleted");
   }

}

